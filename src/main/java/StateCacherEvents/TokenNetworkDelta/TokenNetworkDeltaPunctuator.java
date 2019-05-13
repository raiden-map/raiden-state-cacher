package StateCacherEvents.TokenNetworkDelta;

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
    private boolean forceSending;
    private ProcessorContext context;
    private KeyValueStore<Key, TokenNetworkDelta> tokenNetworkDeltaStateStore;

    public TokenNetworkDeltaPunctuator(int limit,
                                       ProcessorContext context,
                                       KeyValueStore<Key, TokenNetworkDelta> keyValueStore) {
        this.limit = limit;
        this.context = context;
        this.tokenNetworkDeltaStateStore = keyValueStore;
        this.forceSending = false;
    }

    @Override
    public void punctuate(long timestamp) {
        KeyValueIterator<Key, TokenNetworkDelta> performanceIterator = tokenNetworkDeltaStateStore.all();

        while (performanceIterator.hasNext()) {
            KeyValue<Key, TokenNetworkDelta> keyValue = performanceIterator.next();
            Key key = keyValue.key;
            TokenNetworkDelta tokenNetworkDelta = keyValue.value;

            if (tokenNetworkDelta != null) {
                if (tokenNetworkDelta.getModifiedChannels().size() >= limit || forceSending){
                    if (tokenNetworkDelta.getModifiedChannels().size() != 0) {
                        context.forward(key, tokenNetworkDelta);
                        tokenNetworkDelta.setModifiedChannels(Collections.EMPTY_MAP);
                        tokenNetworkDeltaStateStore.put(key, tokenNetworkDelta);
                        forceSending = false;
                    }
                }
                else
                    forceSending = true;
            }
        }
    }
}


