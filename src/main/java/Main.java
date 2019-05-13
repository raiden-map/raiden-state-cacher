
import StateCacherEvents.RaidenDelta.RaidenDeltaEvent;
import StateCacherEvents.RaidenSnapshot.RaidenSnapshotEvent;
import StateCacherEvents.StateCacherEvent;
import StateCacherEvents.StateStores;
import StateCacherEvents.TokenNetworkSnapshot.TokenNetworkSnapshotEvent;
import StateCacherEvents.TokenNetworkDelta.TokenNetworkDeltaEvent;
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
        property.put(StreamsConfig.APPLICATION_ID_CONFIG, "stateCacherTokenNetworkTest-0");
        property.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "raiden-kafka-headless.kafka.svc.cluster.local:9092");
        property.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistry);
        property.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        StreamsBuilder builder = new StreamsBuilder();

        Properties property1 = new Properties();
        property1.put(StreamsConfig.APPLICATION_ID_CONFIG, "stateCacherRaidenTest-0");
        property1.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "raiden-kafka-headless.kafka.svc.cluster.local:9092");
        property1.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistry);
        property1.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        StreamsBuilder builder1 = new StreamsBuilder();

        StateStores.addStateStore(builder);
        StateStores.addStateStore(builder1);

        StateCacherEvent tokenNetworkDeltaEvent = new TokenNetworkDeltaEvent(builder);
        StateCacherEvent tokenNetworkSnapshotEvent = new TokenNetworkSnapshotEvent(builder);

        StateCacherEvent raidenDeltaEvent = new RaidenDeltaEvent(builder1);
        StateCacherEvent raidenSnapshotEvent = new RaidenSnapshotEvent(builder1);

        tokenNetworkDeltaEvent.run();
        tokenNetworkSnapshotEvent.run();

        raidenDeltaEvent.run();
        raidenSnapshotEvent.run();

        Topology topology = builder.build();
        KafkaStreams streams = new KafkaStreams(topology, property);

        Topology topology1 = builder1.build();
        KafkaStreams streams1 = new KafkaStreams(topology1, property1);

        streams.cleanUp();
        streams1.cleanUp();

        streams1.start();
        streams.start();

    }
}
