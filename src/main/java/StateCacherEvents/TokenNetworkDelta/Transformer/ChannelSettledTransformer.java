package StateCacherEvents.TokenNetworkDelta.Transformer;

import StateCacherEvents.StateStores;
import io.raidenmap.event.channel.ChannelSettled;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.TokenNetworkDelta;
import io.raidenmap.statecacher.UserCount;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class ChannelSettledTransformer extends EventTransformer implements Transformer<ProducerKey, ChannelSettled, KeyValue<Key, TokenNetworkDelta>> {

    protected KeyValueStore<String, UserCount> userCountStateStore;

    public ChannelSettledTransformer() {
        super("ChannelSettled");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        tokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.tokenNetworkDeltaStoreName);
        lightTokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.lightTokenNetworkDeltaStoreName);
        userCountStateStore = (KeyValueStore) this.context.getStateStore(StateStores.userCountStoreName);
    }

    @Override
    public KeyValue<Key, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelSettled channelSettled) {
        String address = channelSettled.getChannelEvent().getTokenNetworkAddress().toString();
        Key key = new Key(address);
        String id = String.valueOf(channelSettled.getChannelEvent().getId());

        TokenNetworkDelta tokenNetworkDelta = restoreTokenNetworkDelta(key, tokenNetworkDeltaStateStore);
        updateUserCountStore(tokenNetworkDelta, channelSettled);
        updateChannelEvent(tokenNetworkDelta, channelSettled);
        tokenNetworkDeltaStateStore.put(key, tokenNetworkDelta);

        TokenNetworkDelta lightTokenNetworkDelta = restoreTokenNetworkDelta(key, lightTokenNetworkDeltaStateStore);
        checkAndInsertChannel(id, lightTokenNetworkDelta, tokenNetworkDelta);
        updateChannelEvent(lightTokenNetworkDelta, channelSettled);
        lightTokenNetworkDeltaStateStore.put(key, lightTokenNetworkDelta);

        return KeyValue.pair(key, lightTokenNetworkDelta);
    }

    @Override
    public void close() {

    }

    @Override
    protected void updateChannelEvent(TokenNetworkDelta tokenNetworkDelta, Object channelEvent) {
        updateChannelSettled(tokenNetworkDelta, (ChannelSettled) channelEvent);
        try {
            updateChannelState(tokenNetworkDelta, ((ChannelSettled) channelEvent).getChannelEvent(), stateName);
        } catch (NullPointerException n) {
        }
        updateMetadata(tokenNetworkDelta, ((ChannelSettled) channelEvent).getChannelEvent());
    }

    private void updateChannelSettled(TokenNetworkDelta tokenNetworkDelta, ChannelSettled channelSettled) {
        String id = String.valueOf(channelSettled.getChannelEvent().getId());
        updateUserCount(tokenNetworkDelta);
        long tokenNetworkDeposit = tokenNetworkDelta.getTotalDeposit();
        tokenNetworkDeposit -= channelSettled.getParticipant1Amount();
        tokenNetworkDeposit -= channelSettled.getParticipant2Amount();
        tokenNetworkDelta.setSettledChannels(tokenNetworkDelta.getSettledChannels()+1);
        try {
            tokenNetworkDelta.setTotalDeposit(tokenNetworkDeposit);
            int channels = tokenNetworkDelta.getModifiedChannels().size();
            tokenNetworkDelta.setAvgChannelDeposit((double) (tokenNetworkDeposit / channels));
        } catch (NullPointerException n) {

        }
    }

    private void updateUserCount(TokenNetworkDelta tokenNetworkDelta) {
        String tokenNetworkAddress = tokenNetworkDelta.getTokenNetworkAddress().toString();
        UserCount userCount = userCountStateStore.get(tokenNetworkAddress);
        tokenNetworkDelta.setUsers(userCount.getUser().size());
    }

    private void updateUserCountStore(TokenNetworkDelta tokenNetworkDelta, ChannelSettled channelSettled) {

        String tokenNetworkAddress = channelSettled.getChannelEvent().getTokenNetworkAddress().toString();
        UserCount userCount = userCountStateStore.get(tokenNetworkAddress);
        String id = String.valueOf(channelSettled.getChannelEvent().getId().toString());
        String participant1 = tokenNetworkDelta.getModifiedChannels().get(id).getFirstParticipant().getEthAddress().toString();
        String participant2 = tokenNetworkDelta.getModifiedChannels().get(id).getSecondParticipant().getEthAddress().toString();

        decremectParticipant(userCount, participant1);
        decremectParticipant(userCount, participant2);

        userCountStateStore.put(tokenNetworkAddress, userCount);
    }

    private void decremectParticipant(UserCount userCount, String participant) {
        userCount.getUser().put(participant, userCount.getUser().get(participant) - 1);
        if (userCount.getUser().get(participant) == 0)
            userCount.getUser().remove(participant);
    }
}
