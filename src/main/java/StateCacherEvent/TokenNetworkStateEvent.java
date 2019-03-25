package StateCacherEvent;

import StateCacherTool.KStreamSpecificAvroSerde;
import io.raidenmap.statecacher.TokenNetworkAggregate;
import io.raidenmap.statecacher.TokenNetworkState;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

import java.util.concurrent.ConcurrentHashMap;

public class TokenNetworkStateEvent extends StateCacherEvent {
    public TokenNetworkStateEvent(StreamsBuilder builder, String toStreamTopic, KStreamSpecificAvroSerde kStreamSpecificAvroSerde) {
        super(builder, toStreamTopic, kStreamSpecificAvroSerde);
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
    private void consumeTokenNetworkAggregate(){

    }

    private String tokenNetworkAddress;
    protected static ConcurrentHashMap<String, TokenNetworkState> tokenNetworkStateHashMap;
    protected KStream<String, TokenNetworkState> tokenNetworkStateKStream;

}
