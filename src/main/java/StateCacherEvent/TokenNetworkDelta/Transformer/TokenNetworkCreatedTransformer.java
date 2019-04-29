package StateCacherEvent.TokenNetworkDelta.Transformer;

import RaidenMapTokenInfo.TokenInfoBuilder;
import StateCacherEvent.TokenNetworkDelta.TokenNetworkDeltaPunctuator;
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
import java.util.Collections;

public class TokenNetworkCreatedTransformer extends EventTransformer implements Transformer<ProducerKey, TokenNetworkCreated, KeyValue<Key, TokenNetworkDelta>> {

    public TokenNetworkCreatedTransformer(String storeName) {
        super(storeName, "TokenNetworkCreated");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        stateStore = (KeyValueStore) this.context.getStateStore(storeName);
        lightStateStore = (KeyValueStore) this.context.getStateStore(lightStoreName);
        TokenNetworkDeltaPunctuator punctuator = new TokenNetworkDeltaPunctuator(10, context, lightStateStore);
        context.schedule(Duration.ofSeconds(10), PunctuationType.WALL_CLOCK_TIME, punctuator);
    }

    @Override
    public KeyValue<Key, TokenNetworkDelta> transform(ProducerKey producerKey, TokenNetworkCreated tokenNetworkCreated) {
        String address = tokenNetworkCreated.getTokenNetworkAddress().toString();
        Key key = new Key(address);
        Token token = TokenInfoBuilder.buildToken(address);

        TokenNetworkDelta tokenNetworkDelta = restoreTokenNetworkDelta(key, stateStore);
        tokenNetworkDelta = initializeTokenNetworkDelta(tokenNetworkDelta, token, address);
        updateMetadata(tokenNetworkDelta, tokenNetworkCreated);
        stateStore.put(key, tokenNetworkDelta);

        TokenNetworkDelta lightTokenNetworkDelta = restoreTokenNetworkDelta(key, lightStateStore);
        lightTokenNetworkDelta = initializeTokenNetworkDelta(lightTokenNetworkDelta, token, address);
        updateMetadata(lightTokenNetworkDelta, tokenNetworkCreated);
        lightStateStore.put(key, lightTokenNetworkDelta);

        return KeyValue.pair(key, lightTokenNetworkDelta);
    }

    @Override
    public void close() {

    }
}
