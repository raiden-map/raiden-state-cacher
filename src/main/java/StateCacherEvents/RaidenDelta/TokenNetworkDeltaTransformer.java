package StateCacherEvents.RaidenDelta;

import RaidenMapTokenInfo.TokenInfoBuilder;
import StateCacherEvents.StateStores;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.RaidenDelta;
import io.raidenmap.statecacher.TokenNetworkDelta;
import io.raidenmap.statecacher.UserCount;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;
import org.glassfish.jersey.internal.guava.Iterators;
import org.json.JSONException;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class TokenNetworkDeltaTransformer implements Transformer<Key, TokenNetworkDelta, KeyValue<Key, RaidenDelta>> {

    private KeyValueStore<Key, TokenNetworkDelta> tokenNetworkDeltaKeyValueStore;
    private KeyValueStore<Key, UserCount> userCountKeyValueStore;
    private KeyValueStore<Key, RaidenDelta> raidenDeltaKeyValueStore;
    protected ProcessorContext context;
    private Key raidenDeltaKey;
    private int limitTokenNetworkDeltaArraySize;
    private int punctuatorTimeInSeconds;

    TokenNetworkDeltaTransformer() {
        raidenDeltaKey = new Key("raidenDelta");
        limitTokenNetworkDeltaArraySize = 1;
        punctuatorTimeInSeconds = 10;
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        raidenDeltaKeyValueStore = (KeyValueStore) this.context.getStateStore(StateStores.raidenDeltaStoreName);
        userCountKeyValueStore = (KeyValueStore) this.context.getStateStore(StateStores.userCountStoreName);
        tokenNetworkDeltaKeyValueStore = (KeyValueStore) this.context.getStateStore(StateStores.tokenNetworkDeltaStoreName);

        RaidenDeltaPunctuator punctuator = new RaidenDeltaPunctuator(limitTokenNetworkDeltaArraySize, context, raidenDeltaKeyValueStore);
        context.schedule(Duration.ofSeconds(punctuatorTimeInSeconds), PunctuationType.WALL_CLOCK_TIME, punctuator);
    }

    @Override
    public KeyValue<Key, RaidenDelta> transform(Key key, TokenNetworkDelta tokenNetworkDelta) {
        RaidenDelta raidenDelta = raidenDeltaKeyValueStore.get(raidenDeltaKey);
        raidenDelta = updateRaidenDelta(raidenDelta, tokenNetworkDelta);
        raidenDeltaKeyValueStore.put(key, raidenDelta);
        return KeyValue.pair(key, raidenDelta);
    }

    private RaidenDelta updateRaidenDelta(RaidenDelta raidenDelta, TokenNetworkDelta tokenNetworkDelta) {
        if (raidenDelta == null) {
            raidenDelta = new RaidenDelta(0, 0, 0l, 0l, 0f, 0f, new HashMap<>());
            raidenDelta.setTokenNetworksChanges(new HashMap<String, TokenNetworkDelta>());
        }
        updateTokenNetworkData(raidenDelta, tokenNetworkDelta);
        updateMetadata(raidenDelta, tokenNetworkDelta);
        updatePrice(raidenDelta);

        return raidenDelta;
    }

    private void updateMetadata(RaidenDelta raidenDelta, TokenNetworkDelta tokenNetworkDelta) {
        raidenDelta.setBlockNumber(tokenNetworkDelta.getBlockNumber());
        raidenDelta.setTimestamp(Instant.now().toEpochMilli());
    }

    private void updateTokenNetworkData(RaidenDelta raidenDelta, TokenNetworkDelta tokenNetworkDelta) {
        raidenDelta.getTokenNetworksChanges().put(tokenNetworkDelta.getTokenNetworkAddress().toString(), tokenNetworkDelta);
        int userInc = tokenNetworkDelta.getUsers() - raidenDelta.getUserCount();
        raidenDelta.setUserCount(raidenDelta.getUserCount() + userInc);
        raidenDelta.setTokenNetworksCount(Iterators.size(tokenNetworkDeltaKeyValueStore.all()));
    }

    private void updatePrice(RaidenDelta raidenDelta) {
        float btcValue = -1;
        float ethValue = -1;
        try {
            btcValue = TokenInfoBuilder.getPrice("bitcoin", "usd").floatValue();
            ethValue = TokenInfoBuilder.getPrice("ethereum", "usd").floatValue();
        } catch (JSONException e) {
            System.out.println("INPUT ERROR");
        }
        raidenDelta.setBtcValue(btcValue);
        raidenDelta.setEthValue(ethValue);
    }

    @Override
    public void close() {

    }
}
