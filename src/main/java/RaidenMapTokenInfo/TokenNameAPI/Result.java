
package RaidenMapTokenInfo.TokenNameAPI;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "blockNumber",
    "timeStamp",
    "hash",
    "nonce",
    "blockHash",
    "from",
    "contractAddress",
    "to",
    "value",
    "tokenName",
    "tokenSymbol",
    "tokenDecimal",
    "transactionIndex",
    "gas",
    "gasPrice",
    "gasUsed",
    "cumulativeGasUsed",
    "input",
    "confirmations"
})
public class Result {

    @JsonProperty("blockNumber")
    private String blockNumber;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("nonce")
    private String nonce;
    @JsonProperty("blockHash")
    private String blockHash;
    @JsonProperty("from")
    private String from;
    @JsonProperty("contractAddress")
    private String contractAddress;
    @JsonProperty("to")
    private String to;
    @JsonProperty("value")
    private String value;
    @JsonProperty("tokenName")
    private String tokenName;
    @JsonProperty("tokenSymbol")
    private String tokenSymbol;
    @JsonProperty("tokenDecimal")
    private String tokenDecimal;
    @JsonProperty("transactionIndex")
    private String transactionIndex;
    @JsonProperty("gas")
    private String gas;
    @JsonProperty("gasPrice")
    private String gasPrice;
    @JsonProperty("gasUsed")
    private String gasUsed;
    @JsonProperty("cumulativeGasUsed")
    private String cumulativeGasUsed;
    @JsonProperty("input")
    private String input;
    @JsonProperty("confirmations")
    private String confirmations;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("blockNumber")
    public String getBlockNumber() {
        return blockNumber;
    }

    @JsonProperty("blockNumber")
    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("nonce")
    public String getNonce() {
        return nonce;
    }

    @JsonProperty("nonce")
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @JsonProperty("blockHash")
    public String getBlockHash() {
        return blockHash;
    }

    @JsonProperty("blockHash")
    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    @JsonProperty("contractAddress")
    public String getContractAddress() {
        return contractAddress;
    }

    @JsonProperty("contractAddress")
    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("tokenName")
    public String getTokenName() {
        return tokenName;
    }

    @JsonProperty("tokenName")
    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    @JsonProperty("tokenSymbol")
    public String getTokenSymbol() {
        return tokenSymbol;
    }

    @JsonProperty("tokenSymbol")
    public void setTokenSymbol(String tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
    }

    @JsonProperty("tokenDecimal")
    public String getTokenDecimal() {
        return tokenDecimal;
    }

    @JsonProperty("tokenDecimal")
    public void setTokenDecimal(String tokenDecimal) {
        this.tokenDecimal = tokenDecimal;
    }

    @JsonProperty("transactionIndex")
    public String getTransactionIndex() {
        return transactionIndex;
    }

    @JsonProperty("transactionIndex")
    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    @JsonProperty("gas")
    public String getGas() {
        return gas;
    }

    @JsonProperty("gas")
    public void setGas(String gas) {
        this.gas = gas;
    }

    @JsonProperty("gasPrice")
    public String getGasPrice() {
        return gasPrice;
    }

    @JsonProperty("gasPrice")
    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    @JsonProperty("gasUsed")
    public String getGasUsed() {
        return gasUsed;
    }

    @JsonProperty("gasUsed")
    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    @JsonProperty("cumulativeGasUsed")
    public String getCumulativeGasUsed() {
        return cumulativeGasUsed;
    }

    @JsonProperty("cumulativeGasUsed")
    public void setCumulativeGasUsed(String cumulativeGasUsed) {
        this.cumulativeGasUsed = cumulativeGasUsed;
    }

    @JsonProperty("input")
    public String getInput() {
        return input;
    }

    @JsonProperty("input")
    public void setInput(String input) {
        this.input = input;
    }

    @JsonProperty("confirmations")
    public String getConfirmations() {
        return confirmations;
    }

    @JsonProperty("confirmations")
    public void setConfirmations(String confirmations) {
        this.confirmations = confirmations;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
