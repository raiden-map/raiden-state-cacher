import StateCacherEvent.*;
import StateCacherTool.KStreamSpecificAvroSerde;
import StateCacherTool.KafkaManager;

public class Main {
    public static void main(String args[]) {

        KafkaManager tokenNetworkDeltaKafkaManager = new KafkaManager("TokenNetworkDelta");
        KStreamSpecificAvroSerde tokenNetworkDeltaKStreamManager = new KStreamSpecificAvroSerde(tokenNetworkDeltaKafkaManager.getBuilder(), tokenNetworkDeltaKafkaManager.getSchemaRegistry());
        StateCacherEvent tokenNetworkDeltaEvent = new TokenNetworkDeltaEvent("raidenEvent.TokenNetworkDelta", tokenNetworkDeltaKStreamManager);

        tokenNetworkDeltaEvent.run();
        tokenNetworkDeltaKafkaManager.start();
    }
}
