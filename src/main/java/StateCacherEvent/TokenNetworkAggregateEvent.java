package StateCacherEvent;

import RaidenMapTokenInfo.TokenInfoBuilder;
import StateCacherEvent.StateCacherBuilder.BuildChannel;
import StateCacherTool.KStreamSpecificAvroSerde;
import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.event.tokenNetwork.TokenNetworkCreated;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.TokenNetworkAggregate;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenNetworkAggregateEvent extends StateCacherEvent {

    public TokenNetworkAggregateEvent(StreamsBuilder builder, String toStreamTopic, KStreamSpecificAvroSerde kStreamSpecificAvroSerde) {
        super(builder, toStreamTopic, kStreamSpecificAvroSerde);
        tokenNetworkAggregateHashMap = new ConcurrentHashMap<>();
        buildChannel = new BuildChannel();
        users = new HashMap<>();
    }

    @Override
    public void run() {
        consumeTokenNetworkCreated();
        consumeChannelOpened();
        consumeChannelClosed();
        //consumeChannelSettled();
        consumeChannelNewDeposit();
        //consumeChannelWithdraw();
    }

    protected void send() {
        //produce result
    }

    private void consumeTokenNetworkCreated() {
        kStreamSpecificAvroSerde.createKStream(builder, topicTokenNetworkCreated, ProducerKey.class, TokenNetworkCreated.class)
                .peek((producerKey, tokenNetwork) -> {
                    tokenNetworkAddress = ((TokenNetworkCreated) tokenNetwork).getTokenNetworkAddress().toString();

                    tokenNetworkAggregateHashMap.putIfAbsent(tokenNetworkAddress, TokenNetworkAggregate.newBuilder().build());
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setTokenNetworkAddress(tokenNetworkAddress);
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setToken(TokenInfoBuilder.buildToken(tokenNetworkAddress));
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setBlockNumber(((TokenNetworkCreated) tokenNetwork).getMetadata().getBlockNumber());
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setTimestamp(Instant.now().toEpochMilli());
                });
    }

    private void consumeChannelOpened() {
        kStreamSpecificAvroSerde.createKStream(builder, topicChannelOpened, ProducerKey.class, ChannelOpened.class)
                .peek((producerKey, channelOpened) -> {
                    tokenNetworkAddress = ((ChannelOpened) channelOpened).getChannelEvent().getTokenNetworkAddress().toString();

                    //TO DO: gli indici della lista partono da 0 mentre i canali da 1
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).getChannels().add(buildChannel.build((ChannelOpened) channelOpened, users));
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).updateChannelsCountOpen();
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setBlockNumber(((ChannelOpened) channelOpened).getChannelEvent().getMetadata().getBlockNumber());
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setTimestamp(Instant.now().toEpochMilli());
                });
    }

    private void consumeChannelClosed() {
        kStreamSpecificAvroSerde.createKStream(builder, topicChannelClosed, ProducerKey.class, ChannelClosed.class)
                .peek((producerKey, channelClosed) -> {
                    tokenNetworkAddress = ((ChannelClosed) channelClosed).getChannelEvent().getTokenNetworkAddress().toString();

                    buildChannel.build((ChannelClosed) channelClosed, tokenNetworkAggregateHashMap.get(tokenNetworkAddress).getChannels());

                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).updateClosedChannels();
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setBlockNumber(((ChannelClosed) channelClosed).getChannelEvent().getMetadata().getBlockNumber());
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setTimestamp(Instant.now().toEpochMilli());
                });
    }

    private void consumeChannelNewDeposit() {
        kStreamSpecificAvroSerde.createKStream(builder, topicChannelNewDeposit, ProducerKey.class, ChannelNewDeposit.class)
                .peek((producerKey, channelNewDeposit) -> {
                    tokenNetworkAddress = ((ChannelNewDeposit) channelNewDeposit).getChannelEvent().getTokenNetworkAddress().toString();

                    buildChannel.build((ChannelNewDeposit) channelNewDeposit, tokenNetworkAggregateHashMap.get(tokenNetworkAddress).getChannels());

                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setTotalDeposit(((ChannelNewDeposit) channelNewDeposit).getTotalDeposit());
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setBlockNumber(((ChannelNewDeposit) channelNewDeposit).getChannelEvent().getMetadata().getBlockNumber());
                    tokenNetworkAggregateHashMap.get(tokenNetworkAddress).setTimestamp(Instant.now().toEpochMilli());
                });
    }

    //TO DO
    private void consumeChannelWithdraw() {
    }

    //TO DO
    private void consumeChannelSettled() {
    }

    private String tokenNetworkAddress;
    private BuildChannel buildChannel;
    protected Map<String, Integer> users;

    protected static ConcurrentHashMap<String, TokenNetworkAggregate> tokenNetworkAggregateHashMap;
    protected KStream<String, TokenNetworkAggregate> tokenNetworkAggregateKStream;
}
