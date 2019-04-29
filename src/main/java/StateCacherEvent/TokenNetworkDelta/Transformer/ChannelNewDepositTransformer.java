package StateCacherEvent.TokenNetworkDelta.Transformer;

import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class ChannelNewDepositTransformer extends EventTransformer implements Transformer<ProducerKey, ChannelNewDeposit, KeyValue<Key, TokenNetworkDelta>> {


    public ChannelNewDepositTransformer(String storeName) {
        super(storeName, "ChannelNewDeposit");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        stateStore = (KeyValueStore) this.context.getStateStore(storeName);
        context.commit();
    }

    @Override
    public KeyValue<String, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelNewDeposit channelNewDeposit) {
        TokenNetworkDelta tokenNetworkDelta = stateStore.get(channelNewDeposit.getChannelEvent().getTokenNetworkAddress().toString());
        updateChannelNewDeposit(tokenNetworkDelta, channelNewDeposit);
        updateChannelState(tokenNetworkDelta, channelNewDeposit.getChannelEvent(), stateName);
        updateMetadata(tokenNetworkDelta, channelNewDeposit.getChannelEvent());
        stateStore.put(tokenNetworkDelta.getTokenNetworkAddress().toString(), tokenNetworkDelta);

        return KeyValue.pair(tokenNetworkDelta.getTokenNetworkAddress().toString(), tokenNetworkDelta);
    }

    @Override
    public void close() {

    }

    private void updateChannelNewDeposit(TokenNetworkDelta tokenNetworkDelta, ChannelNewDeposit channelNewDeposit) {
        String id = String.valueOf(channelNewDeposit.getChannelEvent().getId());
        long newDeposit = channelNewDeposit.getTotalDeposit();
        String participantAddress = channelNewDeposit.getParticipant().toString();
        findParticipant(tokenNetworkDelta.getModifiedChannels().get(id), participantAddress).setDeposit(newDeposit);
    }
}
