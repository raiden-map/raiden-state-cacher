package StateCacherEvents.RaidenSnapshot;

import StateCacherEvents.StateCacherEvent;
import StateCacherEvents.StateStores;
import StateCacherEvents.Topics;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.RaidenSnapshot;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;

public class RaidenSnapshotEvent extends StateCacherEvent {

    public RaidenSnapshotEvent(StreamsBuilder builder) {
        super(builder);
    }

    @Override
    public void run() {
        consumeFromRaidenDeltaTopic();
        consumeFromEndpointTopic();
    }

    private void consumeFromRaidenDeltaTopic() {
        raidenSnapshotStream = builder.stream(Topics.raidenDeltaTopic, Consumed.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getRaidenDeltaSerde()))
                .transform(RaidenDeltaTransformer::new, StateStores.raidenSnapshotStoreName);
        raidenSnapshotStream.print(Printed.<Key, RaidenSnapshot>toSysOut().withLabel("RAIDEN SNAPSHOT"));
        //raidenSnapshotStream.to(Topics.raidenSnapshotTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getRaidenSnapshotSerde()));

    }

    private void consumeFromEndpointTopic() {
        raidenSnapshotStream = builder.stream(topicEndpoint, Consumed.with(specificSerdeManager.getProducerKeySerde(), specificSerdeManager.getAddressRegisteredSerde()))
                .transform(EndpointTransformer::new, StateStores.raidenSnapshotStoreName);
        raidenSnapshotStream.print(Printed.<Key, RaidenSnapshot>toSysOut().withLabel("RAIDEN SNAPSHOT"));
        //raidenSnapshotStream.to(Topics.raidenSnapshotTopic, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getRaidenSnapshotSerde()));
    }

    private KStream<Key, RaidenSnapshot> raidenSnapshotStream;

}
