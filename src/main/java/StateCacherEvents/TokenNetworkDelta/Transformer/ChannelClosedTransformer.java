package StateCacherEvents.TokenNetworkDelta.Transformer;

import StateCacherEvents.StateStores;
import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class ChannelClosedTransformer extends EventTransformer implements Transformer<ProducerKey, ChannelClosed, KeyValue<Key, TokenNetworkDelta>> {

    public ChannelClosedTransformer() {
        super("ChannelClosed");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        tokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.tokenNetworkDeltaStoreName);
        lightTokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.lightTokenNetworkDeltaStoreName);
    }

    @Override
    public KeyValue<Key, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelClosed channelClosed) {
        String address = channelClosed.getChannelEvent().getTokenNetworkAddress().toString();
        Key key = new Key(address);
        String id = String.valueOf(channelClosed.getChannelEvent().getId());

        TokenNetworkDelta tokenNetworkDelta = restoreTokenNetworkDelta(key, tokenNetworkDeltaStateStore);
        updateChannelEvent(tokenNetworkDelta, channelClosed);
        tokenNetworkDeltaStateStore.put(key, tokenNetworkDelta);

        TokenNetworkDelta lightTokenNetworkDelta = restoreTokenNetworkDelta(key, lightTokenNetworkDeltaStateStore);
        checkAndInsertChannel(id, lightTokenNetworkDelta, tokenNetworkDelta);
        updateChannelEvent(lightTokenNetworkDelta, channelClosed);
        lightTokenNetworkDeltaStateStore.put(key, lightTokenNetworkDelta);

        return KeyValue.pair(key, lightTokenNetworkDelta);
    }

    @Override
    public void close() {

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
