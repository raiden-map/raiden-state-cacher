package StateCacherEvent.TokenNetworkDelta;

import StateCacherEvent.StateCacherEvent;
import StateCacherEvent.TokenNetworkDelta.Transformer.ChannelClosedTransformer;
import StateCacherEvent.TokenNetworkDelta.Transformer.ChannelNewDepositTransformer;
import StateCacherEvent.TokenNetworkDelta.Transformer.ChannelOpenedTransformer;
import StateCacherEvent.TokenNetworkDelta.Transformer.TokenNetworkCreatedTransformer;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import io.raidenmap.statecacher.UserCount;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueBytesStoreSupplier;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

public class TokenNetworkDeltaEvent extends StateCacherEvent {

    public TokenNetworkDeltaEvent(String toStreamTopic, StreamsBuilder builder) {
        super(toStreamTopic, builder);

        storeSupplier = Stores.inMemoryKeyValueStore(stateStoreName);
        storeBuilder = Stores.keyValueStoreBuilder(storeSupplier, specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde());
        builder.addStateStore(storeBuilder);

        lightStoreSupplier = Stores.inMemoryKeyValueStore(lightStateStoreName);
        lightStoreBuilder = Stores.keyValueStoreBuilder(lightStoreSupplier, specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde());
        builder.addStateStore(lightStoreBuilder);

        userCountStoreSupplier = Stores.inMemoryKeyValueStore(userCountStateStoreName);
        userCountStoreBuilder = Stores.keyValueStoreBuilder(userCountStoreSupplier, Serdes.String(), specificSerdeManager.getUserCountSerde());
        builder.addStateStore(userCountStoreBuilder);
    }

    @Override
    public void run() {
        consumeFromTokenNetworkCreatedTopic();
        consumeFromChannelOpenedTopic();
        consumeFromChannelNewDepositTopic();
        consumeFromChannelClosedTopic();
        consumeFromChannelSettledTopic();
    }

    private void consumeFromTokenNetworkCreatedTopic() {
        tokenNetworkDeltaStream = builder.stream(topicTokenNetworkCreated, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getTokenNetworkCreatedSerde()))
                .transform(() -> new TokenNetworkCreatedTransformer(stateStoreName), stateStoreName, lightStateStoreName);
        //tokenNetworkDeltaStream.print(Printed.toSysOut());
        tokenNetworkDeltaStream.to(toStreamTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    }

    private void consumeFromChannelOpenedTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelOpened, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelOpenedSerde()))
                .transform(() -> new ChannelOpenedTransformer(stateStoreName), stateStoreName, lightStateStoreName, userCountStateStoreName);
        //tokenNetworkDeltaStream.to(toStreamTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    }

    private void consumeFromChannelNewDepositTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelNewDeposit, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelNewDepositSerde()))
                .transform(() -> new ChannelNewDepositTransformer(stateStoreName), stateStoreName, lightStateStoreName);
        tokenNetworkDeltaStream.to(toStreamTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    }

    private void consumeFromChannelClosedTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelClosed, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelClosedSerde()))
                .transform(() -> new ChannelClosedTransformer(stateStoreName), stateStoreName, lightStateStoreName);
        tokenNetworkDeltaStream.to(toStreamTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    private void consumeFromChannelSettledTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelSettled, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelSettledSerde()))
                .transform(() -> new ChannelSettledTransformer(stateStoreName), stateStoreName, lightStateStoreName, userCountStateStoreName);
        //tokenNetworkDeltaStream.to(toStreamTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    }

    private KStream<Key, TokenNetworkDelta> tokenNetworkDeltaStream;

    protected final String stateStoreName = "tokenNetworkDeltaStateStore";
    protected KeyValueBytesStoreSupplier storeSupplier;
    protected StoreBuilder<KeyValueStore<Key, TokenNetworkDelta>> storeBuilder;

    protected final String lightStateStoreName = "light-" + stateStoreName;
    protected KeyValueBytesStoreSupplier lightStoreSupplier;
    protected StoreBuilder<KeyValueStore<Key, TokenNetworkDelta>> lightStoreBuilder;

    protected final String userCountStateStoreName = "userCountStateStore2";
    protected KeyValueBytesStoreSupplier userCountStoreSupplier;
    protected StoreBuilder<KeyValueStore<String, UserCount>> userCountStoreBuilder;

    protected final String topicTokenNetworkCreated = "raidenEvent.TokenNetworkCreated";
    protected final String topicChannelOpened = "raidenEvent.ChannelOpened";
    protected final String topicChannelClosed = "raidenEvent.ChannelClosed";
    protected final String topicChannelNewDeposit = "raidenEvent.ChannelNewDeposit";
    protected final String topicChannelSettled = "raidenEvent.ChannelSettled";
}
