package StateCacherEvent;

import StateCacherTool.KStreamSpecificAvroSerde;

public abstract class StateCacherEvent {
    public StateCacherEvent(String toStreamTopic, KStreamSpecificAvroSerde kStreamSpecificAvroSerde) {
        this.toStreamTopic = toStreamTopic;
        this.kStreamSpecificAvroSerde = kStreamSpecificAvroSerde;
        this.kStreamSpecificAvroSerde.createSerde(this.getClass(), false);
    }

    public abstract void run();
    protected abstract void send();

    protected KStreamSpecificAvroSerde kStreamSpecificAvroSerde;

    protected final String toStreamTopic;
    protected final String topicTokenNetworkCreated = "raidenEvent.TokenNetworkCreated";
    protected final String topicChannelOpened = "raidenEvent.ChannelOpened";
    protected final String topicChannelClosed = "raidenEvent.ChannelClosed";
    protected final String topicChannelNewDeposit = "raidenEvent.ChannelNewDeposit";

}
