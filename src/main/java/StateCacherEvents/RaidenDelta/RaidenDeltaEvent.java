package StateCacherEvents.RaidenDelta;

import StateCacherEvents.StateStores;
import StateCacherEvents.Topics;
import StateCacherEvents.StateCacherEvent;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.RaidenDelta;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;

public class RaidenDeltaEvent extends StateCacherEvent {

    public RaidenDeltaEvent(StreamsBuilder builder) {
        super(builder);
    }

    @Override
    public void run() {
        consumeFromTokenNetworkDeltaTopic();
    }

    private void consumeFromTokenNetworkDeltaTopic() {
        raidenDeltaEventStream = builder.stream(Topics.tokenNetworkDelta, Consumed.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getTokenNetworkDeltaSerde()))
                .transform(TokenNetworkDeltaTransformer::new, StateStores.raidenDeltaStoreName, StateStores.userCountStoreName, StateStores.tokenNetworkDeltaStoreName);
        raidenDeltaEventStream.print(Printed.<Key, RaidenDelta>toSysOut().withLabel("RAIDEN DELTA"));
        raidenDeltaEventStream.to(Topics.raidenDelta, Produced.with(specificSerdeManager.getKeySerde(), specificSerdeManager.getRaidenDeltaSerde()));
    }

    private KStream<Key, RaidenDelta> raidenDeltaEventStream;

}
