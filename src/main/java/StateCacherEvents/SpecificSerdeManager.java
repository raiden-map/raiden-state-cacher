package StateCacherEvents;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import io.raidenmap.Endpoint;
import io.raidenmap.event.Endpoint.AddressRegistered;
import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.event.channel.ChannelSettled;
import io.raidenmap.event.tokenNetwork.TokenNetworkCreated;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.*;
import org.apache.kafka.common.serialization.Serde;

import java.util.Collections;
import java.util.Map;

public class SpecificSerdeManager {

    private Serde<TokenNetworkSnapshot> tokenNetworkSnapshotSerde1;

    public SpecificSerdeManager(String schemaRegistry) {
        serdeConfig = Collections.singletonMap("schema.registry.url", schemaRegistry);
        initSerdes();
    }


    private void initSerdes() {
        producerKeySerde = new SpecificAvroSerde<>();
        addSerdeConfig(producerKeySerde, true);
        keySerde = new SpecificAvroSerde<>();
        addSerdeConfig(keySerde, true);
        endpointSerde = new SpecificAvroSerde<>();
        addSerdeConfig(endpointSerde, false);
        addressRegisteredSerde = new SpecificAvroSerde<>();
        addSerdeConfig(addressRegisteredSerde, false);
        tokenNetworkCreatedSerde = new SpecificAvroSerde<>();
        addSerdeConfig(tokenNetworkCreatedSerde, false);
        channelOpenedSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelOpenedSerde, false);
        channelNewDepositSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelNewDepositSerde, false);
        channelClosedSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelClosedSerde, false);
        channelSettledSerde = new SpecificAvroSerde<>();
        addSerdeConfig(channelSettledSerde, false);
        tokenNetworkDeltaSerde = new SpecificAvroSerde<>();
        addSerdeConfig(tokenNetworkDeltaSerde, false);
        tokenNetworkSnapshotSerde = new SpecificAvroSerde<>();
        addSerdeConfig(tokenNetworkSnapshotSerde, false);
        raidenDeltaSerde = new SpecificAvroSerde<>();
        addSerdeConfig(raidenDeltaSerde, false);
        raidenSnapshotSerde = new SpecificAvroSerde<>();
        addSerdeConfig(raidenSnapshotSerde, false);

        userCountSerde = new SpecificAvroSerde<>();
        addSerdeConfig(userCountSerde, false);

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

    public Serde<Endpoint> getEndpointSerde() {
        return endpointSerde;
    }

    public Serde<AddressRegistered> getAddressRegisteredSerde(){ return addressRegisteredSerde;}

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

    public Serde<ChannelSettled> getChannelSettledSerde() {
        return channelSettledSerde;
    }

    public Serde<TokenNetworkDelta> getTokenNetworkDeltaSerde() {
        return tokenNetworkDeltaSerde;
    }

    public Serde<TokenNetworkSnapshot> getTokenNetworkSnapshotSerde() {
        return tokenNetworkSnapshotSerde;
    }

    public Serde<UserCount> getUserCountSerde() {
        return userCountSerde;
    }

    public Serde<RaidenDelta> getRaidenDeltaSerde() {
        return raidenDeltaSerde;
    }

    public Serde<RaidenSnapshot> getRaidenSnapshotSerde() {
        return raidenSnapshotSerde;
    }

    private Map<String, String> serdeConfig;

    protected Serde<ProducerKey> producerKeySerde;
    protected Serde<Key> keySerde;

    protected Serde<Endpoint> endpointSerde;
    protected Serde<AddressRegistered> addressRegisteredSerde;
    protected Serde<TokenNetworkCreated> tokenNetworkCreatedSerde;
    protected Serde<ChannelOpened> channelOpenedSerde;
    protected Serde<ChannelNewDeposit> channelNewDepositSerde;
    protected Serde<ChannelClosed> channelClosedSerde;
    protected Serde<ChannelSettled> channelSettledSerde;

    protected Serde<TokenNetworkDelta> tokenNetworkDeltaSerde;
    protected Serde<TokenNetworkSnapshot> tokenNetworkSnapshotSerde;
    protected Serde<RaidenDelta> raidenDeltaSerde;
    protected Serde<RaidenSnapshot> raidenSnapshotSerde;

    protected Serde<UserCount> userCountSerde;


}
