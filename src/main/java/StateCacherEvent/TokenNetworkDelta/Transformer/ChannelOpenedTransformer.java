package StateCacherEvent.TokenNetworkDelta.Transformer;

import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.Participant;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class ChannelOpenedTransformer extends EventTransformer implements Transformer<ProducerKey, ChannelOpened, KeyValue<Key, TokenNetworkDelta>> {

    protected KeyValueStore<String, UserCount> userCountStateStore;
    protected String userCountStoreName = "userCountStateStore2";

    public ChannelOpenedTransformer(String storeName) {
        super(storeName, "ChannelOpened");
    }


    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        stateStore = (KeyValueStore) this.context.getStateStore(storeName);
        lightStateStore = (KeyValueStore) this.context.getStateStore(lightStoreName);
    }

    @Override
    public KeyValue<Key, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelOpened channelOpened) {
        String address = channelOpened.getChannelEvent().getTokenNetworkAddress().toString();
        Key key = new Key(address);
        TokenNetworkDelta tokenNetworkDelta = restoreTokenNetworkDelta(key, stateStore);
        updateChannelEvent(tokenNetworkDelta, channelOpened);
        stateStore.put(key, tokenNetworkDelta);

        TokenNetworkDelta lightTokenNetworkDelta = restoreTokenNetworkDelta(key, lightStateStore);
        updateChannelEvent(lightTokenNetworkDelta, channelOpened);
        lightStateStore.put(key, lightTokenNetworkDelta);

        return KeyValue.pair(key, lightTokenNetworkDelta);
    }

    @Override
    public void close() {

    }

    @Override
    protected void updateChannelEvent(TokenNetworkDelta tokenNetworkDelta, Object channelEvent) {
        addChannel(tokenNetworkDelta, (ChannelOpened) channelEvent);
        incrementChannelCount(tokenNetworkDelta);
        updateMetadata(tokenNetworkDelta, ((ChannelOpened)channelEvent).getChannelEvent());
    }

    private void incrementChannelCount(TokenNetworkDelta tokenNetworkDelta) {
        tokenNetworkDelta.setChannelsCount(tokenNetworkDelta.getChannelsCount() + 1);
        tokenNetworkDelta.setOpenChannels(tokenNetworkDelta.getOpenChannels() + 1);
    }

    private void addChannel(TokenNetworkDelta tokenNetworkDelta, ChannelOpened channelOpened) {
        int id = channelOpened.getChannelEvent().getId();
        Channel channel = buildDefaultChannel();
        channel.setChannelId(id);
        channel.setSettleTimeout(channelOpened.getSettleTimeout());
        channel.setLastStateChangeBlock(-1l);
        channel.setState("ChannelOpened");
        channel.getFirstParticipant().setEthAddress(channelOpened.getParticipant1());
        channel.getSecondParticipant().setEthAddress(channelOpened.getParticipant2());
        tokenNetworkDelta.getModifiedChannels().put(String.valueOf(id), channel);
    }

    private Channel buildDefaultChannel() {
        return new Channel(-1, "", 0l, 0l, buildDefaultParticipant(), buildDefaultParticipant());
    }

    private Participant buildDefaultParticipant() {
        return new Participant("", 0l, 0l, false);
    }

}
