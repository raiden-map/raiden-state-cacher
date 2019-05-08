package StateCacherEvent.TokenNetworkDelta.Transformer;

import RaidenMapTokenInfo.TokenInfoBuilder;
import io.raidenmap.event.channel.ChannelEvent;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.Participant;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Instant;
import java.util.Objects;

public abstract class EventTransformer {
    protected KeyValueStore<Key, TokenNetworkDelta> stateStore;
    protected String storeName;
    protected KeyValueStore<Key, TokenNetworkDelta> lightStateStore;
    protected String lightStoreName;
    protected String stateName;
    protected ProcessorContext context;
    protected int limitModifiedChannelsMapSize = 10;
    protected int punctuatorTimeInSeconds = 10;

    public EventTransformer(String storeName, String stateName){
        Objects.requireNonNull(storeName, "Store Name can't be null");
        this.storeName = storeName;
        this.lightStoreName = "light-"+storeName;
        this.stateName = stateName;
    }

    protected abstract void updateChannelEvent(TokenNetworkDelta tokenNetworkDelta, Object channelEvent);

    protected TokenNetworkDelta restoreTokenNetworkDelta(Key key, KeyValueStore<Key, TokenNetworkDelta> stateStore) {
        TokenNetworkDelta tokenNetworkDelta = stateStore.get(key);
        return tokenNetworkDelta;
    }

    protected void checkAndInsertChannel(String id, TokenNetworkDelta lightTokenNetworkDelta, TokenNetworkDelta tokenNetworkDelta) {
        if (!lightTokenNetworkDelta.getModifiedChannels().containsKey(id)) {
            lightTokenNetworkDelta.getModifiedChannels().put(id, Channel.newBuilder(tokenNetworkDelta.getModifiedChannels().get(id)).build());
        }
    }

    protected Participant findParticipant(Channel channel, String participant) {
        if (channel.getFirstParticipant().getEthAddress().toString().equals(participant)) {
            return channel.getFirstParticipant();
        } else if (channel.getSecondParticipant().getEthAddress().toString().equals(participant)) {
            return channel.getSecondParticipant();
        } else return null;
    }

    protected void updateChannelState(TokenNetworkDelta tokenNetworkDelta, ChannelEvent channelEvent, String newState) {
        String id = String.valueOf(channelEvent.getId());
        tokenNetworkDelta.getModifiedChannels().get(id).setState(newState);
        tokenNetworkDelta.getModifiedChannels().get(id).setLastStateChangeBlock(tokenNetworkDelta.getBlockNumber());

    }

    protected void updateMetadata(TokenNetworkDelta tokenNetworkDelta, ChannelEvent channelEvent) {
        tokenNetworkDelta.setTimestamp(Instant.now().toEpochMilli());
        tokenNetworkDelta.setBlockNumber(channelEvent.getMetadata().getBlockNumber());
        tokenNetworkDelta.setToken(TokenInfoBuilder.buildTokenByTag(tokenNetworkDelta.getToken().getTag()));
    }
}
