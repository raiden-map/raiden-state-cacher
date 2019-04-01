package StateCacherEvent;

import RaidenMapTokenInfo.TokenInfoBuilder;
import StateCacherEvent.Manager.ChannelManager;
import StateCacherEvent.Manager.TokenNetworkManager;
import StateCacherTool.KStreamSpecificAvroSerde;
import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.event.tokenNetwork.TokenNetworkCreated;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenNetworkDeltaEvent extends StateCacherEvent {

    public TokenNetworkDeltaEvent(String toStreamTopic, KStreamSpecificAvroSerde kStreamSpecificAvroSerde) {
        super(toStreamTopic, kStreamSpecificAvroSerde);
        windowDuration = Duration.ofMillis(WINDOWMILLS);
        tokenNetworkDeltas = new ConcurrentHashMap<>();
        tokenNetworkChannels = new ConcurrentHashMap<>();
        tokenNetworkManager = new TokenNetworkManager();
        channelManager = new ChannelManager();
        users = new HashMap<>();
        consumeKnownTokenNetwork();
    }


    //TO DO
    private void consumeKnownTokenNetwork() {
    }


    @Override
    public void run() {
        consumeFromTokenNetworkCreatedTopic();
        consumeFromChannelOpenedTopic();
        consumeFromChannelNewDepositTopic();
        consumeFromChannelClosedTopic();
        send();
    }

    protected void send() {
        tokenNetworkDeltaKStream.groupByKey((Grouped<String, TokenNetworkDelta>) Grouped.with(Serdes.String(), kStreamSpecificAvroSerde.getSerde(TokenNetworkDelta.class))).windowedBy(TimeWindows.of(WINDOWMILLS)).reduce((k, v) -> v).toStream().print(Printed.toSysOut());
        //restore channels
    }

    private void consumeFromTokenNetworkCreatedTopic() {
        tokenNetworkDeltaKStream = kStreamSpecificAvroSerde.createKStream(topicTokenNetworkCreated, ProducerKey.class, TokenNetworkCreated.class)
                .peek((producerKey, tokenNetworkCreated) -> {
                    String tokenNetworkAddress = ((TokenNetworkCreated) tokenNetworkCreated).getTokenNetworkAddress().toString();

                    initLocalHashMapForNewTokenNetwork(tokenNetworkAddress);
                    consumeTokenNetworkEventTokenNetworkCreated(tokenNetworkDeltas.get(tokenNetworkAddress), (TokenNetworkCreated) tokenNetworkCreated);
                })
                .map((key, value) -> KeyValue.pair(((TokenNetworkCreated) value).getTokenNetworkAddress().toString(), tokenNetworkDeltas.get(key)));
    }


    private void consumeFromChannelOpenedTopic() {
        tokenNetworkDeltaKStream = kStreamSpecificAvroSerde.createKStream(topicChannelOpened, ProducerKey.class, ChannelOpened.class)
                .peek((producerKey, channelOpened) -> {
                    String tokenNetworkAddress = ((ChannelOpened) channelOpened).getChannelEvent().getTokenNetworkAddress().toString();
                    Channel channel = createChannel(tokenNetworkAddress, (ChannelOpened) channelOpened);

                    consumeChannelEventOpenedChannel(channel, (ChannelOpened) channelOpened);
                    consumeTokenNetworkEventChannelOpened(tokenNetworkDeltas.get(tokenNetworkAddress), (ChannelOpened) channelOpened);
                    setChannels(tokenNetworkAddress);
                })
                .map((key, value) -> KeyValue.pair(((ChannelOpened) value).getChannelEvent().getTokenNetworkAddress().toString(), tokenNetworkDeltas.get(key)));
    }


    private void consumeFromChannelClosedTopic() {
        tokenNetworkDeltaKStream = kStreamSpecificAvroSerde.createKStream(topicChannelClosed, ProducerKey.class, ChannelClosed.class)
                .peek((producerKey, channelClosed) -> {
                    String tokenNetworkAddress = ((ChannelClosed) channelClosed).getChannelEvent().getTokenNetworkAddress().toString();
                    Channel channel = tokenNetworkChannels.get(tokenNetworkAddress).get(channelManager.getID(((ChannelClosed) channelClosed).getChannelEvent()));

                    consumeChannelEventChannelClosed(channel, (ChannelClosed) channelClosed);
                    consumeTokenNetworkEventChannelClosed(tokenNetworkDeltas.get(tokenNetworkAddress), (ChannelClosed) channelClosed);
                    setChannels(tokenNetworkAddress);
                })
                .map((key, value) -> KeyValue.pair((String) key, tokenNetworkDeltas.get(key)));

    }

    private void consumeFromChannelNewDepositTopic() {
        tokenNetworkDeltaKStream = kStreamSpecificAvroSerde.createKStream(topicChannelNewDeposit, ProducerKey.class, ChannelNewDeposit.class)
                .peek((producerKey, channelNewDeposit) -> {
                    String tokenNetworkAddress = ((ChannelNewDeposit) channelNewDeposit).getChannelEvent().getTokenNetworkAddress().toString();
                    TokenNetworkDelta tokenNetworkDelta = tokenNetworkDeltas.get(tokenNetworkAddress);
                    Channel channel = tokenNetworkChannels.get(tokenNetworkAddress).get(channelManager.getID(((ChannelNewDeposit) channelNewDeposit).getChannelEvent()));

                    consumeChannelEventNewDeposit(channel, (ChannelNewDeposit) channelNewDeposit);
                    consumeTokenNetworkEventNewDeposit(tokenNetworkDelta, (ChannelNewDeposit) channelNewDeposit);
                    setChannels(tokenNetworkAddress);
                })
                .map((key, value) -> new KeyValue<>(((ChannelNewDeposit) value).getChannelEvent().getTokenNetworkAddress().toString(), tokenNetworkDeltas.get(key)));
    }

    //TO DO
    private void consumeChannelWithdraw() {
    }

    //TO DO
    private void consumeChannelSettled() {
    }

    private void initLocalHashMapForNewTokenNetwork(String tokenNetworkAddress) {
        tokenNetworkDeltas.putIfAbsent(tokenNetworkAddress, new TokenNetworkDelta());
        tokenNetworkChannels.putIfAbsent(tokenNetworkAddress, new HashMap<>());
    }

    private Channel createChannel(String tokenNetworkAddress, ChannelOpened channelOpened) {
        int channelID = channelManager.getID(channelOpened.getChannelEvent());
        tokenNetworkChannels.get(tokenNetworkAddress).put(channelID, new Channel());
        return tokenNetworkChannels.get(tokenNetworkAddress).get(channelID);
    }

    private void consumeChannelEventOpenedChannel(Channel channel, ChannelOpened channelOpened) {
        channelManager.updateNewChannel(channel, channelOpened);
        channelManager.updateUsers(channel, getUsers());
    }

    private void consumeChannelEventNewDeposit(Channel channel, ChannelNewDeposit channelNewDeposit) {
        channelManager.updateNewDeposit(channel, channelNewDeposit);
    }

    private void consumeChannelEventChannelClosed(Channel channel, ChannelClosed channelClosed) {
        channelManager.updateChannelClosed(channel, channelClosed);
        //TO DO: update users
    }

    private void consumeTokenNetworkEventTokenNetworkCreated(TokenNetworkDelta tokenNetworkDelta, TokenNetworkCreated tokenNetworkCreated) {
        tokenNetworkManager.updateToken(tokenNetworkDelta, tokenNetworkCreated);
        tokenNetworkManager.updateMetadate(tokenNetworkDelta, tokenNetworkCreated.getMetadata());
    }

    private void consumeTokenNetworkEventChannelOpened(TokenNetworkDelta tokenNetworkDelta, ChannelOpened channelOpened) {
        tokenNetworkManager.updateChannelsOpened(tokenNetworkDelta);
        tokenNetworkManager.updateMetadate(tokenNetworkDelta, channelOpened.getChannelEvent().getMetadata());
    }

    private void consumeTokenNetworkEventNewDeposit(TokenNetworkDelta tokenNetworkDelta, ChannelNewDeposit channelNewDeposit) {
        tokenNetworkManager.updateTotalDeposit(tokenNetworkDelta, channelNewDeposit);
        tokenNetworkManager.updateMetadate(tokenNetworkDelta, channelNewDeposit.getChannelEvent().getMetadata());
    }

    private void consumeTokenNetworkEventChannelClosed(TokenNetworkDelta tokenNetworkDelta, ChannelClosed channelClosed) {
        tokenNetworkManager.updateChannelsClosed(tokenNetworkDelta);
        tokenNetworkManager.updateMetadate(tokenNetworkDelta, channelClosed.getChannelEvent().getMetadata());
    }


    private Map<String, Integer> getUsers() {
        return users;
    }

    private void setChannels(String tokenNetworkAddress) {
        tokenNetworkDeltas.get(tokenNetworkAddress).setChannels(new ArrayList<>(tokenNetworkChannels.get(tokenNetworkAddress).values()));
    }

    protected Map<String, Integer> users;
    protected static ConcurrentHashMap<String, TokenNetworkDelta> tokenNetworkDeltas;
    protected static ConcurrentHashMap<String, Map<Integer, Channel>> tokenNetworkChannels;
    protected KStream<String, TokenNetworkDelta> tokenNetworkDeltaKStream;

    private Duration windowDuration;
    private ChannelManager channelManager;
    private TokenNetworkManager tokenNetworkManager;
    private static final int WINDOWMILLS = 5000;
}
