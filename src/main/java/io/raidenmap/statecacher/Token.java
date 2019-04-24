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
public class Token extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3692665845639816431L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Token\",\"namespace\":\"io.raidenmap.statecacher\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"tag\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"imageUrl\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"valueUsd\",\"type\":\"double\"},{\"name\":\"valueEth\",\"type\":\"double\"},{\"name\":\"valueBtc\",\"type\":\"double\"},{\"name\":\"priceChangeDayUsd\",\"type\":\"float\"},{\"name\":\"priceChangeWeekUsd\",\"type\":\"float\"},{\"name\":\"priceChangeDayEth\",\"type\":\"float\"},{\"name\":\"priceChangeWeekEth\",\"type\":\"float\"},{\"name\":\"priceChangeDayBtc\",\"type\":\"float\"},{\"name\":\"priceChangeWeekBtc\",\"type\":\"float\"},{\"name\":\"marketCap\",\"type\":\"double\"},{\"name\":\"volume\",\"type\":\"double\"},{\"name\":\"timestamp\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Token> ENCODER =
      new BinaryMessageEncoder<Token>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Token> DECODER =
      new BinaryMessageDecoder<Token>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Token> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Token> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Token>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Token to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Token from a ByteBuffer. */
  public static Token fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String name;
  @Deprecated public java.lang.String tag;
  @Deprecated public java.lang.String imageUrl;
  @Deprecated public double valueUsd;
  @Deprecated public double valueEth;
  @Deprecated public double valueBtc;
  @Deprecated public float priceChangeDayUsd;
  @Deprecated public float priceChangeWeekUsd;
  @Deprecated public float priceChangeDayEth;
  @Deprecated public float priceChangeWeekEth;
  @Deprecated public float priceChangeDayBtc;
  @Deprecated public float priceChangeWeekBtc;
  @Deprecated public double marketCap;
  @Deprecated public double volume;
  @Deprecated public long timestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Token() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param tag The new value for tag
   * @param imageUrl The new value for imageUrl
   * @param valueUsd The new value for valueUsd
   * @param valueEth The new value for valueEth
   * @param valueBtc The new value for valueBtc
   * @param priceChangeDayUsd The new value for priceChangeDayUsd
   * @param priceChangeWeekUsd The new value for priceChangeWeekUsd
   * @param priceChangeDayEth The new value for priceChangeDayEth
   * @param priceChangeWeekEth The new value for priceChangeWeekEth
   * @param priceChangeDayBtc The new value for priceChangeDayBtc
   * @param priceChangeWeekBtc The new value for priceChangeWeekBtc
   * @param marketCap The new value for marketCap
   * @param volume The new value for volume
   * @param timestamp The new value for timestamp
   */
  public Token(java.lang.String name, java.lang.String tag, java.lang.String imageUrl, java.lang.Double valueUsd, java.lang.Double valueEth, java.lang.Double valueBtc, java.lang.Float priceChangeDayUsd, java.lang.Float priceChangeWeekUsd, java.lang.Float priceChangeDayEth, java.lang.Float priceChangeWeekEth, java.lang.Float priceChangeDayBtc, java.lang.Float priceChangeWeekBtc, java.lang.Double marketCap, java.lang.Double volume, java.lang.Long timestamp) {
    this.name = name;
    this.tag = tag;
    this.imageUrl = imageUrl;
    this.valueUsd = valueUsd;
    this.valueEth = valueEth;
    this.valueBtc = valueBtc;
    this.priceChangeDayUsd = priceChangeDayUsd;
    this.priceChangeWeekUsd = priceChangeWeekUsd;
    this.priceChangeDayEth = priceChangeDayEth;
    this.priceChangeWeekEth = priceChangeWeekEth;
    this.priceChangeDayBtc = priceChangeDayBtc;
    this.priceChangeWeekBtc = priceChangeWeekBtc;
    this.marketCap = marketCap;
    this.volume = volume;
    this.timestamp = timestamp;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return tag;
    case 2: return imageUrl;
    case 3: return valueUsd;
    case 4: return valueEth;
    case 5: return valueBtc;
    case 6: return priceChangeDayUsd;
    case 7: return priceChangeWeekUsd;
    case 8: return priceChangeDayEth;
    case 9: return priceChangeWeekEth;
    case 10: return priceChangeDayBtc;
    case 11: return priceChangeWeekBtc;
    case 12: return marketCap;
    case 13: return volume;
    case 14: return timestamp;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.String)value$; break;
    case 1: tag = (java.lang.String)value$; break;
    case 2: imageUrl = (java.lang.String)value$; break;
    case 3: valueUsd = (java.lang.Double)value$; break;
    case 4: valueEth = (java.lang.Double)value$; break;
    case 5: valueBtc = (java.lang.Double)value$; break;
    case 6: priceChangeDayUsd = (java.lang.Float)value$; break;
    case 7: priceChangeWeekUsd = (java.lang.Float)value$; break;
    case 8: priceChangeDayEth = (java.lang.Float)value$; break;
    case 9: priceChangeWeekEth = (java.lang.Float)value$; break;
    case 10: priceChangeDayBtc = (java.lang.Float)value$; break;
    case 11: priceChangeWeekBtc = (java.lang.Float)value$; break;
    case 12: marketCap = (java.lang.Double)value$; break;
    case 13: volume = (java.lang.Double)value$; break;
    case 14: timestamp = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'tag' field.
   * @return The value of the 'tag' field.
   */
  public java.lang.String getTag() {
    return tag;
  }

  /**
   * Sets the value of the 'tag' field.
   * @param value the value to set.
   */
  public void setTag(java.lang.String value) {
    this.tag = value;
  }

  /**
   * Gets the value of the 'imageUrl' field.
   * @return The value of the 'imageUrl' field.
   */
  public java.lang.String getImageUrl() {
    return imageUrl;
  }

  /**
   * Sets the value of the 'imageUrl' field.
   * @param value the value to set.
   */
  public void setImageUrl(java.lang.String value) {
    this.imageUrl = value;
  }

  /**
   * Gets the value of the 'valueUsd' field.
   * @return The value of the 'valueUsd' field.
   */
  public java.lang.Double getValueUsd() {
    return valueUsd;
  }

  /**
   * Sets the value of the 'valueUsd' field.
   * @param value the value to set.
   */
  public void setValueUsd(java.lang.Double value) {
    this.valueUsd = value;
  }

  /**
   * Gets the value of the 'valueEth' field.
   * @return The value of the 'valueEth' field.
   */
  public java.lang.Double getValueEth() {
    return valueEth;
  }

  /**
   * Sets the value of the 'valueEth' field.
   * @param value the value to set.
   */
  public void setValueEth(java.lang.Double value) {
    this.valueEth = value;
  }

  /**
   * Gets the value of the 'valueBtc' field.
   * @return The value of the 'valueBtc' field.
   */
  public java.lang.Double getValueBtc() {
    return valueBtc;
  }

  /**
   * Sets the value of the 'valueBtc' field.
   * @param value the value to set.
   */
  public void setValueBtc(java.lang.Double value) {
    this.valueBtc = value;
  }

  /**
   * Gets the value of the 'priceChangeDayUsd' field.
   * @return The value of the 'priceChangeDayUsd' field.
   */
  public java.lang.Float getPriceChangeDayUsd() {
    return priceChangeDayUsd;
  }

  /**
   * Sets the value of the 'priceChangeDayUsd' field.
   * @param value the value to set.
   */
  public void setPriceChangeDayUsd(java.lang.Float value) {
    this.priceChangeDayUsd = value;
  }

  /**
   * Gets the value of the 'priceChangeWeekUsd' field.
   * @return The value of the 'priceChangeWeekUsd' field.
   */
  public java.lang.Float getPriceChangeWeekUsd() {
    return priceChangeWeekUsd;
  }

  /**
   * Sets the value of the 'priceChangeWeekUsd' field.
   * @param value the value to set.
   */
  public void setPriceChangeWeekUsd(java.lang.Float value) {
    this.priceChangeWeekUsd = value;
  }

  /**
   * Gets the value of the 'priceChangeDayEth' field.
   * @return The value of the 'priceChangeDayEth' field.
   */
  public java.lang.Float getPriceChangeDayEth() {
    return priceChangeDayEth;
  }

  /**
   * Sets the value of the 'priceChangeDayEth' field.
   * @param value the value to set.
   */
  public void setPriceChangeDayEth(java.lang.Float value) {
    this.priceChangeDayEth = value;
  }

  /**
   * Gets the value of the 'priceChangeWeekEth' field.
   * @return The value of the 'priceChangeWeekEth' field.
   */
  public java.lang.Float getPriceChangeWeekEth() {
    return priceChangeWeekEth;
  }

  /**
   * Sets the value of the 'priceChangeWeekEth' field.
   * @param value the value to set.
   */
  public void setPriceChangeWeekEth(java.lang.Float value) {
    this.priceChangeWeekEth = value;
  }

  /**
   * Gets the value of the 'priceChangeDayBtc' field.
   * @return The value of the 'priceChangeDayBtc' field.
   */
  public java.lang.Float getPriceChangeDayBtc() {
    return priceChangeDayBtc;
  }

  /**
   * Sets the value of the 'priceChangeDayBtc' field.
   * @param value the value to set.
   */
  public void setPriceChangeDayBtc(java.lang.Float value) {
    this.priceChangeDayBtc = value;
  }

  /**
   * Gets the value of the 'priceChangeWeekBtc' field.
   * @return The value of the 'priceChangeWeekBtc' field.
   */
  public java.lang.Float getPriceChangeWeekBtc() {
    return priceChangeWeekBtc;
  }

  /**
   * Sets the value of the 'priceChangeWeekBtc' field.
   * @param value the value to set.
   */
  public void setPriceChangeWeekBtc(java.lang.Float value) {
    this.priceChangeWeekBtc = value;
  }

  /**
   * Gets the value of the 'marketCap' field.
   * @return The value of the 'marketCap' field.
   */
  public java.lang.Double getMarketCap() {
    return marketCap;
  }

  /**
   * Sets the value of the 'marketCap' field.
   * @param value the value to set.
   */
  public void setMarketCap(java.lang.Double value) {
    this.marketCap = value;
  }

  /**
   * Gets the value of the 'volume' field.
   * @return The value of the 'volume' field.
   */
  public java.lang.Double getVolume() {
    return volume;
  }

  /**
   * Sets the value of the 'volume' field.
   * @param value the value to set.
   */
  public void setVolume(java.lang.Double value) {
    this.volume = value;
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
   * Creates a new Token RecordBuilder.
   * @return A new Token RecordBuilder
   */
  public static io.raidenmap.statecacher.Token.Builder newBuilder() {
    return new io.raidenmap.statecacher.Token.Builder();
  }

  /**
   * Creates a new Token RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Token RecordBuilder
   */
  public static io.raidenmap.statecacher.Token.Builder newBuilder(io.raidenmap.statecacher.Token.Builder other) {
    return new io.raidenmap.statecacher.Token.Builder(other);
  }

  /**
   * Creates a new Token RecordBuilder by copying an existing Token instance.
   * @param other The existing instance to copy.
   * @return A new Token RecordBuilder
   */
  public static io.raidenmap.statecacher.Token.Builder newBuilder(io.raidenmap.statecacher.Token other) {
    return new io.raidenmap.statecacher.Token.Builder(other);
  }

  /**
   * RecordBuilder for Token instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Token>
    implements org.apache.avro.data.RecordBuilder<Token> {

    private java.lang.String name;
    private java.lang.String tag;
    private java.lang.String imageUrl;
    private double valueUsd;
    private double valueEth;
    private double valueBtc;
    private float priceChangeDayUsd;
    private float priceChangeWeekUsd;
    private float priceChangeDayEth;
    private float priceChangeWeekEth;
    private float priceChangeDayBtc;
    private float priceChangeWeekBtc;
    private double marketCap;
    private double volume;
    private long timestamp;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.raidenmap.statecacher.Token.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tag)) {
        this.tag = data().deepCopy(fields()[1].schema(), other.tag);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.imageUrl)) {
        this.imageUrl = data().deepCopy(fields()[2].schema(), other.imageUrl);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.valueUsd)) {
        this.valueUsd = data().deepCopy(fields()[3].schema(), other.valueUsd);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.valueEth)) {
        this.valueEth = data().deepCopy(fields()[4].schema(), other.valueEth);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.valueBtc)) {
        this.valueBtc = data().deepCopy(fields()[5].schema(), other.valueBtc);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.priceChangeDayUsd)) {
        this.priceChangeDayUsd = data().deepCopy(fields()[6].schema(), other.priceChangeDayUsd);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.priceChangeWeekUsd)) {
        this.priceChangeWeekUsd = data().deepCopy(fields()[7].schema(), other.priceChangeWeekUsd);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.priceChangeDayEth)) {
        this.priceChangeDayEth = data().deepCopy(fields()[8].schema(), other.priceChangeDayEth);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.priceChangeWeekEth)) {
        this.priceChangeWeekEth = data().deepCopy(fields()[9].schema(), other.priceChangeWeekEth);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.priceChangeDayBtc)) {
        this.priceChangeDayBtc = data().deepCopy(fields()[10].schema(), other.priceChangeDayBtc);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.priceChangeWeekBtc)) {
        this.priceChangeWeekBtc = data().deepCopy(fields()[11].schema(), other.priceChangeWeekBtc);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.marketCap)) {
        this.marketCap = data().deepCopy(fields()[12].schema(), other.marketCap);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.volume)) {
        this.volume = data().deepCopy(fields()[13].schema(), other.volume);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[14].schema(), other.timestamp);
        fieldSetFlags()[14] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Token instance
     * @param other The existing instance to copy.
     */
    private Builder(io.raidenmap.statecacher.Token other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tag)) {
        this.tag = data().deepCopy(fields()[1].schema(), other.tag);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.imageUrl)) {
        this.imageUrl = data().deepCopy(fields()[2].schema(), other.imageUrl);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.valueUsd)) {
        this.valueUsd = data().deepCopy(fields()[3].schema(), other.valueUsd);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.valueEth)) {
        this.valueEth = data().deepCopy(fields()[4].schema(), other.valueEth);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.valueBtc)) {
        this.valueBtc = data().deepCopy(fields()[5].schema(), other.valueBtc);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.priceChangeDayUsd)) {
        this.priceChangeDayUsd = data().deepCopy(fields()[6].schema(), other.priceChangeDayUsd);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.priceChangeWeekUsd)) {
        this.priceChangeWeekUsd = data().deepCopy(fields()[7].schema(), other.priceChangeWeekUsd);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.priceChangeDayEth)) {
        this.priceChangeDayEth = data().deepCopy(fields()[8].schema(), other.priceChangeDayEth);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.priceChangeWeekEth)) {
        this.priceChangeWeekEth = data().deepCopy(fields()[9].schema(), other.priceChangeWeekEth);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.priceChangeDayBtc)) {
        this.priceChangeDayBtc = data().deepCopy(fields()[10].schema(), other.priceChangeDayBtc);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.priceChangeWeekBtc)) {
        this.priceChangeWeekBtc = data().deepCopy(fields()[11].schema(), other.priceChangeWeekBtc);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.marketCap)) {
        this.marketCap = data().deepCopy(fields()[12].schema(), other.marketCap);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.volume)) {
        this.volume = data().deepCopy(fields()[13].schema(), other.volume);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[14].schema(), other.timestamp);
        fieldSetFlags()[14] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setName(java.lang.String value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'tag' field.
      * @return The value.
      */
    public java.lang.String getTag() {
      return tag;
    }

    /**
      * Sets the value of the 'tag' field.
      * @param value The value of 'tag'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setTag(java.lang.String value) {
      validate(fields()[1], value);
      this.tag = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'tag' field has been set.
      * @return True if the 'tag' field has been set, false otherwise.
      */
    public boolean hasTag() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'tag' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearTag() {
      tag = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'imageUrl' field.
      * @return The value.
      */
    public java.lang.String getImageUrl() {
      return imageUrl;
    }

    /**
      * Sets the value of the 'imageUrl' field.
      * @param value The value of 'imageUrl'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setImageUrl(java.lang.String value) {
      validate(fields()[2], value);
      this.imageUrl = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'imageUrl' field has been set.
      * @return True if the 'imageUrl' field has been set, false otherwise.
      */
    public boolean hasImageUrl() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'imageUrl' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearImageUrl() {
      imageUrl = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'valueUsd' field.
      * @return The value.
      */
    public java.lang.Double getValueUsd() {
      return valueUsd;
    }

    /**
      * Sets the value of the 'valueUsd' field.
      * @param value The value of 'valueUsd'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setValueUsd(double value) {
      validate(fields()[3], value);
      this.valueUsd = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'valueUsd' field has been set.
      * @return True if the 'valueUsd' field has been set, false otherwise.
      */
    public boolean hasValueUsd() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'valueUsd' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearValueUsd() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'valueEth' field.
      * @return The value.
      */
    public java.lang.Double getValueEth() {
      return valueEth;
    }

    /**
      * Sets the value of the 'valueEth' field.
      * @param value The value of 'valueEth'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setValueEth(double value) {
      validate(fields()[4], value);
      this.valueEth = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'valueEth' field has been set.
      * @return True if the 'valueEth' field has been set, false otherwise.
      */
    public boolean hasValueEth() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'valueEth' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearValueEth() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'valueBtc' field.
      * @return The value.
      */
    public java.lang.Double getValueBtc() {
      return valueBtc;
    }

    /**
      * Sets the value of the 'valueBtc' field.
      * @param value The value of 'valueBtc'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setValueBtc(double value) {
      validate(fields()[5], value);
      this.valueBtc = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'valueBtc' field has been set.
      * @return True if the 'valueBtc' field has been set, false otherwise.
      */
    public boolean hasValueBtc() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'valueBtc' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearValueBtc() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'priceChangeDayUsd' field.
      * @return The value.
      */
    public java.lang.Float getPriceChangeDayUsd() {
      return priceChangeDayUsd;
    }

    /**
      * Sets the value of the 'priceChangeDayUsd' field.
      * @param value The value of 'priceChangeDayUsd'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setPriceChangeDayUsd(float value) {
      validate(fields()[6], value);
      this.priceChangeDayUsd = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'priceChangeDayUsd' field has been set.
      * @return True if the 'priceChangeDayUsd' field has been set, false otherwise.
      */
    public boolean hasPriceChangeDayUsd() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'priceChangeDayUsd' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearPriceChangeDayUsd() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'priceChangeWeekUsd' field.
      * @return The value.
      */
    public java.lang.Float getPriceChangeWeekUsd() {
      return priceChangeWeekUsd;
    }

    /**
      * Sets the value of the 'priceChangeWeekUsd' field.
      * @param value The value of 'priceChangeWeekUsd'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setPriceChangeWeekUsd(float value) {
      validate(fields()[7], value);
      this.priceChangeWeekUsd = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'priceChangeWeekUsd' field has been set.
      * @return True if the 'priceChangeWeekUsd' field has been set, false otherwise.
      */
    public boolean hasPriceChangeWeekUsd() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'priceChangeWeekUsd' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearPriceChangeWeekUsd() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'priceChangeDayEth' field.
      * @return The value.
      */
    public java.lang.Float getPriceChangeDayEth() {
      return priceChangeDayEth;
    }

    /**
      * Sets the value of the 'priceChangeDayEth' field.
      * @param value The value of 'priceChangeDayEth'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setPriceChangeDayEth(float value) {
      validate(fields()[8], value);
      this.priceChangeDayEth = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'priceChangeDayEth' field has been set.
      * @return True if the 'priceChangeDayEth' field has been set, false otherwise.
      */
    public boolean hasPriceChangeDayEth() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'priceChangeDayEth' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearPriceChangeDayEth() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'priceChangeWeekEth' field.
      * @return The value.
      */
    public java.lang.Float getPriceChangeWeekEth() {
      return priceChangeWeekEth;
    }

    /**
      * Sets the value of the 'priceChangeWeekEth' field.
      * @param value The value of 'priceChangeWeekEth'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setPriceChangeWeekEth(float value) {
      validate(fields()[9], value);
      this.priceChangeWeekEth = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'priceChangeWeekEth' field has been set.
      * @return True if the 'priceChangeWeekEth' field has been set, false otherwise.
      */
    public boolean hasPriceChangeWeekEth() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'priceChangeWeekEth' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearPriceChangeWeekEth() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'priceChangeDayBtc' field.
      * @return The value.
      */
    public java.lang.Float getPriceChangeDayBtc() {
      return priceChangeDayBtc;
    }

    /**
      * Sets the value of the 'priceChangeDayBtc' field.
      * @param value The value of 'priceChangeDayBtc'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setPriceChangeDayBtc(float value) {
      validate(fields()[10], value);
      this.priceChangeDayBtc = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'priceChangeDayBtc' field has been set.
      * @return True if the 'priceChangeDayBtc' field has been set, false otherwise.
      */
    public boolean hasPriceChangeDayBtc() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'priceChangeDayBtc' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearPriceChangeDayBtc() {
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'priceChangeWeekBtc' field.
      * @return The value.
      */
    public java.lang.Float getPriceChangeWeekBtc() {
      return priceChangeWeekBtc;
    }

    /**
      * Sets the value of the 'priceChangeWeekBtc' field.
      * @param value The value of 'priceChangeWeekBtc'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setPriceChangeWeekBtc(float value) {
      validate(fields()[11], value);
      this.priceChangeWeekBtc = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'priceChangeWeekBtc' field has been set.
      * @return True if the 'priceChangeWeekBtc' field has been set, false otherwise.
      */
    public boolean hasPriceChangeWeekBtc() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'priceChangeWeekBtc' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearPriceChangeWeekBtc() {
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'marketCap' field.
      * @return The value.
      */
    public java.lang.Double getMarketCap() {
      return marketCap;
    }

    /**
      * Sets the value of the 'marketCap' field.
      * @param value The value of 'marketCap'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setMarketCap(double value) {
      validate(fields()[12], value);
      this.marketCap = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'marketCap' field has been set.
      * @return True if the 'marketCap' field has been set, false otherwise.
      */
    public boolean hasMarketCap() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'marketCap' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearMarketCap() {
      fieldSetFlags()[12] = false;
      return this;
    }

    /**
      * Gets the value of the 'volume' field.
      * @return The value.
      */
    public java.lang.Double getVolume() {
      return volume;
    }

    /**
      * Sets the value of the 'volume' field.
      * @param value The value of 'volume'.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder setVolume(double value) {
      validate(fields()[13], value);
      this.volume = value;
      fieldSetFlags()[13] = true;
      return this;
    }

    /**
      * Checks whether the 'volume' field has been set.
      * @return True if the 'volume' field has been set, false otherwise.
      */
    public boolean hasVolume() {
      return fieldSetFlags()[13];
    }


    /**
      * Clears the value of the 'volume' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearVolume() {
      fieldSetFlags()[13] = false;
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
    public io.raidenmap.statecacher.Token.Builder setTimestamp(long value) {
      validate(fields()[14], value);
      this.timestamp = value;
      fieldSetFlags()[14] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[14];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public io.raidenmap.statecacher.Token.Builder clearTimestamp() {
      fieldSetFlags()[14] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Token build() {
      try {
        Token record = new Token();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.String) defaultValue(fields()[0]);
        record.tag = fieldSetFlags()[1] ? this.tag : (java.lang.String) defaultValue(fields()[1]);
        record.imageUrl = fieldSetFlags()[2] ? this.imageUrl : (java.lang.String) defaultValue(fields()[2]);
        record.valueUsd = fieldSetFlags()[3] ? this.valueUsd : (java.lang.Double) defaultValue(fields()[3]);
        record.valueEth = fieldSetFlags()[4] ? this.valueEth : (java.lang.Double) defaultValue(fields()[4]);
        record.valueBtc = fieldSetFlags()[5] ? this.valueBtc : (java.lang.Double) defaultValue(fields()[5]);
        record.priceChangeDayUsd = fieldSetFlags()[6] ? this.priceChangeDayUsd : (java.lang.Float) defaultValue(fields()[6]);
        record.priceChangeWeekUsd = fieldSetFlags()[7] ? this.priceChangeWeekUsd : (java.lang.Float) defaultValue(fields()[7]);
        record.priceChangeDayEth = fieldSetFlags()[8] ? this.priceChangeDayEth : (java.lang.Float) defaultValue(fields()[8]);
        record.priceChangeWeekEth = fieldSetFlags()[9] ? this.priceChangeWeekEth : (java.lang.Float) defaultValue(fields()[9]);
        record.priceChangeDayBtc = fieldSetFlags()[10] ? this.priceChangeDayBtc : (java.lang.Float) defaultValue(fields()[10]);
        record.priceChangeWeekBtc = fieldSetFlags()[11] ? this.priceChangeWeekBtc : (java.lang.Float) defaultValue(fields()[11]);
        record.marketCap = fieldSetFlags()[12] ? this.marketCap : (java.lang.Double) defaultValue(fields()[12]);
        record.volume = fieldSetFlags()[13] ? this.volume : (java.lang.Double) defaultValue(fields()[13]);
        record.timestamp = fieldSetFlags()[14] ? this.timestamp : (java.lang.Long) defaultValue(fields()[14]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Token>
    WRITER$ = (org.apache.avro.io.DatumWriter<Token>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Token>
    READER$ = (org.apache.avro.io.DatumReader<Token>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
