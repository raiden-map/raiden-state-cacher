package StateCacherEvents;

public class Topics {

    public static void verifyAndCreate(String topicName, Properties properties) {
        AdminClient adminClient = AdminClient.create(properties);
        ListTopicsResult listTopicsResult = adminClient.listTopics();
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
