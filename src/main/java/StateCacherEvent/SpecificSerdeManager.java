package StateCacherEvent;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.event.tokenNetwork.TokenNetworkCreated;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import io.raidenmap.statecacher.TokenNetworkSnapshot;
import org.apache.kafka.common.serialization.Serde;

import java.util.Collections;
import java.util.Map;

public class SpecificSerdeManager {

    public SpecificSerdeManager(String schemaRegistry) {
        serdeConfig = Collections.singletonMap("schema.registry.url", schemaRegistry);
        initSerdes();
    }


    private void initSerdes() {
        producerKeySerde = new SpecificAvroSerde<>();
        addSerdeConfig(producerKeySerde, true);
        keySerde = new SpecificAvroSerde<>();
        addSerdeConfig(keySerde, true);
        tokenNetworkCreatedSerde = new SpecificAvroSerde<>();
        addSerdeConfig(tokenNetworkCreatedSerde, false);
        channelOpenedSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelOpenedSerde, false);
        channelNewDepositSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelNewDepositSerde, false);
        channelClosedSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelClosedSerde, false);
        tokenNetworkDeltaSerde = new SpecificAvroSerde<>();
        addSerdeConfig(tokenNetworkDeltaSerde, false);
        tokenNetworkSnapshotSerde = new SpecificAvroSerde<>();
        addSerdeConfig(tokenNetworkSnapshotSerde, false);
    }

    private void addSerdeConfig(Serde serde, boolean isKey) {
        serde.configure(serdeConfig, isKey);
    }

    public Serde<ProducerKey> getProducerKeySerde() {
        return producerKeySerde;
    }

    public Serde<Key> getKeySerde() {
        return keySerde;
    }

    public Serde<TokenNetworkCreated> getTokenNetworkCreatedSerde() {
        return tokenNetworkCreatedSerde;
    }

    public Serde<ChannelOpened> getChannelOpenedSerde() {
        return channelOpenedSerde;
    }

    public Serde<ChannelNewDeposit> getChannelNewDepositSerde() {
        return channelNewDepositSerde;
    }

    public Serde<ChannelClosed> getChannelClosedSerde() {
        return channelClosedSerde;
    }

    public Serde<TokenNetworkDelta> getTokenNetworkDeltaSerde() {
        return tokenNetworkDeltaSerde;
    }

    public Serde<TokenNetworkSnapshot> getTokenNetworkSnapshotSerde() {
        return tokenNetworkSnapshotSerde;
    }

    private Map<String, String> serdeConfig;
    protected Serde<ProducerKey> producerKeySerde;
    protected Serde<Key> keySerde;
    protected Serde<ChannelOpened> channelOpenedSerde;
    protected Serde<ChannelNewDeposit> channelNewDepositSerde;
    protected Serde<ChannelClosed> channelClosedSerde;

    protected Serde<TokenNetworkCreated> tokenNetworkCreatedSerde;
    protected Serde<TokenNetworkDelta> tokenNetworkDeltaSerde;
    protected Serde<TokenNetworkSnapshot> tokenNetworkSnapshotSerde;

}
