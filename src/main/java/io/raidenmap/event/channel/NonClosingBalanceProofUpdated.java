/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.raidenmap.event.channel;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class NonClosingBalanceProofUpdated extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -107894423138265711L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"NonClosingBalanceProofUpdated\",\"namespace\":\"io.raidenmap.event.channel\",\"fields\":[{\"name\":\"channelEvent\",\"type\":{\"type\":\"record\",\"name\":\"ChannelEvent\",\"fields\":[{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"Metadata\",\"namespace\":\"io.raidenmap.event\",\"fields\":[{\"name\":\"blockNumber\",\"type\":\"long\"},{\"name\":\"blockTimestamp\",\"type\":\"long\"},{\"name\":\"eventTimestamp\",\"type\":\"long\"}]}},{\"name\":\"tokenNetworkAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"id\",\"type\":\"int\"}]}},{\"name\":\"closingParticipant\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"nonce\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<NonClosingBalanceProofUpdated> ENCODER =
      new BinaryMessageEncoder<NonClosingBalanceProofUpdated>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<NonClosingBalanceProofUpdated> DECODER =
      new BinaryMessageDecoder<NonClosingBalanceProofUpdated>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<NonClosingBalanceProofUpdated> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<NonClosingBalanceProofUpdated> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<NonClosingBalanceProofUpdated>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this NonClosingBalanceProofUpdated to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a NonClosingBalanceProofUpdated from a ByteBuffer. */
  public static NonClosingBalanceProofUpdated fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public io.raidenmap.event.channel.ChannelEvent channelEvent;
  @Deprecated public java.lang.String closingParticipant;
  @Deprecated public int nonce;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public NonClosingBalanceProofUpdated() {}

  /**
   * All-args constructor.
   * @param channelEvent The new value for channelEvent
   * @param closingParticipant The new value for closingParticipant
   * @param nonce The new value for nonce
   */
  public NonClosingBalanceProofUpdated(io.raidenmap.event.channel.ChannelEvent channelEvent, java.lang.String closingParticipant, java.lang.Integer nonce) {
    this.channelEvent = channelEvent;
    this.closingParticipant = closingParticipant;
    this.nonce = nonce;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return channelEvent;
    case 1: return closingParticipant;
    case 2: return nonce;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: channelEvent = (io.raidenmap.event.channel.ChannelEvent)value$; break;
    case 1: closingParticipant = (java.lang.String)value$; break;
    case 2: nonce = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'channelEvent' field.
   * @return The value of the 'channelEvent' field.
   */
  public io.raidenmap.event.channel.ChannelEvent getChannelEvent() {
    return channelEvent;
  }

  /**
   * Sets the value of the 'channelEvent' field.
   * @param value the value to set.
   */
  public void setChannelEvent(io.raidenmap.event.channel.ChannelEvent value) {
    this.channelEvent = value;
  }

  /**
   * Gets the value of the 'closingParticipant' field.
   * @return The value of the 'closingParticipant' field.
   */
  public java.lang.String getClosingParticipant() {
    return closingParticipant;
  }

  /**
   * Sets the value of the 'closingParticipant' field.
   * @param value the value to set.
   */
  public void setClosingParticipant(java.lang.String value) {
    this.closingParticipant = value;
  }

  /**
   * Gets the value of the 'nonce' field.
   * @return The value of the 'nonce' field.
   */
  public java.lang.Integer getNonce() {
    return nonce;
  }

  /**
   * Sets the value of the 'nonce' field.
   * @param value the value to set.
   */
  public void setNonce(java.lang.Integer value) {
    this.nonce = value;
  }

  /**
   * Creates a new NonClosingBalanceProofUpdated RecordBuilder.
   * @return A new NonClosingBalanceProofUpdated RecordBuilder
   */
  public static io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder newBuilder() {
    return new io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder();
  }

  /**
   * Creates a new NonClosingBalanceProofUpdated RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new NonClosingBalanceProofUpdated RecordBuilder
   */
  public static io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder newBuilder(io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder other) {
    return new io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder(other);
  }

  /**
   * Creates a new NonClosingBalanceProofUpdated RecordBuilder by copying an existing NonClosingBalanceProofUpdated instance.
   * @param other The existing instance to copy.
   * @return A new NonClosingBalanceProofUpdated RecordBuilder
   */
  public static io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder newBuilder(io.raidenmap.event.channel.NonClosingBalanceProofUpdated other) {
    return new io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder(other);
  }

  /**
   * RecordBuilder for NonClosingBalanceProofUpdated instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<NonClosingBalanceProofUpdated>
    implements org.apache.avro.data.RecordBuilder<NonClosingBalanceProofUpdated> {

    private io.raidenmap.event.channel.ChannelEvent channelEvent;
    private io.raidenmap.event.channel.ChannelEvent.Builder channelEventBuilder;
    private java.lang.String closingParticipant;
    private int nonce;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.channelEvent)) {
        this.channelEvent = data().deepCopy(fields()[0].schema(), other.channelEvent);
        fieldSetFlags()[0] = true;
      }
      if (other.hasChannelEventBuilder()) {
        this.channelEventBuilder = io.raidenmap.event.channel.ChannelEvent.newBuilder(other.getChannelEventBuilder());
      }
      if (isValidValue(fields()[1], other.closingParticipant)) {
        this.closingParticipant = data().deepCopy(fields()[1].schema(), other.closingParticipant);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.nonce)) {
        this.nonce = data().deepCopy(fields()[2].schema(), other.nonce);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing NonClosingBalanceProofUpdated instance
     * @param other The existing instance to copy.
     */
    private Builder(io.raidenmap.event.channel.NonClosingBalanceProofUpdated other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.channelEvent)) {
        this.channelEvent = data().deepCopy(fields()[0].schema(), other.channelEvent);
        fieldSetFlags()[0] = true;
      }
      this.channelEventBuilder = null;
      if (isValidValue(fields()[1], other.closingParticipant)) {
        this.closingParticipant = data().deepCopy(fields()[1].schema(), other.closingParticipant);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.nonce)) {
        this.nonce = data().deepCopy(fields()[2].schema(), other.nonce);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'channelEvent' field.
      * @return The value.
      */
    public io.raidenmap.event.channel.ChannelEvent getChannelEvent() {
      return channelEvent;
    }

    /**
      * Sets the value of the 'channelEvent' field.
      * @param value The value of 'channelEvent'.
      * @return This builder.
      */
    public io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder setChannelEvent(io.raidenmap.event.channel.ChannelEvent value) {
      validate(fields()[0], value);
      this.channelEventBuilder = null;
      this.channelEvent = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'channelEvent' field has been set.
      * @return True if the 'channelEvent' field has been set, false otherwise.
      */
    public boolean hasChannelEvent() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'channelEvent' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public io.raidenmap.event.channel.ChannelEvent.Builder getChannelEventBuilder() {
      if (channelEventBuilder == null) {
        if (hasChannelEvent()) {
          setChannelEventBuilder(io.raidenmap.event.channel.ChannelEvent.newBuilder(channelEvent));
        } else {
          setChannelEventBuilder(io.raidenmap.event.channel.ChannelEvent.newBuilder());
        }
      }
      return channelEventBuilder;
    }

    /**
     * Sets the Builder instance for the 'channelEvent' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder setChannelEventBuilder(io.raidenmap.event.channel.ChannelEvent.Builder value) {
      clearChannelEvent();
      channelEventBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'channelEvent' field has an active Builder instance
     * @return True if the 'channelEvent' field has an active Builder instance
     */
    public boolean hasChannelEventBuilder() {
      return channelEventBuilder != null;
    }

    /**
      * Clears the value of the 'channelEvent' field.
      * @return This builder.
      */
    public io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder clearChannelEvent() {
      channelEvent = null;
      channelEventBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'closingParticipant' field.
      * @return The value.
      */
    public java.lang.String getClosingParticipant() {
      return closingParticipant;
    }

    /**
      * Sets the value of the 'closingParticipant' field.
      * @param value The value of 'closingParticipant'.
      * @return This builder.
      */
    public io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder setClosingParticipant(java.lang.String value) {
      validate(fields()[1], value);
      this.closingParticipant = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'closingParticipant' field has been set.
      * @return True if the 'closingParticipant' field has been set, false otherwise.
      */
    public boolean hasClosingParticipant() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'closingParticipant' field.
      * @return This builder.
      */
    public io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder clearClosingParticipant() {
      closingParticipant = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'nonce' field.
      * @return The value.
      */
    public java.lang.Integer getNonce() {
      return nonce;
    }

    /**
      * Sets the value of the 'nonce' field.
      * @param value The value of 'nonce'.
      * @return This builder.
      */
    public io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder setNonce(int value) {
      validate(fields()[2], value);
      this.nonce = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'nonce' field has been set.
      * @return True if the 'nonce' field has been set, false otherwise.
      */
    public boolean hasNonce() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'nonce' field.
      * @return This builder.
      */
    public io.raidenmap.event.channel.NonClosingBalanceProofUpdated.Builder clearNonce() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public NonClosingBalanceProofUpdated build() {
      try {
        NonClosingBalanceProofUpdated record = new NonClosingBalanceProofUpdated();
        if (channelEventBuilder != null) {
          record.channelEvent = this.channelEventBuilder.build();
        } else {
          record.channelEvent = fieldSetFlags()[0] ? this.channelEvent : (io.raidenmap.event.channel.ChannelEvent) defaultValue(fields()[0]);
        }
        record.closingParticipant = fieldSetFlags()[1] ? this.closingParticipant : (java.lang.String) defaultValue(fields()[1]);
        record.nonce = fieldSetFlags()[2] ? this.nonce : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<NonClosingBalanceProofUpdated>
    WRITER$ = (org.apache.avro.io.DatumWriter<NonClosingBalanceProofUpdated>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<NonClosingBalanceProofUpdated>
    READER$ = (org.apache.avro.io.DatumReader<NonClosingBalanceProofUpdated>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
