package StateCacherEvents.TokenNetworkDelta.Transformer;

import StateCacherEvents.RaidenBigDecimal;
import StateCacherEvents.StateStores;
import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

import java.math.BigDecimal;

public class ChannelNewDepositTransformer extends EventTransformer implements Transformer<ProducerKey, ChannelNewDeposit, KeyValue<Key, TokenNetworkDelta>> {


    public ChannelNewDepositTransformer() {
        super("ChannelNewDeposit");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        tokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.tokenNetworkDeltaStoreName);
        lightTokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.lightTokenNetworkDeltaStoreName);
    }

    @Override
    public KeyValue<Key, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelNewDeposit channelNewDeposit) {
        String address = channelNewDeposit.getChannelEvent().getTokenNetworkAddress().toString();
        Key key = new Key(address);
        String id = String.valueOf(channelNewDeposit.getChannelEvent().getId());

        TokenNetworkDelta tokenNetworkDelta = restoreTokenNetworkDelta(key, tokenNetworkDeltaStateStore);
        updateChannelEvent(tokenNetworkDelta, channelNewDeposit);
        tokenNetworkDeltaStateStore.put(key, tokenNetworkDelta);

        TokenNetworkDelta lightTokenNetworkDelta = restoreTokenNetworkDelta(key, lightTokenNetworkDeltaStateStore);
        checkAndInsertChannel(id, lightTokenNetworkDelta, tokenNetworkDelta);
        updateChannelEvent(lightTokenNetworkDelta, channelNewDeposit);
        lightTokenNetworkDeltaStateStore.put(key, lightTokenNetworkDelta);

        return KeyValue.pair(key, lightTokenNetworkDelta);
    }

    @Override
    public void close() {

    }

    @Override
    protected void updateChannelEvent(TokenNetworkDelta tokenNetworkDelta, Object channelEvent) {
        updateChannelNewDeposit(tokenNetworkDelta, (ChannelNewDeposit) channelEvent);
        try {
            updateChannelState(tokenNetworkDelta, ((ChannelNewDeposit) channelEvent).getChannelEvent());
        } catch (NullPointerException n) {
        }
        updateMetadata(tokenNetworkDelta, ((ChannelNewDeposit) channelEvent).getChannelEvent());
    }

    private void updateChannelNewDeposit(TokenNetworkDelta tokenNetworkDelta, ChannelNewDeposit channelNewDeposit) {
        String id = String.valueOf(channelNewDeposit.getChannelEvent().getId());
        BigDecimal tokenNetworkDeposit = RaidenBigDecimal.valueOf(tokenNetworkDelta.getTotalDeposit());
        BigDecimal newDeposit = RaidenBigDecimal.valueOf(channelNewDeposit.getTotalDeposit());
        String participantAddress = channelNewDeposit.getParticipant().toString();
        try {
            findParticipant(tokenNetworkDelta.getModifiedChannels().get(id), participantAddress).setDeposit(newDeposit.toPlainString());
            tokenNetworkDelta.setTotalDeposit(tokenNetworkDeposit.add(newDeposit).toPlainString());
            tokenNetworkDeposit = RaidenBigDecimal.valueOf(tokenNetworkDelta.getTotalDeposit());
            BigDecimal channels = BigDecimal.valueOf(tokenNetworkDelta.getModifiedChannels().size());
            tokenNetworkDelta.setAvgChannelDeposit(RaidenBigDecimal.divide(tokenNetworkDeposit, channels));
        } catch (NullPointerException n) {

        }
    }

}
