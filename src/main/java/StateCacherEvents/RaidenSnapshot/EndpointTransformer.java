package StateCacherEvents.RaidenSnapshot;

import EndpointAPI.EndpointAPI;
import StateCacherEvents.StateStores;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.raidenmap.Endpoint;

import io.raidenmap.event.Endpoint.AddressRegistered;
import io.raidenmap.producerKey.ProducerKey;
import io.raidenmap.statecacher.Key;
import io.raidenmap.statecacher.RaidenSnapshot;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class EndpointTransformer implements Transformer<ProducerKey, AddressRegistered, KeyValue<Key, RaidenSnapshot>> {
    protected KeyValueStore<Key, RaidenSnapshot> raidenSnapshotKeyValueStore;
    protected ProcessorContext context;
    private Key raidenSnapshotKey;

    EndpointTransformer(){
        raidenSnapshotKey = new Key("raidenSnapshotKey");
    }
    @Override
    public void init(ProcessorContext context) {
        this.context = context;
        raidenSnapshotKeyValueStore = (KeyValueStore) this.context.getStateStore(StateStores.raidenSnapshotStoreName);
        raidenSnapshotKey = new Key("raidenSnapshotKey");

    }

    @Override
    public KeyValue<Key, RaidenSnapshot> transform(ProducerKey producerKey, AddressRegistered addressRegistered) {

        RaidenSnapshot raidenSnapshot = raidenSnapshotKeyValueStore.get(raidenSnapshotKey);
        if(raidenSnapshot == null)
            raidenSnapshot = new RaidenSnapshot(new ArrayList<>(), new HashMap<>(), new ArrayList<>(), 0l, 0l, "");

        Endpoint endpoint = createEndpoint(addressRegistered.getEthAddress(), addressRegistered.getEndpointAddress());
        raidenSnapshot.getEndpoints().add(endpoint);
        raidenSnapshotKeyValueStore.put(raidenSnapshotKey, raidenSnapshot);
        return KeyValue.pair(raidenSnapshotKey, raidenSnapshot);
    }

    @Override
    public void close() {

    }

    private Endpoint createEndpoint(String ethAddress, String endpointAddress){
        EndpointAPI endpointAPI = getIPGeolocalizationRequest(endpointAddress);
        /*if( endpointAPI != null){
            return new Endpoint(ethAddress, endpointAPI.getQuery(), endpointAPI.getCountry(), endpointAPI.getLat(), endpointAPI.getLon());
        }
        else*/
            return new Endpoint(ethAddress, endpointAddress, "TEST ENDPOINT", 0f, 0f);

    }

    private EndpointAPI getIPGeolocalizationRequest(String endpointAddress){
        Gson gson = new Gson();
        JSONObject responseBody;
        EndpointAPI endpointAPI;
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.
                    get("http://ip-api.com/json/{ip}")
                    .routeParam("ip", endpointAddress)
                    .asJson();
        } catch (UnirestException e) {
            return null;
        }
        responseBody = response.getBody().getObject();
        try{
            endpointAPI = gson.fromJson((responseBody).toString(), EndpointAPI.class);
        }catch (JsonSyntaxException e){
            return null;
        }
        return endpointAPI;
    }
}
