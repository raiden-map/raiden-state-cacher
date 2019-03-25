package StateCacherTool;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.streams.StreamsBuilder;

import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KStreamSpecificAvroSerde {

    public KStreamSpecificAvroSerde(String schemaRegistryURL) {
        serdeConfig = Collections.singletonMap("schema.registry.url", schemaRegistryURL);
        savedSerde = new HashMap<>();
    }

    public KStream<?, ?> createKStream(StreamsBuilder builder, String topicName, Class<?> keyType, Class<?> valueType) {
        Serde<?> keySerde = createSerde(keyType, true);
        Serde<?> valueSerde = createSerde(valueType, false);
        return builder.stream(topicName, Consumed.with(keySerde, valueSerde));
    }

    public KTable<?, ?> createKTable(StreamsBuilder builder, String topicName, Class<?> keyType, Class<?> valueType) {
        Serde<?> keySerde = createSerde(keyType, true);
        Serde<?> valueSerde = createSerde(valueType, false);
        return builder.table(topicName, Consumed.with(keySerde, valueSerde));
    }

    public Serde<?> createSerde(Class<?> serdeType, boolean isKey) {
        Serde<?> specificSerde = new SpecificAvroSerde<>();
        specificSerde.configure(serdeConfig, isKey);
        savedSerde.put(serdeType, specificSerde);
        return specificSerde;
    }

    public Serde<?> getSerde( Class<?> serdeType){
        return savedSerde.get(serdeType);
    }

    private Map<String, String> serdeConfig;
    private Map< Class, Serde> savedSerde;
}
