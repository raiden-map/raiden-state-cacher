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
public class ChannelEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6195037573499707754L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ChannelEvent\",\"namespace\":\"io.raidenmap.event.channel\",\"fields\":[{\"name\":\"metadata\",\"type\":{\"type\":\"record\",\"name\":\"Metadata\",\"namespace\":\"io.raidenmap.event\",\"fields\":[{\"name\":\"blockNumber\",\"type\":\"long\"},{\"name\":\"blockTimestamp\",\"type\":\"long\"},{\"name\":\"eventTimestamp\",\"type\":\"long\"}]}},{\"name\":\"tokenNetworkAddress\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"id\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ChannelEvent> ENCODER =
      new BinaryMessageEncoder<ChannelEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ChannelEvent> DECODER =
      new BinaryMessageDecoder<ChannelEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<ChannelEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<ChannelEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ChannelEvent>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this ChannelEvent to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a ChannelEvent from a ByteBuffer. */
  public static ChannelEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public io.raidenmap.event.Metadata metadata;
  @Deprecated public java.lang.String tokenNetworkAddress;
  @Deprecated public int id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ChannelEvent() {}

  /**
   * All-args constructor.
   * @param metadata The new value for metadata
   * @param tokenNetworkAddress The new value for tokenNetworkAddress
   * @param id The new value for id
   */
  public ChannelEvent(io.raidenmap.event.Metadata metadata, java.lang.String tokenNetworkAddress, java.lang.Integer id) {
    this.metadata = metadata;
    this.tokenNetworkAddress = tokenNetworkAddress;
    this.id = id;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return metadata;
    case 1: return tokenNetworkAddress;
    case 2: return id;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: metadata = (io.raidenmap.event.Metadata)value$; break;
    case 1: tokenNetworkAddress = (java.lang.String)value$; break;
    case 2: id = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'metadata' field.
   * @return The value of the 'metadata' field.
   */
  public io.raidenmap.event.Metadata getMetadata() {
    return metadata;
  }

  /**
   * Sets the value of the 'metadata' field.
   * @param value the value to set.
   */
  public void setMetadata(io.raidenmap.event.Metadata value) {
    this.metadata = value;
  }

  /**
   * Gets the value of the 'tokenNetworkAddress' field.
   * @return The value of the 'tokenNetworkAddress' field.
   */
  public java.lang.String getTokenNetworkAddress() {
    return tokenNetworkAddress;
  }

  /**
   * Sets the value of the 'tokenNetworkAddress' field.
   * @param value the value to set.
   */
  public void setTokenNetworkAddress(java.lang.String value) {
    this.tokenNetworkAddress = value;
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Integer getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Integer value) {
    this.id = value;
  }

  /**
   * Creates a new ChannelEvent RecordBuilder.
   * @return A new ChannelEvent RecordBuilder
   */
  public static io.raidenmap.event.channel.ChannelEvent.Builder newBuilder() {
    return new io.raidenmap.event.channel.ChannelEvent.Builder();
  }

  /**
   * Creates a new ChannelEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ChannelEvent RecordBuilder
   */
  public static io.raidenmap.event.channel.ChannelEvent.Builder newBuilder(io.raidenmap.event.channel.ChannelEvent.Builder other) {
    return new io.raidenmap.event.channel.ChannelEvent.Builder(other);
  }

  /**
   * Creates a new ChannelEvent RecordBuilder by copying an existing ChannelEvent instance.
   * @param other The existing instance to copy.
   * @return A new ChannelEvent RecordBuilder
   */
  public static io.raidenmap.event.channel.ChannelEvent.Builder newBuilder(io.raidenmap.event.channel.ChannelEvent other) {
    return new io.raidenmap.event.channel.ChannelEvent.Builder(other);
  }

  /**
   * RecordBuilder for ChannelEvent instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ChannelEvent>
    implements org.apache.avro.data.RecordBuilder<ChannelEvent> {

    private io.raidenmap.event.Metadata metadata;
    private io.raidenmap.event.Metadata.Builder metadataBuilder;
    private java.lang.String tokenNetworkAddress;
    private int id;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.raidenmap.event.channel.ChannelEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.metadata)) {
        this.metadata = data().deepCopy(fields()[0].schema(), other.metadata);
        fieldSetFlags()[0] = true;
      }
      if (other.hasMetadataBuilder()) {
        this.metadataBuilder = io.raidenmap.event.Metadata.newBuilder(other.getMetadataBuilder());
      }
      if (isValidValue(fields()[1], other.tokenNetworkAddress)) {
        this.tokenNetworkAddress = data().deepCopy(fields()[1].schema(), other.tokenNetworkAddress);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.id)) {
        this.id = data().deepCopy(fields()[2].schema(), other.id);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ChannelEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(io.raidenmap.event.channel.ChannelEvent other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.metadata)) {
        this.metadata = data().deepCopy(fields()[0].schema(), other.metadata);
        fieldSetFlags()[0] = true;
      }
      this.metadataBuilder = null;
      if (isValidValue(fields()[1], other.tokenNetworkAddress)) {
        this.tokenNetworkAddress = data().deepCopy(fields()[1].schema(), other.tokenNetworkAddress);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.id)) {
        this.id = data().deepCopy(fields()[2].schema(), other.id);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'metadata' field.
      * @return The value.
      */
    public io.raidenmap.event.Metadata getMetadata() {
      return metadata;
    }

    /**
      * Sets the value of the 'metadata' field.
      * @param value The value of 'metadata'.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelEvent.Builder setMetadata(io.raidenmap.event.Metadata value) {
      validate(fields()[0], value);
      this.metadataBuilder = null;
      this.metadata = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'metadata' field has been set.
      * @return True if the 'metadata' field has been set, false otherwise.
      */
    public boolean hasMetadata() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'metadata' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public io.raidenmap.event.Metadata.Builder getMetadataBuilder() {
      if (metadataBuilder == null) {
        if (hasMetadata()) {
          setMetadataBuilder(io.raidenmap.event.Metadata.newBuilder(metadata));
        } else {
          setMetadataBuilder(io.raidenmap.event.Metadata.newBuilder());
        }
      }
      return metadataBuilder;
    }

    /**
     * Sets the Builder instance for the 'metadata' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public io.raidenmap.event.channel.ChannelEvent.Builder setMetadataBuilder(io.raidenmap.event.Metadata.Builder value) {
      clearMetadata();
      metadataBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'metadata' field has an active Builder instance
     * @return True if the 'metadata' field has an active Builder instance
     */
    public boolean hasMetadataBuilder() {
      return metadataBuilder != null;
    }

    /**
      * Clears the value of the 'metadata' field.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelEvent.Builder clearMetadata() {
      metadata = null;
      metadataBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'tokenNetworkAddress' field.
      * @return The value.
      */
    public java.lang.String getTokenNetworkAddress() {
      return tokenNetworkAddress;
    }

    /**
      * Sets the value of the 'tokenNetworkAddress' field.
      * @param value The value of 'tokenNetworkAddress'.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelEvent.Builder setTokenNetworkAddress(java.lang.String value) {
      validate(fields()[1], value);
      this.tokenNetworkAddress = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'tokenNetworkAddress' field has been set.
      * @return True if the 'tokenNetworkAddress' field has been set, false otherwise.
      */
    public boolean hasTokenNetworkAddress() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'tokenNetworkAddress' field.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelEvent.Builder clearTokenNetworkAddress() {
      tokenNetworkAddress = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Integer getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelEvent.Builder setId(int value) {
      validate(fields()[2], value);
      this.id = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public io.raidenmap.event.channel.ChannelEvent.Builder clearId() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ChannelEvent build() {
      try {
        ChannelEvent record = new ChannelEvent();
        if (metadataBuilder != null) {
          record.metadata = this.metadataBuilder.build();
        } else {
          record.metadata = fieldSetFlags()[0] ? this.metadata : (io.raidenmap.event.Metadata) defaultValue(fields()[0]);
        }
        record.tokenNetworkAddress = fieldSetFlags()[1] ? this.tokenNetworkAddress : (java.lang.String) defaultValue(fields()[1]);
        record.id = fieldSetFlags()[2] ? this.id : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ChannelEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<ChannelEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ChannelEvent>
    READER$ = (org.apache.avro.io.DatumReader<ChannelEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
