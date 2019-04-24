package StateCacherEvent.TokenNetworkDelta.Transformer;

import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Participant;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class ChannelOpenedTransformer extends ChannelTransformer implements Transformer<ProducerKey, ChannelOpened, KeyValue<String, TokenNetworkDelta>> {

    public ChannelOpenedTransformer(String storeName) {
        super(storeName, "ChannelOpened");
    }


    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        stateStore = (KeyValueStore) this.context.getStateStore(storeName);
    }

    @Override
    public KeyValue<String, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelOpened channelOpened) {
        TokenNetworkDelta tokenNetworkDelta = stateStore.get(channelOpened.getChannelEvent().getTokenNetworkAddress().toString());

        incrementChannelCount(tokenNetworkDelta);
        addChannel(tokenNetworkDelta, channelOpened);
        updateMetadata(tokenNetworkDelta, channelOpened.getChannelEvent());
        stateStore.put(tokenNetworkDelta.getTokenNetworkAddress().toString(), tokenNetworkDelta);

        return KeyValue.pair(tokenNetworkDelta.getTokenNetworkAddress().toString(), tokenNetworkDelta);
    }

    @Override
    public void close() {

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
