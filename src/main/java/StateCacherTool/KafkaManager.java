package StateCacherTool;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.Properties;

public class KafkaManager {

    public KafkaManager(String appID) {
        property = new Properties();
        builder = new StreamsBuilder();
        property.put(StreamsConfig.APPLICATION_ID_CONFIG, appID);
        property.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        property.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistry);
        property.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        property.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
        property.put(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG, "org.apache.kafka.streams.processor.WallclockTimestampExtractor");
    }

    public void start() {
        topology = builder.build();
        streams = new KafkaStreams(topology, property);
        streams.cleanUp();
        streams.start();
    }

    public StreamsBuilder getBuilder() {
        return builder;
    }

    public String getSchemaRegistry() {
        return schemaRegistry;
    }

    private Topology topology;
    private KafkaStreams streams;
    private StreamsBuilder builder;
    private final Properties property;
    private static final String bootstrapServer = "raiden-kafka-headless.kafka.svc.cluster.local:9092";
    private static final String schemaRegistry = "http://raiden-sr-schema-registry.kafka.svc.cluster.local:8081";

}
