package StateCacherEvents.TokenNetworkSnapshot;

import StateCacherEvents.StateStores;
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

    protected KeyValueStore<Key, TokenNetworkSnapshot> tokenNetworkSnapshotKeyValueStore;
    protected ProcessorContext context;
    private int limitTokenNetworkDeltaArraySize;
    private int punctuatorTimeInSeconds;

    TokenNetworkDeltaTransformer() {
        limitTokenNetworkDeltaArraySize = 5;
        punctuatorTimeInSeconds = 15;
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        tokenNetworkSnapshotKeyValueStore = (KeyValueStore) this.context.getStateStore(StateStores.tokenNetworkSnapshotStoreName);
        TokenNetworkSnapshotPunctuator punctuator = new TokenNetworkSnapshotPunctuator(limitTokenNetworkDeltaArraySize, context, tokenNetworkSnapshotKeyValueStore);
        context.schedule(Duration.ofSeconds(punctuatorTimeInSeconds), PunctuationType.WALL_CLOCK_TIME, punctuator);
    }

    @Override
    public KeyValue<Key, TokenNetworkSnapshot> transform(Key key, TokenNetworkDelta tokenNetworkDelta) {
        TokenNetworkSnapshot tokenNetworkSnapshot = tokenNetworkSnapshotKeyValueStore.get(key);
        tokenNetworkSnapshot = updateTokenNetworkSnapshot(tokenNetworkSnapshot, tokenNetworkDelta);
        tokenNetworkSnapshotKeyValueStore.put(key, tokenNetworkSnapshot);
        return KeyValue.pair(key, tokenNetworkSnapshot);
    }

    @Override
    public void close() {

    }

    private TokenNetworkSnapshot updateTokenNetworkSnapshot(TokenNetworkSnapshot tokenNetworkSnapshot, TokenNetworkDelta tokenNetworkDelta) {
        if (tokenNetworkSnapshot == null) {
            List<TokenNetworkDelta> deltas = new ArrayList<>();
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
            updateChannelList(tokenNetworkSnapshot, tokenNetworkDelta);
            return tokenNetworkSnapshot;
        } else {
            tokenNetworkSnapshot.getTokenNetworkDeltas().add(tokenNetworkDelta);
            updateChannelList(tokenNetworkSnapshot, tokenNetworkDelta);
            tokenNetworkSnapshot.setBlockNumber(tokenNetworkDelta.getBlockNumber());
            tokenNetworkSnapshot.setStateTimestamp(Instant.now().toEpochMilli());
            tokenNetworkSnapshot.setUsers(tokenNetworkDelta.getUsers());
            tokenNetworkSnapshot.setTotalDeposit(tokenNetworkDelta.getTotalDeposit());
            tokenNetworkSnapshot.setAvgChannelDeposit(tokenNetworkDelta.getAvgChannelDeposit());
            tokenNetworkSnapshot.setBlockNumber(tokenNetworkDelta.getBlockNumber());
            return tokenNetworkSnapshot;
        }
    }

    private void updateChannelList(TokenNetworkSnapshot tokenNetworkSnapshot, TokenNetworkDelta tokenNetworkDelta) {
        Map<String, Channel> tmpChannels = tokenNetworkDelta.getModifiedChannels();
        for (Channel i : tmpChannels.values()) {
            if (!i.getState().equals("ChannelSettled"))
                tokenNetworkSnapshot.getChannels().put(i.getChannelId().toString(), i);
            else
                tokenNetworkSnapshot.getChannels().remove(i.getChannelId().toString());
        }
    }
}
