package StateCacherEvents.RaidenSnapshot;

import StateCacherEvents.StateStores;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.RaidenDelta;
import io.raidenmap.statecacher.RaidenSnapshot;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

public class RaidenDeltaTransformer implements Transformer<Key, RaidenDelta, KeyValue<Key, RaidenSnapshot>> {
    protected KeyValueStore<Key, RaidenSnapshot> raidenSnapshotKeyValueStore;
    protected ProcessorContext context;
    private Key raidenSnapshotKey;
    private int limitTokenNetworkDeltaArraySize;
    private int punctuatorTimeInSeconds;

    public RaidenDeltaTransformer() {
        raidenSnapshotKey = new Key("raidenSnapshotKey");
        limitTokenNetworkDeltaArraySize = 1;
        punctuatorTimeInSeconds = 10;
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        raidenSnapshotKeyValueStore = (KeyValueStore) this.context.getStateStore(StateStores.raidenSnapshotStoreName);
        RaidenSnapshotPunctuator punctuator = new RaidenSnapshotPunctuator(limitTokenNetworkDeltaArraySize, context, raidenSnapshotKeyValueStore);
        context.schedule(Duration.ofSeconds(punctuatorTimeInSeconds), PunctuationType.WALL_CLOCK_TIME, punctuator);
    }

    @Override
    public KeyValue<Key, RaidenSnapshot> transform(Key key, RaidenDelta raidenDelta) {
        RaidenSnapshot raidenSnapshot = raidenSnapshotKeyValueStore.get(raidenSnapshotKey);
        raidenSnapshot = updateRaidenSnapshot(raidenSnapshot, raidenDelta);
        raidenSnapshotKeyValueStore.put(raidenSnapshotKey, raidenSnapshot);
        return KeyValue.pair(raidenSnapshotKey, raidenSnapshot);
    }

    private RaidenSnapshot updateRaidenSnapshot(RaidenSnapshot raidenSnapshot, RaidenDelta raidenDelta) {
        if (raidenSnapshot == null)
            raidenSnapshot = new RaidenSnapshot(new ArrayList<>(), new HashMap<>(), new ArrayList<>(), 0l, 0l, "");

        updateDelta(raidenSnapshot, raidenDelta);
        updateMetadata(raidenSnapshot, raidenDelta);

        return raidenSnapshot;
    }

    private void updateDelta(RaidenSnapshot raidenSnapshot, RaidenDelta raidenDelta) {
        raidenSnapshot.getStates().add(raidenDelta);
        HashMap<String, TokenNetworkDelta> raidenDeltaTokenNetworksChanges = (HashMap<String, TokenNetworkDelta>) raidenDelta.getTokenNetworksChanges();
        raidenSnapshot.getTokenNetworks().forEach(raidenDeltaTokenNetworksChanges::put);
    }

    private void updateMetadata(RaidenSnapshot raidenSnapshot, RaidenDelta raidenDelta) {
        raidenSnapshot.setBlockNumber(raidenDelta.getBlockNumber());
        raidenSnapshot.setTimestamp(Instant.now().toEpochMilli());
    }

    @Override
    public void close() {

    }
}
