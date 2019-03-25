package StateCacherEvent;

import StateCacherTool.KStreamSpecificAvroSerde;
import org.apache.kafka.streams.StreamsBuilder;

public abstract class StateCacherEvent {
    public StateCacherEvent(StreamsBuilder builder, String toStreamTopic, KStreamSpecificAvroSerde kStreamSpecificAvroSerde) {
        this.builder = builder;
        this.toStreamTopic = toStreamTopic;
        this.kStreamSpecificAvroSerde = kStreamSpecificAvroSerde;
        this.kStreamSpecificAvroSerde.createSerde(this.getClass(), false);
    }

    public abstract void run();
    protected abstract void send();

    protected StreamsBuilder builder;
    protected KStreamSpecificAvroSerde kStreamSpecificAvroSerde;

    protected final String toStreamTopic;
    protected final String topicTokenNetworkCreated = "raidenEvent.TokenNetworkCreated";
    protected final String topicChannelOpened = "raidenEvent.ChannelOpened";
    protected final String topicChannelClosed = "raidenEvent.ChannelClosed";
    protected final String topicChannelNewDeposit = "raidenEvent.ChannelNewDeposit";
    //protected final String topicTokenNetworkAggregate = "raidenEvent.ChannelNewDeposit";
    protected final String topicRaidenAggregate = "testTKA";
    protected final String topicRaidenState = "testTKS";

}
