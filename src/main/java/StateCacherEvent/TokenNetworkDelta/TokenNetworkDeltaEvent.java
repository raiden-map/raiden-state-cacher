package StateCacherEvent.TokenNetworkDelta;

import StateCacherEvent.StateCacherEvent;
import StateCacherEvent.TokenNetworkDelta.Transformer.ChannelClosedTransformer;
import StateCacherEvent.TokenNetworkDelta.Transformer.ChannelNewDepositTransformer;
import StateCacherEvent.TokenNetworkDelta.Transformer.ChannelOpenedTransformer;
import StateCacherEvent.TokenNetworkDelta.Transformer.TokenNetworkCreatedTransformer;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
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
    }

    @Override
    public void run() {
        consumeFromTokenNetworkCreatedTopic();
        consumeFromChannelOpenedTopic();
        consumeFromChannelNewDepositTopic();
        consumeFromChannelClosedTopic();
    }

    private void consumeFromTokenNetworkCreatedTopic() {
        tokenNetworkDeltaStream = builder.stream(topicTokenNetworkCreated, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getTokenNetworkCreatedSerde()))
                .transform(() -> new TokenNetworkCreatedTransformer(stateStoreName), stateStoreName);
        tokenNetworkDeltaStream.print(Printed.toSysOut());
    }

    private void consumeFromChannelOpenedTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelOpened, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelOpenedSerde()))
                .transform(() -> new ChannelOpenedTransformer(stateStoreName), stateStoreName);
        tokenNetworkDeltaStream.print(Printed.toSysOut());
    }

    private void consumeFromChannelNewDepositTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelNewDeposit, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelNewDepositSerde()))
                .transform(() -> new ChannelNewDepositTransformer(stateStoreName), stateStoreName);
        tokenNetworkDeltaStream.print(Printed.toSysOut());
    }

    private void consumeFromChannelClosedTopic(){
        tokenNetworkDeltaStream = builder.stream(topicChannelClosed, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelClosedSerde()))
                .transform(() -> new ChannelClosedTransformer(stateStoreName), stateStoreName);
        tokenNetworkDeltaStream.print(Printed.toSysOut());
    }

    private KStream<String, TokenNetworkDelta> tokenNetworkDeltaStream;

}
