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
        lightStateStore = (KeyValueStore) this.context.getStateStore(lightStoreName);
    }

    @Override
    public KeyValue<Key, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelNewDeposit channelNewDeposit) {
        String address = channelNewDeposit.getChannelEvent().getTokenNetworkAddress().toString();
        Key key = new Key(address);
        String id = String.valueOf(channelNewDeposit.getChannelEvent().getId());

        TokenNetworkDelta tokenNetworkDelta = restoreTokenNetworkDelta(key, stateStore);
        updateChannelEvent(tokenNetworkDelta, channelNewDeposit);
        stateStore.put(key, tokenNetworkDelta);

        TokenNetworkDelta lightTokenNetworkDelta = restoreTokenNetworkDelta(key, lightStateStore);
        checkAndInsertChannel(id, lightTokenNetworkDelta, tokenNetworkDelta);
        updateChannelEvent(lightTokenNetworkDelta, channelNewDeposit);
        lightStateStore.put(key, lightTokenNetworkDelta);

        return KeyValue.pair(key, lightTokenNetworkDelta);
    }

    @Override
    public void close() {

    }

    @Override
    protected void updateChannelEvent(TokenNetworkDelta tokenNetworkDelta, Object channelEvent) {
        updateChannelNewDeposit(tokenNetworkDelta, (ChannelNewDeposit) channelEvent);
        try {
            updateChannelState(tokenNetworkDelta, ((ChannelNewDeposit) channelEvent).getChannelEvent(), stateName);
        } catch (NullPointerException n) {
        }
        updateMetadata(tokenNetworkDelta, ((ChannelNewDeposit) channelEvent).getChannelEvent());
    }

    private void updateChannelNewDeposit(TokenNetworkDelta tokenNetworkDelta, ChannelNewDeposit channelNewDeposit) {
        String id = String.valueOf(channelNewDeposit.getChannelEvent().getId());
        long tokenNetworkDeposit = tokenNetworkDelta.getTotalDeposit();
        long newDeposit = channelNewDeposit.getTotalDeposit();
        String participantAddress = channelNewDeposit.getParticipant().toString();
        try {
            findParticipant(tokenNetworkDelta.getModifiedChannels().get(id), participantAddress).setDeposit(newDeposit);
            tokenNetworkDelta.setTotalDeposit(tokenNetworkDeposit + newDeposit);
            tokenNetworkDeposit = tokenNetworkDelta.getTotalDeposit();
            int channels = tokenNetworkDelta.getModifiedChannels().size();
            tokenNetworkDelta.setAvgChannelDeposit((double) (tokenNetworkDeposit / channels));
        } catch (NullPointerException n) {

        }
    }

}
