package StateCacherEvents.TokenNetworkDelta.Transformer;

import RaidenMapTokenInfo.TokenInfoBuilder;
import StateCacherEvents.StateStores;
import StateCacherEvents.TokenNetworkDelta.TokenNetworkDeltaPunctuator;
import io.raidenmap.event.tokenNetwork.TokenNetworkCreated;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.Token;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class TokenNetworkCreatedTransformer extends EventTransformer implements Transformer<ProducerKey, TokenNetworkCreated, KeyValue<Key, TokenNetworkDelta>> {

    public TokenNetworkCreatedTransformer() {
        super("TokenNetworkCreated");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        tokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.tokenNetworkDeltaStoreName);
        lightTokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.lightTokenNetworkDeltaStoreName);
        TokenNetworkDeltaPunctuator punctuator = new TokenNetworkDeltaPunctuator(limitModifiedChannelsMapSize, context, lightTokenNetworkDeltaStateStore);
        context.schedule(Duration.ofSeconds(punctuatorTimeInSeconds), PunctuationType.WALL_CLOCK_TIME, punctuator);
    }

    @Override
    public KeyValue<Key, TokenNetworkDelta> transform(ProducerKey producerKey, TokenNetworkCreated tokenNetworkCreated) {
        String address = tokenNetworkCreated.getTokenNetworkAddress().toString();
        Key key = new Key(address);
        Token token = TokenInfoBuilder.buildToken(tokenNetworkCreated.getTokenAddress().toString());

        TokenNetworkDelta tokenNetworkDelta = restoreTokenNetworkDelta(key, tokenNetworkDeltaStateStore);
        tokenNetworkDelta = initializeTokenNetworkDelta(tokenNetworkDelta, token, address);
        updateMetadata(tokenNetworkDelta, tokenNetworkCreated);
        tokenNetworkDeltaStateStore.put(key, tokenNetworkDelta);

        TokenNetworkDelta lightTokenNetworkDelta = restoreTokenNetworkDelta(key, lightTokenNetworkDeltaStateStore);
        lightTokenNetworkDelta = initializeTokenNetworkDelta(lightTokenNetworkDelta, token, address);
        updateMetadata(lightTokenNetworkDelta, tokenNetworkCreated);
        lightTokenNetworkDeltaStateStore.put(key, lightTokenNetworkDelta);

        return KeyValue.pair(key, lightTokenNetworkDelta);
    }

    @Override
    public void close() {

    }

    @Override
    protected void updateChannelEvent(TokenNetworkDelta tokenNetworkDelta, Object channelEvent) {

    }

    private TokenNetworkDelta initializeTokenNetworkDelta(TokenNetworkDelta tokenNetworkDelta, Token token, String address) {
        if (tokenNetworkDelta == null)
            return new TokenNetworkDelta(token, new HashMap<>(), address, 0l, 0, 0, 0, 0, 0d, 0l, 0, 0l);
        else
            return tokenNetworkDelta;
    }

    protected void updateMetadata(TokenNetworkDelta tokenNetworkDelta, TokenNetworkCreated tokenNetworkCreated) {
        tokenNetworkDelta.setTimestamp(Instant.now().toEpochMilli());
        tokenNetworkDelta.setBlockNumber(tokenNetworkCreated.getMetadata().getBlockNumber());
    }

}
