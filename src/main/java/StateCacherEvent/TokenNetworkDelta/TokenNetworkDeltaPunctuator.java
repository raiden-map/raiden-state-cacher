package StateCacherEvent.TokenNetworkDelta;

import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.Punctuator;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.Collections;

public class TokenNetworkDeltaPunctuator implements Punctuator {

    private int limit;
    private ProcessorContext context;
    private KeyValueStore<Key, TokenNetworkDelta> stateStore;

    public TokenNetworkDeltaPunctuator(int limit,
                                       ProcessorContext context,
                                       KeyValueStore<Key, TokenNetworkDelta> keyValueStore) {
        this.limit = limit;
        this.context = context;
        this.stateStore = keyValueStore;
    }

    @Override
    public void punctuate(long timestamp) {
        KeyValueIterator<Key, TokenNetworkDelta> performanceIterator = stateStore.all();

        while (performanceIterator.hasNext()) {
            KeyValue<Key, TokenNetworkDelta> keyValue = performanceIterator.next();
            Key key = keyValue.key;
            TokenNetworkDelta tokenNetworkDelta = keyValue.value;

            if (tokenNetworkDelta != null) {
                if (tokenNetworkDelta.getModifiedChannels().size() >= limit) {
                    context.forward(key, tokenNetworkDelta);
                    tokenNetworkDelta.setModifiedChannels(Collections.EMPTY_MAP);
                    stateStore.put(key, tokenNetworkDelta);
                }
            }
        }
    }
}


