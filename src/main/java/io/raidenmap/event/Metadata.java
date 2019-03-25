/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.raidenmap.event;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Metadata extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 9131928633943220456L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Metadata\",\"namespace\":\"io.raidenmap.event\",\"fields\":[{\"name\":\"blockNumber\",\"type\":\"long\"},{\"name\":\"blockTimestamp\",\"type\":\"long\"},{\"name\":\"eventTimestamp\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Metadata> ENCODER =
      new BinaryMessageEncoder<Metadata>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Metadata> DECODER =
      new BinaryMessageDecoder<Metadata>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Metadata> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Metadata> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Metadata>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Metadata to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Metadata from a ByteBuffer. */
  public static Metadata fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long blockNumber;
  @Deprecated public long blockTimestamp;
  @Deprecated public long eventTimestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Metadata() {}

  /**
   * All-args constructor.
   * @param blockNumber The new value for blockNumber
   * @param blockTimestamp The new value for blockTimestamp
   * @param eventTimestamp The new value for eventTimestamp
   */
  public Metadata(java.lang.Long blockNumber, java.lang.Long blockTimestamp, java.lang.Long eventTimestamp) {
    this.blockNumber = blockNumber;
    this.blockTimestamp = blockTimestamp;
    this.eventTimestamp = eventTimestamp;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return blockNumber;
    case 1: return blockTimestamp;
    case 2: return eventTimestamp;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: blockNumber = (java.lang.Long)value$; break;
    case 1: blockTimestamp = (java.lang.Long)value$; break;
    case 2: eventTimestamp = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
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
   * Gets the value of the 'blockTimestamp' field.
   * @return The value of the 'blockTimestamp' field.
   */
  public java.lang.Long getBlockTimestamp() {
    return blockTimestamp;
  }

  /**
   * Sets the value of the 'blockTimestamp' field.
   * @param value the value to set.
   */
  public void setBlockTimestamp(java.lang.Long value) {
    this.blockTimestamp = value;
  }

  /**
   * Gets the value of the 'eventTimestamp' field.
   * @return The value of the 'eventTimestamp' field.
   */
  public java.lang.Long getEventTimestamp() {
    return eventTimestamp;
  }

  /**
   * Sets the value of the 'eventTimestamp' field.
   * @param value the value to set.
   */
  public void setEventTimestamp(java.lang.Long value) {
    this.eventTimestamp = value;
  }

  /**
   * Creates a new Metadata RecordBuilder.
   * @return A new Metadata RecordBuilder
   */
  public static io.raidenmap.event.Metadata.Builder newBuilder() {
    return new io.raidenmap.event.Metadata.Builder();
  }

  /**
   * Creates a new Metadata RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Metadata RecordBuilder
   */
  public static io.raidenmap.event.Metadata.Builder newBuilder(io.raidenmap.event.Metadata.Builder other) {
    return new io.raidenmap.event.Metadata.Builder(other);
  }

  /**
   * Creates a new Metadata RecordBuilder by copying an existing Metadata instance.
   * @param other The existing instance to copy.
   * @return A new Metadata RecordBuilder
   */
  public static io.raidenmap.event.Metadata.Builder newBuilder(io.raidenmap.event.Metadata other) {
    return new io.raidenmap.event.Metadata.Builder(other);
  }

  /**
   * RecordBuilder for Metadata instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Metadata>
    implements org.apache.avro.data.RecordBuilder<Metadata> {

    private long blockNumber;
    private long blockTimestamp;
    private long eventTimestamp;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.raidenmap.event.Metadata.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.blockNumber)) {
        this.blockNumber = data().deepCopy(fields()[0].schema(), other.blockNumber);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.blockTimestamp)) {
        this.blockTimestamp = data().deepCopy(fields()[1].schema(), other.blockTimestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.eventTimestamp)) {
        this.eventTimestamp = data().deepCopy(fields()[2].schema(), other.eventTimestamp);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Metadata instance
     * @param other The existing instance to copy.
     */
    private Builder(io.raidenmap.event.Metadata other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.blockNumber)) {
        this.blockNumber = data().deepCopy(fields()[0].schema(), other.blockNumber);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.blockTimestamp)) {
        this.blockTimestamp = data().deepCopy(fields()[1].schema(), other.blockTimestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.eventTimestamp)) {
        this.eventTimestamp = data().deepCopy(fields()[2].schema(), other.eventTimestamp);
        fieldSetFlags()[2] = true;
      }
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
    public io.raidenmap.event.Metadata.Builder setBlockNumber(long value) {
      validate(fields()[0], value);
      this.blockNumber = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'blockNumber' field has been set.
      * @return True if the 'blockNumber' field has been set, false otherwise.
      */
    public boolean hasBlockNumber() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'blockNumber' field.
      * @return This builder.
      */
    public io.raidenmap.event.Metadata.Builder clearBlockNumber() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'blockTimestamp' field.
      * @return The value.
      */
    public java.lang.Long getBlockTimestamp() {
      return blockTimestamp;
    }

    /**
      * Sets the value of the 'blockTimestamp' field.
      * @param value The value of 'blockTimestamp'.
      * @return This builder.
      */
    public io.raidenmap.event.Metadata.Builder setBlockTimestamp(long value) {
      validate(fields()[1], value);
      this.blockTimestamp = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'blockTimestamp' field has been set.
      * @return True if the 'blockTimestamp' field has been set, false otherwise.
      */
    public boolean hasBlockTimestamp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'blockTimestamp' field.
      * @return This builder.
      */
    public io.raidenmap.event.Metadata.Builder clearBlockTimestamp() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'eventTimestamp' field.
      * @return The value.
      */
    public java.lang.Long getEventTimestamp() {
      return eventTimestamp;
    }

    /**
      * Sets the value of the 'eventTimestamp' field.
      * @param value The value of 'eventTimestamp'.
      * @return This builder.
      */
    public io.raidenmap.event.Metadata.Builder setEventTimestamp(long value) {
      validate(fields()[2], value);
      this.eventTimestamp = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'eventTimestamp' field has been set.
      * @return True if the 'eventTimestamp' field has been set, false otherwise.
      */
    public boolean hasEventTimestamp() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'eventTimestamp' field.
      * @return This builder.
      */
    public io.raidenmap.event.Metadata.Builder clearEventTimestamp() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Metadata build() {
      try {
        Metadata record = new Metadata();
        record.blockNumber = fieldSetFlags()[0] ? this.blockNumber : (java.lang.Long) defaultValue(fields()[0]);
        record.blockTimestamp = fieldSetFlags()[1] ? this.blockTimestamp : (java.lang.Long) defaultValue(fields()[1]);
        record.eventTimestamp = fieldSetFlags()[2] ? this.eventTimestamp : (java.lang.Long) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Metadata>
    WRITER$ = (org.apache.avro.io.DatumWriter<Metadata>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Metadata>
    READER$ = (org.apache.avro.io.DatumReader<Metadata>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
