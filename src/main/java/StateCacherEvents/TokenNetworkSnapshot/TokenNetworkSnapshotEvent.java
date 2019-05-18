package StateCacherEvents.TokenNetworkSnapshot;

import StateCacherEvents.Topics;
import StateCacherEvents.StateStores;
import StateCacherEvents.StateCacherEvent;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkSnapshot;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;

public class TokenNetworkSnapshotEvent extends StateCacherEvent{

    public TokenNetworkSnapshotEvent(StreamsBuilder builder) {
        super(builder);
    }

    @Override
    public void run() {
        consumeFromTokenNetworkDeltaTopic();
    }

    private void consumeFromTokenNetworkDeltaTopic() {
        tokenNetworkSnapshotEventStream = builder.stream(Topics.tokenNetworkDeltaTopic, Consumed.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()))
                .transform(TokenNetworkDeltaTransformer::new, StateStores.tokenNetworkSnapshotStoreName);
        //tokenNetworkSnapshotEventStream.print(Printed.<Key, TokenNetworkSnapshot>toSysOut().withLabel("TOKEN NETWORK SNAPSHOT"));
        tokenNetworkSnapshotEventStream.to(Topics.tokenNetworkSnapshotTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkSnapshotSerde()));
    }

    private KStream<Key, TokenNetworkSnapshot> tokenNetworkSnapshotEventStream;



}
