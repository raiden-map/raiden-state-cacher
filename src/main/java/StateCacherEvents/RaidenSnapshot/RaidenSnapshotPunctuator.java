package StateCacherEvents.RaidenSnapshot;

import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.RaidenSnapshot;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.Punctuator;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.Collections;

public class RaidenSnapshotPunctuator implements Punctuator {

    private int limitRaidenDeltaArraySize;
    private boolean forceSending;
    private ProcessorContext context;
    private KeyValueStore<Key, RaidenSnapshot> stateStore;

    public RaidenSnapshotPunctuator(int limitRaidenDeltaArraySize, ProcessorContext context, KeyValueStore<Key, RaidenSnapshot> stateStore) {
        this.limitRaidenDeltaArraySize = limitRaidenDeltaArraySize;
        this.forceSending = false;
        this.context = context;
        this.stateStore = stateStore;
    }

    @Override
    public void punctuate(long timestamp) {
        KeyValueIterator<Key, RaidenSnapshot> performanceIterator = stateStore.all();

        while (performanceIterator.hasNext()) {
            KeyValue<Key, RaidenSnapshot> keyValue = performanceIterator.next();
            Key key = keyValue.key;
            RaidenSnapshot raidenSnapshot = keyValue.value;

            if (raidenSnapshot != null) {
                if (raidenSnapshot.getStates().size() >= limitRaidenDeltaArraySize || forceSending) {
                    if (raidenSnapshot.getStates().size() != 0) {
                        context.forward(key, raidenSnapshot);
                        raidenSnapshot.setTokenNetworks(Collections.EMPTY_MAP);
                        raidenSnapshot.setStates(Collections.EMPTY_LIST);
                        raidenSnapshot.setEndpoints(Collections.EMPTY_LIST);
                        stateStore.put(key, raidenSnapshot);
                        forceSending = false;
                    }
                }
                else
                    forceSending = true;
            }
        }
    }
}
