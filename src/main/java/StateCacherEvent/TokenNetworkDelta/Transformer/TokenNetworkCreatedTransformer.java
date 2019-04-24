package StateCacherEvent.TokenNetworkDelta.Transformer;

import RaidenMapTokenInfo.TokenInfoBuilder;
import io.raidenmap.event.tokenNetwork.TokenNetworkCreated;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Token;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Instant;
import java.util.Collections;

public class TokenNetworkCreatedTransformer extends ChannelTransformer implements Transformer<ProducerKey, TokenNetworkCreated, KeyValue<String, TokenNetworkDelta>> {

    public TokenNetworkCreatedTransformer(String storeName) {
        super(storeName, "TokenNetworkCreated");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        stateStore = (KeyValueStore) this.context.getStateStore(storeName);
    }

    @Override
    public KeyValue<String, TokenNetworkDelta> transform(ProducerKey producerKey, TokenNetworkCreated tokenNetworkCreated) {
        String address = tokenNetworkCreated.getTokenNetworkAddress().toString();
        Token token = TokenInfoBuilder.buildToken(address);
        TokenNetworkDelta tokenNetworkDelta = null;
        tokenNetworkDelta = stateStore.get(tokenNetworkCreated.getTokenNetworkAddress().toString());
        if( tokenNetworkDelta == null)
            tokenNetworkDelta = new TokenNetworkDelta(token, Collections.EMPTY_MAP, address, 0l, 0, 0, 0, 0, 0d, 0l, 0, 0l);

        tokenNetworkDelta.setTimestamp(Instant.now().toEpochMilli());
        tokenNetworkDelta.setBlockNumber(tokenNetworkCreated.getMetadata().getBlockNumber());

        stateStore.put(address, tokenNetworkDelta);

        return KeyValue.pair(address, tokenNetworkDelta);
    }

    @Override
    public void close() {

    }
}
