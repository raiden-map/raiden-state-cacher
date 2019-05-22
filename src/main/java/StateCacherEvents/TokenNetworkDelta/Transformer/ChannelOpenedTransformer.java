package StateCacherEvents.TokenNetworkDelta.Transformer;

import StateCacherEvents.StateStores;
import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.*;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.HashMap;
import java.util.Map;

public class ChannelOpenedTransformer extends EventTransformer implements Transformer<ProducerKey, ChannelOpened, KeyValue<Key, TokenNetworkDelta>> {

    protected KeyValueStore<String, UserCount> userCountStateStore;

    public ChannelOpenedTransformer() {
        super("ChannelOpened");
    }

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        tokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.tokenNetworkDeltaStoreName);
        lightTokenNetworkDeltaStateStore = (KeyValueStore) this.context.getStateStore(StateStores.lightTokenNetworkDeltaStoreName);
        userCountStateStore = (KeyValueStore) this.context.getStateStore(StateStores.userCountStoreName);
    }

    @Override
    public KeyValue<Key, TokenNetworkDelta> transform(ProducerKey producerKey, ChannelOpened channelOpened) {
        String address = channelOpened.getChannelEvent().getTokenNetworkAddress().toString();
        Key key = new Key(address);

        updateUserCountStore(channelOpened);

        TokenNetworkDelta tokenNetworkDelta = restoreTokenNetworkDelta(key, tokenNetworkDeltaStateStore);
        updateChannelEvent(tokenNetworkDelta, channelOpened);
        tokenNetworkDeltaStateStore.put(key, tokenNetworkDelta);

        TokenNetworkDelta lightTokenNetworkDelta = restoreTokenNetworkDelta(key, lightTokenNetworkDeltaStateStore);
        updateChannelEvent(lightTokenNetworkDelta, channelOpened);
        lightTokenNetworkDeltaStateStore.put(key, lightTokenNetworkDelta);

        return KeyValue.pair(key, lightTokenNetworkDelta);
    }

    @Override
    public void close() {

    }

    @Override
    protected void updateChannelEvent(TokenNetworkDelta tokenNetworkDelta, Object channelEvent) {
        addChannel(tokenNetworkDelta, (ChannelOpened) channelEvent);
        incrementChannelCount(tokenNetworkDelta);
        updateUserCount(tokenNetworkDelta);
        updateMetadata(tokenNetworkDelta, ((ChannelOpened)channelEvent).getChannelEvent());
    }

    private void incrementChannelCount(TokenNetworkDelta tokenNetworkDelta) {
        tokenNetworkDelta.setChannelsCount(tokenNetworkDelta.getChannelsCount() + 1);
        tokenNetworkDelta.setOpenChannels(tokenNetworkDelta.getOpenChannels() + 1);
    }

    private void updateUserCount( TokenNetworkDelta tokenNetworkDelta){
        String tokenNetworkAddress = tokenNetworkDelta.getTokenNetworkAddress().toString();
        UserCount userCount = userCountStateStore.get(tokenNetworkAddress);
        tokenNetworkDelta.setUsers(userCount.getUser().size());
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
        return new Participant("", "0", "0", false);
    }

    private void updateUserCountStore(ChannelOpened channelOpened ){

        String tokenNetworkAddress = channelOpened.getChannelEvent().getTokenNetworkAddress().toString();
        UserCount userCount = userCountStateStore.get(tokenNetworkAddress);
        String participant1 = channelOpened.getParticipant1().toString();
        String participant2 = channelOpened.getParticipant2().toString();

        if(userCount == null) {
            userCount = new UserCount();
            userCount.setUser(new HashMap<>());
        }
        incremectParticipant(userCount.getUser(), participant1);
        incremectParticipant(userCount.getUser(), participant2);

        userCountStateStore.put(tokenNetworkAddress, userCount);
    }

    private void incremectParticipant(Map<String, Integer> userCount, String participant){

        if(userCount.containsKey(participant)) {
            int tmp = userCount.get(participant);
            userCount.put(participant, tmp + 1);
        }
        else
            userCount.put(participant, 1);
    }
}
