package StateCacherEvent.TokenNetworkDelta.Transformer;

import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class ChannelClosedTransformer extends ChannelTransformer implements Transformer<ProducerKey, ChannelClosed, KeyValue<String, TokenNetworkDelta>> {

    public ChannelClosedTransformer(String storeName) {
        super(storeName, "ChannelClosed");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        stateStore = (KeyValueStore) this.context.getStateStore(storeName);
    }

    @Override
    public KeyValue<String, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelClosed channelClosed) {
        TokenNetworkDelta tokenNetworkDelta = stateStore.get(channelClosed.getChannelEvent().getTokenNetworkAddress().toString());
        updateChannelClosed(tokenNetworkDelta,channelClosed);
        updateChannelState(tokenNetworkDelta, channelClosed.getChannelEvent(), stateName);
        updateMetadata(tokenNetworkDelta, channelClosed.getChannelEvent());
        stateStore.put(tokenNetworkDelta.getTokenNetworkAddress().toString(), tokenNetworkDelta);

        return KeyValue.pair(tokenNetworkDelta.getTokenNetworkAddress().toString(), tokenNetworkDelta);
    }

    @Override
    public void close() {

    }

    private void updateChannelClosed(TokenNetworkDelta tokenNetworkDelta, ChannelClosed channelClosed) {
        String id = String.valueOf(channelClosed.getChannelEvent().getId());
        String participantAddress = channelClosed.getParticipant().toString();
        findParticipant(tokenNetworkDelta.getModifiedChannels().get(id), participantAddress).setWantsToClose(true);
        decrementChannelCount(tokenNetworkDelta);
    }

    private void decrementChannelCount(TokenNetworkDelta tokenNetworkDelta) {
        tokenNetworkDelta.setOpenChannels(tokenNetworkDelta.getOpenChannels() - 1);
        tokenNetworkDelta.setClosedChannels(tokenNetworkDelta.getClosedChannels() + 1);
    }
}
