package StateCacherEvent.TokenNetworkSnapshot;

import StateCacherEvent.StateCacherEvent;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkSnapshot;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueBytesStoreSupplier;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

public class TokenNetworkSnapshotEvent extends StateCacherEvent {

    public TokenNetworkSnapshotEvent(String toStreamTopic, StreamsBuilder builder) {
        super(toStreamTopic, builder);
        storeSupplier = Stores.inMemoryKeyValueStore(stateStoreName);
        storeBuilder = Stores.keyValueStoreBuilder(storeSupplier, specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkSnapshotSerde());
        builder.addStateStore(storeBuilder);
    }

    @Override
    public void run() {
        consumeFromTokenNetworkDeltaTopic();
    }

    private void consumeFromTokenNetworkDeltaTopic() {
        tokenNetworkSnapshotEventStream = builder.stream(topicTokenNetworkDelta, Consumed.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()))
                .transform(() -> new TokenNetworkDeltaTransformer(stateStoreName), stateStoreName);
        tokenNetworkSnapshotEventStream.to(toStreamTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkSnapshotSerde()));
    }

    private KStream<Key, TokenNetworkSnapshot> tokenNetworkSnapshotEventStream;

    protected final String stateStoreName = "tokenNetworkSnapshotStateStore";
    protected KeyValueBytesStoreSupplier storeSupplier;
    protected StoreBuilder<KeyValueStore<Key, TokenNetworkSnapshot>> storeBuilder;

    protected final String topicTokenNetworkDelta = "tokenNetworkDeltaTest0";//TODO: CHANGE NAME WITH "raidenEvent.TokenNetworkDelta"

}
