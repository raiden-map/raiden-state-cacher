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
public class ChannelSettled extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2077536064563312048L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ChannelSettled\",\"namespace\":\"io.raidenmap.event.channel\",\"fields\":[{\"name\":\"channelEvent\",\"type\":{\"type\":\"record\",\"name\":\"ChannelEvent\",\"fields\":[{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"Metadata\",\"namespace\":\"io.raidenmap.event\",\"fields\":[{\"name\":\"blockNumber\",\"type\":\"long\"},{\"name\":\"blockTimestamp\",\"type\":\"long\"},{\"name\":\"eventTimestamp\",\"type\":\"long\"}]}},{\"name\":\"tokenNetworkAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"id\",\"type\":\"int\"}]}},{\"name\":\"participant1Amount\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"participant2Amount\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ChannelSettled> ENCODER =
      new BinaryMessageEncoder<ChannelSettled>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ChannelSettled> DECODER =
      new BinaryMessageDecoder<ChannelSettled>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<ChannelSettled> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<ChannelSettled> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ChannelSettled>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this ChannelSettled to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a ChannelSettled from a ByteBuffer. */
  public static ChannelSettled fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public io.raidenmap.event.channel.ChannelEvent channelEvent;
  @Deprecated public java.lang.String participant1Amount;
  @Deprecated public java.lang.String participant2Amount;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ChannelSettled() {}

  /**
   * All-args constructor.
   * @param channelEvent The new value for channelEvent
   * @param participant1Amount The new value for participant1Amount
   * @param participant2Amount The new value for participant2Amount
   */
  public ChannelSettled(io.raidenmap.event.channel.ChannelEvent channelEvent, java.lang.String participant1Amount, java.lang.String participant2Amount) {
    this.channelEvent = channelEvent;
    this.participant1Amount = participant1Amount;
    this.participant2Amount = participant2Amount;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return channelEvent;
    case 1: return participant1Amount;
    case 2: return participant2Amount;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: channelEvent = (io.raidenmap.event.channel.ChannelEvent)value$; break;
    case 1: participant1Amount = (java.lang.String)value$; break;
    case 2: participant2Amount = (java.lang.String)value$; break;
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
   * Gets the value of the 'participant1Amount' field.
   * @return The value of the 'participant1Amount' field.
   */
  public java.lang.String getParticipant1Amount() {
    return participant1Amount;
  }

  /**
   * Sets the value of the 'participant1Amount' field.
   * @param value the value to set.
   */
  public void setParticipant1Amount(java.lang.String value) {
    this.participant1Amount = value;
  }

  /**
   * Gets the value of the 'participant2Amount' field.
   * @return The value of the 'participant2Amount' field.
   */
  public java.lang.String getParticipant2Amount() {
    return participant2Amount;
  }

  /**
   * Sets the value of the 'participant2Amount' field.
   * @param value the value to set.
   */
  public void setParticipant2Amount(java.lang.String value) {
    this.participant2Amount = value;
  }

  /**
   * Creates a new ChannelSettled RecordBuilder.
   * @return A new ChannelSettled RecordBuilder
   */
  public static io.raidenmap.event.channel.ChannelSettled.Builder newBuilder() {
    return new io.raidenmap.event.channel.ChannelSettled.Builder();
  }

  /**
   * Creates a new ChannelSettled RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ChannelSettled RecordBuilder
   */
  public static io.raidenmap.event.channel.ChannelSettled.Builder newBuilder(io.raidenmap.event.channel.ChannelSettled.Builder other) {
    return new io.raidenmap.event.channel.ChannelSettled.Builder(other);
  }

  /**
   * Creates a new ChannelSettled RecordBuilder by copying an existing ChannelSettled instance.
   * @param other The existing instance to copy.
   * @return A new ChannelSettled RecordBuilder
   */
  public static io.raidenmap.event.channel.ChannelSettled.Builder newBuilder(io.raidenmap.event.channel.ChannelSettled other) {
    return new io.raidenmap.event.channel.ChannelSettled.Builder(other);
  }

  /**
   * RecordBuilder for ChannelSettled instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ChannelSettled>
    implements org.apache.avro.data.RecordBuilder<ChannelSettled> {

    private io.raidenmap.event.channel.ChannelEvent channelEvent;
    private io.raidenmap.event.channel.ChannelEvent.Builder channelEventBuilder;
    private java.lang.String participant1Amount;
    private java.lang.String participant2Amount;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.raidenmap.event.channel.ChannelSettled.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.channelEvent)) {
        this.channelEvent = data().deepCopy(fields()[0].schema(), other.channelEvent);
        fieldSetFlags()[0] = true;
      }
      if (other.hasChannelEventBuilder()) {
        this.channelEventBuilder = io.raidenmap.event.channel.ChannelEvent.newBuilder(other.getChannelEventBuilder());
      }
      if (isValidValue(fields()[1], other.participant1Amount)) {
        this.participant1Amount = data().deepCopy(fields()[1].schema(), other.participant1Amount);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.participant2Amount)) {
        this.participant2Amount = data().deepCopy(fields()[2].schema(), other.participant2Amount);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ChannelSettled instance
     * @param other The existing instance to copy.
     */
    private Builder(io.raidenmap.event.channel.ChannelSettled other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.channelEvent)) {
        this.channelEvent = data().deepCopy(fields()[0].schema(), other.channelEvent);
        fieldSetFlags()[0] = true;
      }
      this.channelEventBuilder = null;
      if (isValidValue(fields()[1], other.participant1Amount)) {
        this.participant1Amount = data().deepCopy(fields()[1].schema(), other.participant1Amount);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.participant2Amount)) {
        this.participant2Amount = data().deepCopy(fields()[2].schema(), other.participant2Amount);
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
    public io.raidenmap.event.channel.ChannelSettled.Builder setChannelEvent(io.raidenmap.event.channel.ChannelEvent value) {
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
    public io.raidenmap.event.channel.ChannelSettled.Builder setChannelEventBuilder(io.raidenmap.event.channel.ChannelEvent.Builder value) {
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
    public io.raidenmap.event.channel.ChannelSettled.Builder clearChannelEvent() {
      channelEvent = null;
      channelEventBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'participant1Amount' field.
      * @return The value.
      */
    public java.lang.String getParticipant1Amount() {
      return participant1Amount;
    }

    /**
      * Sets the value of the 'participant1Amount' field.
      * @param value The value of 'participant1Amount'.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelSettled.Builder setParticipant1Amount(java.lang.String value) {
      validate(fields()[1], value);
      this.participant1Amount = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'participant1Amount' field has been set.
      * @return True if the 'participant1Amount' field has been set, false otherwise.
      */
    public boolean hasParticipant1Amount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'participant1Amount' field.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelSettled.Builder clearParticipant1Amount() {
      participant1Amount = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'participant2Amount' field.
      * @return The value.
      */
    public java.lang.String getParticipant2Amount() {
      return participant2Amount;
    }

    /**
      * Sets the value of the 'participant2Amount' field.
      * @param value The value of 'participant2Amount'.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelSettled.Builder setParticipant2Amount(java.lang.String value) {
      validate(fields()[2], value);
      this.participant2Amount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'participant2Amount' field has been set.
      * @return True if the 'participant2Amount' field has been set, false otherwise.
      */
    public boolean hasParticipant2Amount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'participant2Amount' field.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelSettled.Builder clearParticipant2Amount() {
      participant2Amount = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ChannelSettled build() {
      try {
        ChannelSettled record = new ChannelSettled();
        if (channelEventBuilder != null) {
          record.channelEvent = this.channelEventBuilder.build();
        } else {
          record.channelEvent = fieldSetFlags()[0] ? this.channelEvent : (io.raidenmap.event.channel.ChannelEvent) defaultValue(fields()[0]);
        }
        record.participant1Amount = fieldSetFlags()[1] ? this.participant1Amount : (java.lang.String) defaultValue(fields()[1]);
        record.participant2Amount = fieldSetFlags()[2] ? this.participant2Amount : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ChannelSettled>
    WRITER$ = (org.apache.avro.io.DatumWriter<ChannelSettled>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ChannelSettled>
    READER$ = (org.apache.avro.io.DatumReader<ChannelSettled>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
