package StateCacherEvent;

import StateCacherTool.KStreamSpecificAvroSerde;
import io.raidenmap.statecacher.TokenNetworkSnapshot;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

import java.util.concurrent.ConcurrentHashMap;

public class TokenNetworkSnapshotEvent extends StateCacherEvent {
    public TokenNetworkSnapshotEvent(String toStreamTopic, KStreamSpecificAvroSerde kStreamSpecificAvroSerde) {
        super(toStreamTopic, kStreamSpecificAvroSerde);
        tokenNetworkStateHashMap = new ConcurrentHashMap<>();
    }

    @Override
    public void run() {
        //consumeTokenNetworkAggregate();
    }

    @Override
    protected void send() {

    }

    //TO DO
    private void consumeTokenNetworkAggregate() {

    }

    private String tokenNetworkAddress;
    protected static ConcurrentHashMap<String, TokenNetworkSnapshot> tokenNetworkStateHashMap;
    protected KStream<String, TokenNetworkSnapshot> tokenNetworkStateKStream;

}
