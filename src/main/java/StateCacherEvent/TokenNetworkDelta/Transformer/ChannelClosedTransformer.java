package StateCacherEvent.TokenNetworkDelta.Transformer;

import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class ChannelClosedTransformer extends EventTransformer implements Transformer<ProducerKey, ChannelClosed, KeyValue<Key, TokenNetworkDelta>> {

    public ChannelClosedTransformer(String storeName) {
        super(storeName, "ChannelClosed");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        stateStore = (KeyValueStore) this.context.getStateStore(storeName);
        lightStateStore = (KeyValueStore) this.context.getStateStore(lightStoreName);
    }

    @Override
    public KeyValue<Key, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelClosed channelClosed) {
        String address = channelClosed.getChannelEvent().getTokenNetworkAddress().toString();
        Key key = new Key(address);
        String id = String.valueOf(channelClosed.getChannelEvent().getId());

        TokenNetworkDelta tokenNetworkDelta = restoreTokenNetworkDelta(key, stateStore);
        updateChannelEvent(tokenNetworkDelta, channelClosed);
        stateStore.put(key, tokenNetworkDelta);

        TokenNetworkDelta lightTokenNetworkDelta = restoreTokenNetworkDelta(key, lightStateStore);
        checkAndInsertChannel(id, lightTokenNetworkDelta, tokenNetworkDelta);
        updateChannelEvent(lightTokenNetworkDelta, channelClosed);
        lightStateStore.put(key, lightTokenNetworkDelta);

        return KeyValue.pair(key, lightTokenNetworkDelta);
    }

    @Override
    public void close() {

    }

    private void checkAndInsertChannel(String id, TokenNetworkDelta lightTokenNetworkDelta, TokenNetworkDelta tokenNetworkDelta) {
        if(!lightTokenNetworkDelta.getModifiedChannels().containsKey(id))
            lightTokenNetworkDelta.getModifiedChannels().put(id, Channel.newBuilder(tokenNetworkDelta.getModifiedChannels().get(id)).build());
    }

    @Override
    protected void updateChannelEvent(TokenNetworkDelta tokenNetworkDelta, Object channelEvent) {
        updateChannelClosed(tokenNetworkDelta, (ChannelClosed) channelEvent);
        try {
            updateChannelState(tokenNetworkDelta, ((ChannelClosed)channelEvent).getChannelEvent(), stateName);
        } catch (NullPointerException n) {
        }
        decrementChannelCount(tokenNetworkDelta);
        updateMetadata(tokenNetworkDelta, ((ChannelClosed)channelEvent).getChannelEvent());
    }

    private void updateChannelClosed(TokenNetworkDelta tokenNetworkDelta, ChannelClosed channelClosed) {
        String id = String.valueOf(channelClosed.getChannelEvent().getId());
        String participantAddress = channelClosed.getParticipant().toString();
        try {
            findParticipant(tokenNetworkDelta.getModifiedChannels().get(id), participantAddress).setWantsToClose(true);
        } catch (NullPointerException n) {
        }
    }

    private void decrementChannelCount(TokenNetworkDelta tokenNetworkDelta) {
        tokenNetworkDelta.setOpenChannels(tokenNetworkDelta.getOpenChannels() - 1);
        tokenNetworkDelta.setClosedChannels(tokenNetworkDelta.getClosedChannels() + 1);
    }
}
