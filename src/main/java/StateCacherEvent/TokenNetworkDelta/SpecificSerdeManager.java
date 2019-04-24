package StateCacherEvent.TokenNetworkDelta;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.event.tokenNetwork.TokenNetworkCreated;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.TokenNetworkDelta;
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
        tokenNetworkCreatedSerde = new SpecificAvroSerde<>();
        addSerdeConfig(tokenNetworkCreatedSerde, false);
        tokenNetworkDeltaSerde = new SpecificAvroSerde<>();
        addSerdeConfig(tokenNetworkDeltaSerde, false);
        channelOpenedSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelOpenedSerde, false);
        channelNewDepositSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelNewDepositSerde, false);
        channelClosedSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelClosedSerde, false);
    }

    private void addSerdeConfig(Serde serde, boolean isKey) {
        serde.configure(serdeConfig, isKey);
    }


    public Serde<ProducerKey> getProducerKeySerde() {
        return producerKeySerde;
    }

    public Serde<TokenNetworkCreated> getTokenNetworkCreatedSerde() {
        return tokenNetworkCreatedSerde;
    }

    public Serde<TokenNetworkDelta> getTokenNetworkDeltaSerde() {
        return tokenNetworkDeltaSerde;
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

    private Map<String, String> serdeConfig;
    protected Serde<ProducerKey> producerKeySerde;
    protected Serde<ChannelOpened> channelOpenedSerde;
    protected Serde<ChannelNewDeposit> channelNewDepositSerde;
    protected Serde<ChannelClosed> channelClosedSerde;

    protected Serde<TokenNetworkCreated> tokenNetworkCreatedSerde;
    protected Serde<TokenNetworkDelta> tokenNetworkDeltaSerde;


}
