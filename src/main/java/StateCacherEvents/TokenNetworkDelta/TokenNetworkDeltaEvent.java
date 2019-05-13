package StateCacherEvents.TokenNetworkDelta;

import StateCacherEvents.StateStores;
import StateCacherEvents.StateCacherEvent;
import StateCacherEvents.TokenNetworkDelta.Transformer.*;
import StateCacherEvents.Topics;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;


public class TokenNetworkDeltaEvent extends StateCacherEvent {

    public TokenNetworkDeltaEvent(StreamsBuilder builder) {
        super(builder);
    }

    @Override
    public void run() {
        consumeFromTokenNetworkCreatedTopic();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumeFromChannelOpenedTopic();
        consumeFromChannelNewDepositTopic();
        consumeFromChannelClosedTopic();
        consumeFromChannelSettledTopic();
    }

    private void consumeFromTokenNetworkCreatedTopic() {
        tokenNetworkDeltaStream = builder.stream(topicTokenNetworkCreated, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getTokenNetworkCreatedSerde()))
                .transform(TokenNetworkCreatedTransformer::new, StateStores.tokenNetworkDeltaStoreName, StateStores.lightTokenNetworkDeltaStoreName);
        //tokenNetworkDeltaStream.print(Printed.<Key, TokenNetworkDelta>toSysOut().withLabel(" TOKEN NETWORK DELTA"));
        tokenNetworkDeltaStream.to(Topics.tokenNetworkDeltaTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    }

    private void consumeFromChannelOpenedTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelOpened, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelOpenedSerde()))
                .transform(ChannelOpenedTransformer::new, StateStores.tokenNetworkDeltaStoreName, StateStores.lightTokenNetworkDeltaStoreName, StateStores.userCountStoreName);
        tokenNetworkDeltaStream.to(Topics.tokenNetworkDeltaTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    }

    private void consumeFromChannelNewDepositTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelNewDeposit, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelNewDepositSerde()))
                .transform(ChannelNewDepositTransformer::new, StateStores.tokenNetworkDeltaStoreName, StateStores.lightTokenNetworkDeltaStoreName);
        tokenNetworkDeltaStream.to(Topics.tokenNetworkDeltaTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    }

    private void consumeFromChannelClosedTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelClosed, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelClosedSerde()))
                .transform(ChannelClosedTransformer::new, StateStores.tokenNetworkDeltaStoreName, StateStores.lightTokenNetworkDeltaStoreName);
        tokenNetworkDeltaStream.to(Topics.tokenNetworkDeltaTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    }

    private void consumeFromChannelSettledTopic() {
        tokenNetworkDeltaStream = builder.stream(topicChannelSettled, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getChannelSettledSerde()))
                .transform(ChannelSettledTransformer::new, StateStores.tokenNetworkDeltaStoreName, StateStores.lightTokenNetworkDeltaStoreName, StateStores.userCountStoreName);
        tokenNetworkDeltaStream.to(Topics.tokenNetworkDeltaTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()));
    }

    private KStream<Key, TokenNetworkDelta> tokenNetworkDeltaStream;
}
