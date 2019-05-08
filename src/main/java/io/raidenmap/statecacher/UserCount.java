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
public class UserCount extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5320233619947546683L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserCount\",\"namespace\":\"io.raidenmap.statecacher\",\"fields\":[{\"name\":\"user\",\"type\":{\"type\":\"map\",\"values\":\"int\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<UserCount> ENCODER =
      new BinaryMessageEncoder<UserCount>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<UserCount> DECODER =
      new BinaryMessageDecoder<UserCount>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<UserCount> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<UserCount> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<UserCount>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this UserCount to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a UserCount from a ByteBuffer. */
  public static UserCount fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.util.Map<java.lang.String,java.lang.Integer> user;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserCount() {}

  /**
   * All-args constructor.
   * @param user The new value for user
   */
  public UserCount(java.util.Map<java.lang.String,java.lang.Integer> user) {
    this.user = user;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return user;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: user = (java.util.Map<java.lang.String,java.lang.Integer>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'user' field.
   * @return The value of the 'user' field.
   */
  public java.util.Map<java.lang.String,java.lang.Integer> getUser() {
    return user;
  }

  /**
   * Sets the value of the 'user' field.
   * @param value the value to set.
   */
  public void setUser(java.util.Map<java.lang.String,java.lang.Integer> value) {
    this.user = value;
  }

  /**
   * Creates a new UserCount RecordBuilder.
   * @return A new UserCount RecordBuilder
   */
  public static io.raidenmap.statecacher.UserCount.Builder newBuilder() {
    return new io.raidenmap.statecacher.UserCount.Builder();
  }

  /**
   * Creates a new UserCount RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserCount RecordBuilder
   */
  public static io.raidenmap.statecacher.UserCount.Builder newBuilder(io.raidenmap.statecacher.UserCount.Builder other) {
    return new io.raidenmap.statecacher.UserCount.Builder(other);
  }

  /**
   * Creates a new UserCount RecordBuilder by copying an existing UserCount instance.
   * @param other The existing instance to copy.
   * @return A new UserCount RecordBuilder
   */
  public static io.raidenmap.statecacher.UserCount.Builder newBuilder(io.raidenmap.statecacher.UserCount other) {
    return new io.raidenmap.statecacher.UserCount.Builder(other);
  }

  /**
   * RecordBuilder for UserCount instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserCount>
    implements org.apache.avro.data.RecordBuilder<UserCount> {

    private java.util.Map<java.lang.String,java.lang.Integer> user;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.raidenmap.statecacher.UserCount.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.user)) {
        this.user = data().deepCopy(fields()[0].schema(), other.user);
        fieldSetFlags()[0] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing UserCount instance
     * @param other The existing instance to copy.
     */
    private Builder(io.raidenmap.statecacher.UserCount other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.user)) {
        this.user = data().deepCopy(fields()[0].schema(), other.user);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'user' field.
      * @return The value.
      */
    public java.util.Map<java.lang.String,java.lang.Integer> getUser() {
      return user;
    }

    /**
      * Sets the value of the 'user' field.
      * @param value The value of 'user'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.UserCount.Builder setUser(java.util.Map<java.lang.String,java.lang.Integer> value) {
      validate(fields()[0], value);
      this.user = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'user' field has been set.
      * @return True if the 'user' field has been set, false otherwise.
      */
    public boolean hasUser() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'user' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.UserCount.Builder clearUser() {
      user = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserCount build() {
      try {
        UserCount record = new UserCount();
        record.user = fieldSetFlags()[0] ? this.user : (java.util.Map<java.lang.String,java.lang.Integer>) defaultValue(fields()[0]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<UserCount>
    WRITER$ = (org.apache.avro.io.DatumWriter<UserCount>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<UserCount>
    READER$ = (org.apache.avro.io.DatumReader<UserCount>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}