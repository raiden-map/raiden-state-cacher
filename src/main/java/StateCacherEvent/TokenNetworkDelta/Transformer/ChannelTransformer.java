package StateCacherEvent.TokenNetworkDelta.Transformer;

import io.raidenmap.event.channel.ChannelEvent;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Participant;
import io.raidenmap.statecacher.TokenNetworkDelta;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Instant;
import java.util.Objects;

public abstract class ChannelTransformer {
    protected KeyValueStore<String, TokenNetworkDelta> stateStore;
    protected String storeName;
    protected String stateName;
    protected ProcessorContext context;

    public ChannelTransformer(String storeName, String stateName){
        Objects.requireNonNull(storeName, "Store Name can't be null");
        this.storeName = storeName;
        this.stateName = stateName;
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
    }
}
