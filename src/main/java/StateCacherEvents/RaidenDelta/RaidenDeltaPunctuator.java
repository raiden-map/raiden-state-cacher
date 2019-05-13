package StateCacherEvents.RaidenDelta;

import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.RaidenDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.Punctuator;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.Collections;

public class RaidenDeltaPunctuator implements Punctuator {

    private int limitTokenNetworksChanges;
    private boolean forceSending;
    private ProcessorContext context;
    private KeyValueStore<Key, RaidenDelta> raidenDeltaKeyValueStore;

    public RaidenDeltaPunctuator(int limitTokenNetworksChanges, ProcessorContext context, KeyValueStore<Key, RaidenDelta> stateStore) {
        this.limitTokenNetworksChanges = limitTokenNetworksChanges;
        forceSending = false;
        this.context = context;
        this.raidenDeltaKeyValueStore = stateStore;
    }

    @Override
    public void punctuate(long timestamp) {
        KeyValueIterator<Key, RaidenDelta> performanceIterator = raidenDeltaKeyValueStore.all();

        while (performanceIterator.hasNext()) {
            KeyValue<Key, RaidenDelta> keyValue = performanceIterator.next();
            Key key = keyValue.key;
            RaidenDelta raidenDelta = keyValue.value;

            if (raidenDelta != null) {
                if (raidenDelta.getTokenNetworksChanges().size() >= limitTokenNetworksChanges || forceSending) {
                    if (raidenDelta.getTokenNetworksChanges().size() != 0) {
                        context.forward(key, raidenDelta);
                        raidenDelta.setTokenNetworksChanges(Collections.EMPTY_MAP);
                        raidenDeltaKeyValueStore.put(key, raidenDelta);
                        forceSending = false;
                    }
                } else
                    forceSending = true;
            }
        }
    }
}
