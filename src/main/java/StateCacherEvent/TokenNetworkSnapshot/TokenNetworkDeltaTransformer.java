package StateCacherEvent.TokenNetworkSnapshot;

import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import io.raidenmap.statecacher.TokenNetworkSnapshot;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class TokenNetworkDeltaTransformer implements Transformer<Key, TokenNetworkDelta, KeyValue<Key, TokenNetworkSnapshot>> {

    protected KeyValueStore<Key, TokenNetworkSnapshot> stateStore;
    protected String storeName;
    protected ProcessorContext context;
    private int limitTokenNetworkDeltaArraySize = 5;
    private int punctuatorTimeInSeconds = 15;

    public TokenNetworkDeltaTransformer(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        stateStore = (KeyValueStore) this.context.getStateStore(storeName);
        TokenNetworkSnapshotPunctuator punctuator = new TokenNetworkSnapshotPunctuator(limitTokenNetworkDeltaArraySize, context, stateStore);
        context.schedule(Duration.ofSeconds(punctuatorTimeInSeconds), PunctuationType.WALL_CLOCK_TIME, punctuator);
    }

    @Override
    public KeyValue<Key, TokenNetworkSnapshot> transform(Key key, TokenNetworkDelta tokenNetworkDelta) {
        TokenNetworkSnapshot tokenNetworkSnapshot = stateStore.get(key);
        tokenNetworkSnapshot = updateTokenNetworkSnapshot(tokenNetworkSnapshot, tokenNetworkDelta);
        stateStore.put(key, tokenNetworkSnapshot);
        return KeyValue.pair(key, tokenNetworkSnapshot);
    }

    @Override
    public void close() {

    }

    private TokenNetworkSnapshot updateTokenNetworkSnapshot(TokenNetworkSnapshot tokenNetworkSnapshot, TokenNetworkDelta tokenNetworkDelta) {
        if (tokenNetworkSnapshot == null) {
            List deltas = new ArrayList();
            deltas.add(tokenNetworkDelta);
            tokenNetworkSnapshot = new TokenNetworkSnapshot(
                    tokenNetworkDelta.getTokenNetworkAddress().toString(),
                    deltas,
                    tokenNetworkDelta.getBlockNumber(),
                    Instant.now().toEpochMilli(),
                    tokenNetworkDelta.getBlockNumber(),
                    Instant.now().toEpochMilli(),
                    tokenNetworkDelta.getToken(),
                    tokenNetworkDelta.getAvgChannelDeposit(),
                    tokenNetworkDelta.getTotalDeposit(),
                    0,
                    tokenNetworkDelta.getBlockNumber(),
                    new HashMap<>(),
                    new ArrayList<>(),
                    "");
            tokenNetworkSnapshot = updateChannelList(tokenNetworkSnapshot, tokenNetworkDelta);
            return tokenNetworkSnapshot;
        } else {
            tokenNetworkSnapshot.getTokenNetworkDeltas().add(tokenNetworkDelta);
            tokenNetworkSnapshot = updateChannelList(tokenNetworkSnapshot, tokenNetworkDelta);
            tokenNetworkSnapshot.setBlockNumber(tokenNetworkDelta.getBlockNumber());
            tokenNetworkSnapshot.setStateTimestamp(Instant.now().toEpochMilli());
            tokenNetworkSnapshot.setUsers(tokenNetworkDelta.getUsers());
            tokenNetworkSnapshot.setTotalDeposit(tokenNetworkDelta.getTotalDeposit());
            tokenNetworkSnapshot.setAvgChannelDeposit(tokenNetworkDelta.getAvgChannelDeposit());
            tokenNetworkSnapshot.setBlockNumber(tokenNetworkDelta.getBlockNumber());
            return tokenNetworkSnapshot;
        }
    }

    private TokenNetworkSnapshot updateChannelList(TokenNetworkSnapshot tokenNetworkSnapshot, TokenNetworkDelta tokenNetworkDelta) {
        Map<String, Channel> tmpChannels = tokenNetworkDelta.getModifiedChannels();
        for (Channel i : tmpChannels.values()) {
            if (!i.getState().equals("ChannelSettled"))
                tokenNetworkSnapshot.getChannels().put(i.getChannelId().toString(), i);
            else
                tokenNetworkSnapshot.getChannels().remove(i.getChannelId().toString());
        }
        return tokenNetworkSnapshot;
    }
}
