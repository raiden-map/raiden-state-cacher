package StateCacherEvents;

import org.apache.kafka.streams.StreamsBuilder;

public abstract class StateCacherEvent {

    public StateCacherEvent(StreamsBuilder builder) {
        this.builder = builder;
        specificSerdeManager = new SpecificSerdeManager(schemaRegistry);
    }

    public abstract void run();

    protected SpecificSerdeManager specificSerdeManager;
    protected StreamsBuilder builder;

    protected final String schemaRegistry = "http://raiden-sr-schema-registry.kafka.svc.cluster.local:8081";

}
