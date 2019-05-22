package StateCacherEvents.TokenNetworkDelta.Transformer;

import RaidenMapTokenInfo.TokenInfoBuilder;
import io.raidenmap.event.channel.ChannelEvent;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.Participant;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

import java.math.BigDecimal;
import java.time.Instant;

public abstract class EventTransformer {
    protected KeyValueStore<Key, TokenNetworkDelta> tokenNetworkDeltaStateStore;
    protected KeyValueStore<Key, TokenNetworkDelta> lightTokenNetworkDeltaStateStore;

    protected String stateName;

    protected ProcessorContext context;
    protected int limitModifiedChannelsMapSize = 10;
    protected int punctuatorTimeInSeconds = 10;

    public EventTransformer(String stateName){
        this.stateName = stateName;
    }

    protected abstract void updateChannelEvent(TokenNetworkDelta tokenNetworkDelta, Object channelEvent);

    protected TokenNetworkDelta restoreTokenNetworkDelta(Key key, KeyValueStore<Key, TokenNetworkDelta> tokenNetworkDeltaStateStore) {
        TokenNetworkDelta tokenNetworkDelta = tokenNetworkDeltaStateStore.get(key);
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

    protected void updateChannelState(TokenNetworkDelta tokenNetworkDelta, ChannelEvent channelEvent) {
        String id = String.valueOf(channelEvent.getId());
        tokenNetworkDelta.getModifiedChannels().get(id).setState(this.stateName);
        tokenNetworkDelta.getModifiedChannels().get(id).setLastStateChangeBlock(tokenNetworkDelta.getBlockNumber());

    }

    protected void updateMetadata(TokenNetworkDelta tokenNetworkDelta, ChannelEvent channelEvent) {
        tokenNetworkDelta.setTimestamp(Instant.now().toEpochMilli());
        tokenNetworkDelta.setBlockNumber(channelEvent.getMetadata().getBlockNumber());
        tokenNetworkDelta.setToken(TokenInfoBuilder.buildTokenByTag(tokenNetworkDelta.getToken().getTag()));
    }

}
