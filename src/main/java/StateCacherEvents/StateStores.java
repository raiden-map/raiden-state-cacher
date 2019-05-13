package StateCacherEvents;

import io.raidenmap.statecacher.*;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.state.KeyValueBytesStoreSupplier;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

public class StateStores {
    public final static String userCountStoreName = "userCountStateStore2";
    public final static String tokenNetworkDeltaStoreName = "tokenNetworkDeltaStateStore";
    public final static String lightTokenNetworkDeltaStoreName = "light-" + tokenNetworkDeltaStoreName;
    public final static String tokenNetworkSnapshotStoreName = "tokenNetworkSnapshotStateStore";
    public final static String raidenDeltaStoreName = "raidenDeltaStateStore";
    public final static String raidenSnapshotStoreName = "raidenSnapshotStateStore";

    private static KeyValueBytesStoreSupplier tokenNetworkDeltaStoreSupplier;
    private static StoreBuilder<KeyValueStore<Key, TokenNetworkDelta>> tokenNetworkDeltaStoreBuilder;

    private static KeyValueBytesStoreSupplier lightTokenNetworkDeltaStoreSupplier;
    private static StoreBuilder<KeyValueStore<Key, TokenNetworkDelta>> lightTokenNetworkDeltaStoreBuilder;

    private static KeyValueBytesStoreSupplier tokenNetworkSnapshotStoreSupplier;
    private static StoreBuilder<KeyValueStore<Key, TokenNetworkSnapshot>> tokenNetworkSnapshotStoreBuilder;
    
    private static KeyValueBytesStoreSupplier userCountStoreSupplier;
    private static StoreBuilder<KeyValueStore<String, UserCount>> userCountStoreBuilder;

    private static KeyValueBytesStoreSupplier raidenDeltaStoreSupplier;
    private static StoreBuilder<KeyValueStore<Key, RaidenDelta>> raidenDeltaStoreBuilder;

    private static KeyValueBytesStoreSupplier raidenSnapshotStoreSupplier;
    private static StoreBuilder<KeyValueStore<Key, RaidenSnapshot>> raidenSnapshotStoreBuilder;
    
    private static final SpecificSerdeManager specificSerdeManager = new SpecificSerdeManager("http://raiden-sr-schema-registry.kafka.svc.cluster.local:8081");
    
    public static void addStateStore(StreamsBuilder builder){
        tokenNetworkDeltaStoreSupplier = Stores.inMemoryKeyValueStore(StateStores.tokenNetworkDeltaStoreName);
        tokenNetworkDeltaStoreBuilder = Stores.keyValueStoreBuilder(tokenNetworkDeltaStoreSupplier, specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde());
        builder.addStateStore(tokenNetworkDeltaStoreBuilder);

        lightTokenNetworkDeltaStoreSupplier = Stores.inMemoryKeyValueStore(StateStores.lightTokenNetworkDeltaStoreName);
        lightTokenNetworkDeltaStoreBuilder = Stores.keyValueStoreBuilder(lightTokenNetworkDeltaStoreSupplier, specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde());
        builder.addStateStore(lightTokenNetworkDeltaStoreBuilder);

        tokenNetworkSnapshotStoreSupplier = Stores.inMemoryKeyValueStore(StateStores.tokenNetworkSnapshotStoreName);
        tokenNetworkSnapshotStoreBuilder = Stores.keyValueStoreBuilder(tokenNetworkSnapshotStoreSupplier, specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkSnapshotSerde());
        builder.addStateStore(tokenNetworkSnapshotStoreBuilder);
        
        userCountStoreSupplier = Stores.inMemoryKeyValueStore(StateStores.userCountStoreName);
        userCountStoreBuilder = Stores.keyValueStoreBuilder(userCountStoreSupplier, Serdes.String(), specificSerdeManager.getUserCountSerde());
        builder.addStateStore(userCountStoreBuilder);

        raidenDeltaStoreSupplier = Stores.inMemoryKeyValueStore(StateStores.raidenDeltaStoreName);
        raidenDeltaStoreBuilder = Stores.keyValueStoreBuilder(raidenDeltaStoreSupplier, specificSerdeManager.getKeySerde(), specificSerdeManager.getRaidenDeltaSerde());
        builder.addStateStore(raidenDeltaStoreBuilder);

        raidenSnapshotStoreSupplier = Stores.inMemoryKeyValueStore(StateStores.raidenSnapshotStoreName);
        raidenSnapshotStoreBuilder = Stores.keyValueStoreBuilder(raidenSnapshotStoreSupplier, specificSerdeManager.getKeySerde(), specificSerdeManager.getRaidenSnapshotSerde());
        builder.addStateStore(raidenSnapshotStoreBuilder);
    }
}
