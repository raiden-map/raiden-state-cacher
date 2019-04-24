package StateCacherEvent;

import StateCacherEvent.TokenNetworkDelta.SpecificSerdeManager;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.state.KeyValueBytesStoreSupplier;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

public abstract class StateCacherEvent {

    public StateCacherEvent(String toStreamTopic, StreamsBuilder builder) {
        this.toStreamTopic = toStreamTopic;
        this.builder = builder;
        specificSerdeManager = new SpecificSerdeManager(schemaRegistry);
        storeSupplier = Stores.inMemoryKeyValueStore(stateStoreName);
        storeBuilder = Stores.keyValueStoreBuilder(storeSupplier, Serdes.String(), specificSerdeManager.getTokenNetworkDeltaSerde());
        builder.addStateStore(storeBuilder);
    }

    public void run() {
    }

    protected SpecificSerdeManager specificSerdeManager;
    protected StreamsBuilder builder;
    protected final String stateStoreName = "stateStore-3";
    protected KeyValueBytesStoreSupplier storeSupplier;
    protected StoreBuilder<KeyValueStore<String, TokenNetworkDelta>> storeBuilder;
    protected final String toStreamTopic;
    protected final String topicTokenNetworkCreated = "raidenEvent.TokenNetworkCreated";
    protected final String topicChannelOpened = "raidenEvent.ChannelOpened";
    protected final String topicChannelClosed = "raidenEvent.ChannelClosed";
    protected final String topicChannelNewDeposit = "raidenEvent.ChannelNewDeposit";
    protected final String schemaRegistry = "http://raiden-sr-schema-registry.kafka.svc.cluster.local:8081";
}
