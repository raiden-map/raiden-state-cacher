package StateCacherEvent.TokenNetworkSnapshot;

import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkSnapshot;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.Punctuator;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.Collections;

public class TokenNetworkSnapshotPunctuator implements Punctuator {

    private int limit;
    private ProcessorContext context;
    private KeyValueStore<Key, TokenNetworkSnapshot> stateStore;

    public TokenNetworkSnapshotPunctuator(int limit,
                                          ProcessorContext context,
                                          KeyValueStore<Key, TokenNetworkSnapshot> keyValueStore) {
        this.limit = limit;
        this.context = context;
        this.stateStore = keyValueStore;
    }

    @Override
    public void punctuate(long timestamp) {
        KeyValueIterator<Key, TokenNetworkSnapshot> performanceIterator = stateStore.all();

        while (performanceIterator.hasNext()) {
            KeyValue<Key, TokenNetworkSnapshot> keyValue = performanceIterator.next();
            Key key = keyValue.key;
            TokenNetworkSnapshot tokenNetworkSnapshot = keyValue.value;

            if (tokenNetworkSnapshot != null) {
                if (tokenNetworkSnapshot.getTokenNetworkDeltas().size() >= limit) {
                    context.forward(key, tokenNetworkSnapshot);
                    tokenNetworkSnapshot.setTokenNetworkDeltas(Collections.EMPTY_LIST);
                    stateStore.put(key, tokenNetworkSnapshot);
                }
            }
        }
    }
}


