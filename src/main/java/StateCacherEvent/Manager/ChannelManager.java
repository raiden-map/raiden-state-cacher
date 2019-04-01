package StateCacherEvent.Manager;

import io.raidenmap.event.channel.ChannelClosed;
import io.raidenmap.event.channel.ChannelEvent;
import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.event.channel.ChannelOpened;
import io.raidenmap.statecacher.Channel;
import io.raidenmap.statecacher.Participant;

import java.util.Map;

public class ChannelManager {

    public int getID(ChannelEvent channelEvent) {
        return channelEvent.getId();
    }

    public void updateNewChannel(Channel channel, ChannelOpened channelOpened) {
        String participant1 = channelOpened.getParticipant1().toString();
        String participant2 = channelOpened.getParticipant2().toString();

        channel.setChannelId(channelOpened.getChannelEvent().getId());
        channel.setState(channelOpened.getClass().getName());
        channel.setSettleTimeout(channelOpened.getSettleTimeout());
        channel.setLastStateChangeBlock(0L);//TO DO
        channel.setFirstParticipant(participantBuilder.build());
        channel.setSecondParticipant(participantBuilder.build());
        channel.getFirstParticipant().setEthAddress(participant1);
        channel.getSecondParticipant().setEthAddress(participant2);
    }

    public void updateUsers(Channel channel, Map<String, Integer> users) {
        String participant1 = channel.getFirstParticipant().toString();
        String participant2 = channel.getSecondParticipant().toString();

        users.put(participant1, users.containsKey(participant1) ? users.get(participant1) + 1 : 0);
        users.put(participant2, users.containsKey(participant2) ? users.get(participant2) + 1 : 0);
    }

    public void updateNewDeposit(Channel channel, ChannelNewDeposit channelNewDeposit) {
        long deposit = channelNewDeposit.getTotalDeposit();
        String participant = channelNewDeposit.getParticipant().toString();
        channel.getParticipant(participant).setDeposit(deposit);
        channel.getParticipant(participant).setDeposit(deposit);
    }

    public void updateChannelClosed(Channel channel, ChannelClosed channelClosed) {
        String participant = channelClosed.getParticipant().toString();
        channel.getParticipant(participant).setWantsToClose(true);
    }


    private Participant.Builder participantBuilder;


}
