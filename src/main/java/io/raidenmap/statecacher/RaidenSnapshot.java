/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.raidenmap.statecacher;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class RaidenSnapshot extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1046004373456448806L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RaidenSnapshot\",\"namespace\":\"io.raidenmap.statecacher\",\"fields\":[{\"name\":\"states\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RaidenDelta\",\"fields\":[{\"name\":\"tokenNetworksCount\",\"type\":\"int\"},{\"name\":\"userCount\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"blockNumber\",\"type\":\"long\"},{\"name\":\"btcValue\",\"type\":\"int\"},{\"name\":\"ethValue\",\"type\":\"int\"},{\"name\":\"tokenNetworksChanges\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"TokenNetworkDelta\",\"fields\":[{\"name\":\"token\",\"type\":{\"type\":\"record\",\"name\":\"Token\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"tag\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"imageUrl\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"valueUsd\",\"type\":\"double\"},{\"name\":\"valueEth\",\"type\":\"double\"},{\"name\":\"valueBtc\",\"type\":\"double\"},{\"name\":\"priceChangeDayUsd\",\"type\":\"float\"},{\"name\":\"priceChangeWeekUsd\",\"type\":\"float\"},{\"name\":\"priceChangeDayEth\",\"type\":\"float\"},{\"name\":\"priceChangeWeekEth\",\"type\":\"float\"},{\"name\":\"priceChangeDayBtc\",\"type\":\"float\"},{\"name\":\"priceChangeWeekBtc\",\"type\":\"float\"},{\"name\":\"marketCap\",\"type\":\"double\"},{\"name\":\"volume\",\"type\":\"double\"},{\"name\":\"timestamp\",\"type\":\"long\"}]}},{\"name\":\"modifiedChannels\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"Channel\",\"fields\":[{\"name\":\"channelId\",\"type\":\"int\"},{\"name\":\"state\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastStateChangeBlock\",\"type\":\"long\"},{\"name\":\"settleTimeout\",\"type\":\"long\"},{\"name\":\"firstParticipant\",\"type\":{\"type\":\"record\",\"name\":\"Participant\",\"fields\":[{\"name\":\"ethAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"deposit\",\"type\":\"long\"},{\"name\":\"withdrawnAmount\",\"type\":\"long\"},{\"name\":\"wantsToClose\",\"type\":\"boolean\"}]}},{\"name\":\"secondParticipant\",\"type\":\"Participant\"}]},\"avro.java.string\":\"String\"}},{\"name\":\"tokenNetworkAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"channelsCount\",\"type\":\"int\"},{\"name\":\"openChannels\",\"type\":\"int\"},{\"name\":\"closedChannels\",\"type\":\"int\"},{\"name\":\"settledChannels\",\"type\":\"int\"},{\"name\":\"avgChannelDeposit\",\"type\":\"double\"},{\"name\":\"totalDeposit\",\"type\":\"long\"},{\"name\":\"users\",\"type\":\"int\"},{\"name\":\"blockNumber\",\"type\":\"long\"}]}}}]}}},{\"name\":\"tokenNetworks\",\"type\":{\"type\":\"array\",\"items\":\"TokenNetworkDelta\"}},{\"name\":\"endpoints\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Endpoint\",\"namespace\":\"io.raidenmap\",\"fields\":[{\"name\":\"ethAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"ipAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"state\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"latitude\",\"type\":\"float\"},{\"name\":\"longitude\",\"type\":\"float\"}]}}},{\"name\":\"blockNumber\",\"type\":\"long\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"twitter\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<RaidenSnapshot> ENCODER =
      new BinaryMessageEncoder<RaidenSnapshot>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<RaidenSnapshot> DECODER =
      new BinaryMessageDecoder<RaidenSnapshot>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<RaidenSnapshot> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<RaidenSnapshot> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<RaidenSnapshot>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this RaidenSnapshot to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a RaidenSnapshot from a ByteBuffer. */
  public static RaidenSnapshot fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.util.List<io.raidenmap.statecacher.RaidenDelta> states;
  @Deprecated public java.util.List<io.raidenmap.statecacher.TokenNetworkDelta> tokenNetworks;
  @Deprecated public java.util.List<io.raidenmap.Endpoint> endpoints;
  @Deprecated public long blockNumber;
  @Deprecated public long timestamp;
  @Deprecated public java.lang.String twitter;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public RaidenSnapshot() {}

  /**
   * All-args constructor.
   * @param states The new value for states
   * @param tokenNetworks The new value for tokenNetworks
   * @param endpoints The new value for endpoints
   * @param blockNumber The new value for blockNumber
   * @param timestamp The new value for timestamp
   * @param twitter The new value for twitter
   */
  public RaidenSnapshot(java.util.List<io.raidenmap.statecacher.RaidenDelta> states, java.util.List<io.raidenmap.statecacher.TokenNetworkDelta> tokenNetworks, java.util.List<io.raidenmap.Endpoint> endpoints, java.lang.Long blockNumber, java.lang.Long timestamp, java.lang.String twitter) {
    this.states = states;
    this.tokenNetworks = tokenNetworks;
    this.endpoints = endpoints;
    this.blockNumber = blockNumber;
    this.timestamp = timestamp;
    this.twitter = twitter;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return states;
    case 1: return tokenNetworks;
    case 2: return endpoints;
    case 3: return blockNumber;
    case 4: return timestamp;
    case 5: return twitter;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: states = (java.util.List<io.raidenmap.statecacher.RaidenDelta>)value$; break;
    case 1: tokenNetworks = (java.util.List<io.raidenmap.statecacher.TokenNetworkDelta>)value$; break;
    case 2: endpoints = (java.util.List<io.raidenmap.Endpoint>)value$; break;
    case 3: blockNumber = (java.lang.Long)value$; break;
    case 4: timestamp = (java.lang.Long)value$; break;
    case 5: twitter = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'states' field.
   * @return The value of the 'states' field.
   */
  public java.util.List<io.raidenmap.statecacher.RaidenDelta> getStates() {
    return states;
  }

  /**
   * Sets the value of the 'states' field.
   * @param value the value to set.
   */
  public void setStates(java.util.List<io.raidenmap.statecacher.RaidenDelta> value) {
    this.states = value;
  }

  /**
   * Gets the value of the 'tokenNetworks' field.
   * @return The value of the 'tokenNetworks' field.
   */
  public java.util.List<io.raidenmap.statecacher.TokenNetworkDelta> getTokenNetworks() {
    return tokenNetworks;
  }

  /**
   * Sets the value of the 'tokenNetworks' field.
   * @param value the value to set.
   */
  public void setTokenNetworks(java.util.List<io.raidenmap.statecacher.TokenNetworkDelta> value) {
    this.tokenNetworks = value;
  }

  /**
   * Gets the value of the 'endpoints' field.
   * @return The value of the 'endpoints' field.
   */
  public java.util.List<io.raidenmap.Endpoint> getEndpoints() {
    return endpoints;
  }

  /**
   * Sets the value of the 'endpoints' field.
   * @param value the value to set.
   */
  public void setEndpoints(java.util.List<io.raidenmap.Endpoint> value) {
    this.endpoints = value;
  }

  /**
   * Gets the value of the 'blockNumber' field.
   * @return The value of the 'blockNumber' field.
   */
  public java.lang.Long getBlockNumber() {
    return blockNumber;
  }

  /**
   * Sets the value of the 'blockNumber' field.
   * @param value the value to set.
   */
  public void setBlockNumber(java.lang.Long value) {
    this.blockNumber = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.Long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'twitter' field.
   * @return The value of the 'twitter' field.
   */
  public java.lang.String getTwitter() {
    return twitter;
  }

  /**
   * Sets the value of the 'twitter' field.
   * @param value the value to set.
   */
  public void setTwitter(java.lang.String value) {
    this.twitter = value;
  }

  /**
   * Creates a new RaidenSnapshot RecordBuilder.
   * @return A new RaidenSnapshot RecordBuilder
   */
  public static io.raidenmap.statecacher.RaidenSnapshot.Builder newBuilder() {
    return new io.raidenmap.statecacher.RaidenSnapshot.Builder();
  }

  /**
   * Creates a new RaidenSnapshot RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new RaidenSnapshot RecordBuilder
   */
  public static io.raidenmap.statecacher.RaidenSnapshot.Builder newBuilder(io.raidenmap.statecacher.RaidenSnapshot.Builder other) {
    return new io.raidenmap.statecacher.RaidenSnapshot.Builder(other);
  }

  /**
   * Creates a new RaidenSnapshot RecordBuilder by copying an existing RaidenSnapshot instance.
   * @param other The existing instance to copy.
   * @return A new RaidenSnapshot RecordBuilder
   */
  public static io.raidenmap.statecacher.RaidenSnapshot.Builder newBuilder(io.raidenmap.statecacher.RaidenSnapshot other) {
    return new io.raidenmap.statecacher.RaidenSnapshot.Builder(other);
  }

  /**
   * RecordBuilder for RaidenSnapshot instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<RaidenSnapshot>
    implements org.apache.avro.data.RecordBuilder<RaidenSnapshot> {

    private java.util.List<io.raidenmap.statecacher.RaidenDelta> states;
    private java.util.List<io.raidenmap.statecacher.TokenNetworkDelta> tokenNetworks;
    private java.util.List<io.raidenmap.Endpoint> endpoints;
    private long blockNumber;
    private long timestamp;
    private java.lang.String twitter;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.raidenmap.statecacher.RaidenSnapshot.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.states)) {
        this.states = data().deepCopy(fields()[0].schema(), other.states);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tokenNetworks)) {
        this.tokenNetworks = data().deepCopy(fields()[1].schema(), other.tokenNetworks);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.endpoints)) {
        this.endpoints = data().deepCopy(fields()[2].schema(), other.endpoints);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.blockNumber)) {
        this.blockNumber = data().deepCopy(fields()[3].schema(), other.blockNumber);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.twitter)) {
        this.twitter = data().deepCopy(fields()[5].schema(), other.twitter);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing RaidenSnapshot instance
     * @param other The existing instance to copy.
     */
    private Builder(io.raidenmap.statecacher.RaidenSnapshot other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.states)) {
        this.states = data().deepCopy(fields()[0].schema(), other.states);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tokenNetworks)) {
        this.tokenNetworks = data().deepCopy(fields()[1].schema(), other.tokenNetworks);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.endpoints)) {
        this.endpoints = data().deepCopy(fields()[2].schema(), other.endpoints);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.blockNumber)) {
        this.blockNumber = data().deepCopy(fields()[3].schema(), other.blockNumber);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.twitter)) {
        this.twitter = data().deepCopy(fields()[5].schema(), other.twitter);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'states' field.
      * @return The value.
      */
    public java.util.List<io.raidenmap.statecacher.RaidenDelta> getStates() {
      return states;
    }

    /**
      * Sets the value of the 'states' field.
      * @param value The value of 'states'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder setStates(java.util.List<io.raidenmap.statecacher.RaidenDelta> value) {
      validate(fields()[0], value);
      this.states = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'states' field has been set.
      * @return True if the 'states' field has been set, false otherwise.
      */
    public boolean hasStates() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'states' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder clearStates() {
      states = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'tokenNetworks' field.
      * @return The value.
      */
    public java.util.List<io.raidenmap.statecacher.TokenNetworkDelta> getTokenNetworks() {
      return tokenNetworks;
    }

    /**
      * Sets the value of the 'tokenNetworks' field.
      * @param value The value of 'tokenNetworks'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder setTokenNetworks(java.util.List<io.raidenmap.statecacher.TokenNetworkDelta> value) {
      validate(fields()[1], value);
      this.tokenNetworks = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'tokenNetworks' field has been set.
      * @return True if the 'tokenNetworks' field has been set, false otherwise.
      */
    public boolean hasTokenNetworks() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'tokenNetworks' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder clearTokenNetworks() {
      tokenNetworks = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'endpoints' field.
      * @return The value.
      */
    public java.util.List<io.raidenmap.Endpoint> getEndpoints() {
      return endpoints;
    }

    /**
      * Sets the value of the 'endpoints' field.
      * @param value The value of 'endpoints'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder setEndpoints(java.util.List<io.raidenmap.Endpoint> value) {
      validate(fields()[2], value);
      this.endpoints = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'endpoints' field has been set.
      * @return True if the 'endpoints' field has been set, false otherwise.
      */
    public boolean hasEndpoints() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'endpoints' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder clearEndpoints() {
      endpoints = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'blockNumber' field.
      * @return The value.
      */
    public java.lang.Long getBlockNumber() {
      return blockNumber;
    }

    /**
      * Sets the value of the 'blockNumber' field.
      * @param value The value of 'blockNumber'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder setBlockNumber(long value) {
      validate(fields()[3], value);
      this.blockNumber = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'blockNumber' field has been set.
      * @return True if the 'blockNumber' field has been set, false otherwise.
      */
    public boolean hasBlockNumber() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'blockNumber' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder clearBlockNumber() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }

    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder setTimestamp(long value) {
      validate(fields()[4], value);
      this.timestamp = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder clearTimestamp() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'twitter' field.
      * @return The value.
      */
    public java.lang.String getTwitter() {
      return twitter;
    }

    /**
      * Sets the value of the 'twitter' field.
      * @param value The value of 'twitter'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder setTwitter(java.lang.String value) {
      validate(fields()[5], value);
      this.twitter = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'twitter' field has been set.
      * @return True if the 'twitter' field has been set, false otherwise.
      */
    public boolean hasTwitter() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'twitter' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.RaidenSnapshot.Builder clearTwitter() {
      twitter = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RaidenSnapshot build() {
      try {
        RaidenSnapshot record = new RaidenSnapshot();
        record.states = fieldSetFlags()[0] ? this.states : (java.util.List<io.raidenmap.statecacher.RaidenDelta>) defaultValue(fields()[0]);
        record.tokenNetworks = fieldSetFlags()[1] ? this.tokenNetworks : (java.util.List<io.raidenmap.statecacher.TokenNetworkDelta>) defaultValue(fields()[1]);
        record.endpoints = fieldSetFlags()[2] ? this.endpoints : (java.util.List<io.raidenmap.Endpoint>) defaultValue(fields()[2]);
        record.blockNumber = fieldSetFlags()[3] ? this.blockNumber : (java.lang.Long) defaultValue(fields()[3]);
        record.timestamp = fieldSetFlags()[4] ? this.timestamp : (java.lang.Long) defaultValue(fields()[4]);
        record.twitter = fieldSetFlags()[5] ? this.twitter : (java.lang.String) defaultValue(fields()[5]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<RaidenSnapshot>
    WRITER$ = (org.apache.avro.io.DatumWriter<RaidenSnapshot>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<RaidenSnapshot>
    READER$ = (org.apache.avro.io.DatumReader<RaidenSnapshot>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
