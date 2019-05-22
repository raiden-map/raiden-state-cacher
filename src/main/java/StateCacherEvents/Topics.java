package StateCacherEvents;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Topics {

    public static void checkTopicsExistence(Properties property){
        Topics.verifyAndCreate(Topics.channelClosed, property);
        Topics.verifyAndCreate(Topics.channelSettled, property);
        Topics.verifyAndCreate(Topics.channelNewDeposit, property);
        Topics.verifyAndCreate(Topics.channelOpened, property);
        Topics.verifyAndCreate(Topics.tokenNetworkCreated, property);
        Topics.verifyAndCreate(Topics.endpoint, property);
        Topics.verifyAndCreate(Topics.tokenNetworkDelta, property);
        Topics.verifyAndCreate(Topics.tokenNetworkSnapshot, property);
        Topics.verifyAndCreate(Topics.raidenDelta, property);
        Topics.verifyAndCreate(Topics.raidenSnapshot, property);
    }

    public static void verifyAndCreate(String topicName, Properties properties) {
        AdminClient adminClient = AdminClient.create(properties);
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        try {
            if (!listTopicsResult.names().get().contains(topicName)) {
                NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);
                adminClient.createTopics(Collections.singleton(newTopic));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static final String prefix = "raidenEvent_TN_TEST_7.";

    public final static String tokenNetworkCreated = prefix + "TokenNetworkCreated";
    public final static String channelOpened = prefix + "ChannelOpened";
    public final static String channelClosed = prefix + "ChannelClosed";
    public final static String channelNewDeposit = prefix + "ChannelNewDeposit";
    public final static String channelSettled = prefix + "ChannelSettled";
    public final static String endpoint = prefix + "AddressRegistered";

    public final static String raidenDelta = prefix + "raidenDeltaTest0";
    public final static String raidenSnapshot = prefix + "raidenSnapshotTest0";
    public final static String tokenNetworkDelta = prefix + "tokenNetworkDeltaTest0";
    public final static String tokenNetworkSnapshot = prefix + "tokenNetworkSnapshotTest0";
}
