package StateCacherEvent.Manager;

import io.raidenmap.event.Metadata;
import io.raidenmap.event.channel.ChannelNewDeposit;
import io.raidenmap.event.tokenNetwork.TokenNetworkCreated;
import io.raidenmap.statecacher.Token;
import io.raidenmap.statecacher.TokenNetworkDelta;

import java.time.Instant;

public class TokenNetworkManager {

    public void updateToken(TokenNetworkDelta tokenNetworkDelta, TokenNetworkCreated tokenNetworkCreated) {
        String tokenNetworkAddress = tokenNetworkCreated.getTokenNetworkAddress().toString();
        tokenNetworkDelta.setTokenNetworkAddress(tokenNetworkAddress);
        tokenNetworkDelta.setToken(tokenBuilder.build());
        tokenNetworkDelta.getToken().setName("TokenNotRegistered");
    }

    public void updateMetadate(TokenNetworkDelta tokenNetworkDelta, Metadata metadata) {
        updateTimestamp(tokenNetworkDelta);
        updateBlockNumber(tokenNetworkDelta, metadata);
    }

    public void updateTotalDeposit(TokenNetworkDelta tokenNetworkDelta, ChannelNewDeposit channelNewDeposit) {
        long totalDeposit = tokenNetworkDelta.getTotalDeposit() + channelNewDeposit.getTotalDeposit();
        tokenNetworkDelta.setTotalDeposit(totalDeposit);
    }

    public void updateTimestamp(TokenNetworkDelta tokenNetworkDelta) {
        tokenNetworkDelta.setTimestamp(Instant.now().toEpochMilli());
    }

    public void updateBlockNumber(TokenNetworkDelta tokenNetworkDelta, Metadata metadata) {
        tokenNetworkDelta.setBlockNumber(metadata.getBlockNumber());
        tokenNetworkDelta.setTimestamp(Instant.now().toEpochMilli());
    }

    public void updateChannelsOpened(TokenNetworkDelta tokenNetworkDelta) {
        tokenNetworkDelta.setChannelsCount(tokenNetworkDelta.getChannelsCount() + 1);
        tokenNetworkDelta.setOpenChannels(tokenNetworkDelta.getOpenChannels() + 1);
    }

    public void updateChannelsClosed(TokenNetworkDelta tokenNetworkDelta) {
        tokenNetworkDelta.setClosedChannels(tokenNetworkDelta.getClosedChannels() + 1);
        tokenNetworkDelta.setOpenChannels(tokenNetworkDelta.getOpenChannels() - 1);
    }

    private Token.Builder tokenBuilder;
}
