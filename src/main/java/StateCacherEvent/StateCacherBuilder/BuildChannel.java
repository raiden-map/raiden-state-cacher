package StateCacherEvent.StateCacherBuilder;

import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Participant;

import java.util.List;
import java.util.Map;

public class BuildChannel {

    public Channel build(ChannelOpened channelOpened, Map<String, Integer> users) {
        String participant1 = channelOpened.getParticipant1().toString();
        String participant2 = channelOpened.getParticipant2().toString();

        users.put(participant1, users.containsKey(participant1) ? users.get(participant1) + 1 : users.get(participant1));
        users.put(participant2, users.containsKey(participant2) ? users.get(participant2) + 1 : users.get(participant2));

        Channel channel = Channel.newBuilder().build();
        channel.setChannelId(channelOpened.getChannelEvent().getId());
        channel.setState(channelOpened.getClass().getName());
        channel.setFirstParticipant(new Participant(participant1, (long) 0, (long) 0, false));
        channel.setSecondParticipant(new Participant(participant2, (long) 0, (long) 0, false));
        return channel;
    }

    public void build(ChannelNewDeposit channelNewDeposit, List<Channel> channelList) {
        int channelId = channelNewDeposit.getChannelEvent().getId();
        long deposit = channelNewDeposit.getTotalDeposit();
        String participant = channelNewDeposit.getParticipant().toString();

        channelList.get(channelId).getParticipant(participant).setDeposit(deposit);
    }

    public void build(ChannelClosed channelClosed, List<Channel> channelList) {
        int channelId = channelClosed.getChannelEvent().getId();
        String participant = channelClosed.getParticipant().toString();

        channelList.get(channelId).getParticipant(participant).setWantsToClose(true);
    }
}
