import StateCacherEvent.StateCacherEvent;
import StateCacherEvent.TokenNetworkDelta.TokenNetworkDeltaEvent;
import StateCacherEvent.TokenNetworkSnapshot.TokenNetworkSnapshotEvent;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.Properties;

public class Main {
    public static void main(String args[]) {
        final String schemaRegistry = "http://raiden-sr-schema-registry.kafka.svc.cluster.local:8081";

        Properties property = new Properties();
        property.put(StreamsConfig.APPLICATION_ID_CONFIG, "stateCacherTest0");
        property.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "raiden-kafka-headless.kafka.svc.cluster.local:9092");
        property.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistry);
        property.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        StreamsBuilder builder = new StreamsBuilder();


        StateCacherEvent tokenNetworkDeltaEvent = new TokenNetworkDeltaEvent("tokenNetworkDeltaTest0", builder);
        StateCacherEvent tokenNetworkSnapshotEvent = new TokenNetworkSnapshotEvent("tokenNetworkSnapshotTest0", builder);

        tokenNetworkDeltaEvent.run();
        tokenNetworkSnapshotEvent.run();

        Topology topology = builder.build();
        KafkaStreams streams = new KafkaStreams(topology, property);
        streams.cleanUp();
        streams.start();
    }
}
