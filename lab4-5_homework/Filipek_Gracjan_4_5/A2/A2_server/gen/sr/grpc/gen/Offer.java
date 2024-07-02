// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscribing.proto

// Protobuf Java Version: 4.26.1
package sr.grpc.gen;

/**
 * Protobuf type {@code streaming.Offer}
 */
public final class Offer extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:streaming.Offer)
    OfferOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      Offer.class.getName());
  }
  // Use Offer.newBuilder() to construct.
  private Offer(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Offer() {
    title_ = "";
    category_ = 0;
    description_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return sr.grpc.gen.SubscribingProto.internal_static_streaming_Offer_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return sr.grpc.gen.SubscribingProto.internal_static_streaming_Offer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            sr.grpc.gen.Offer.class, sr.grpc.gen.Offer.Builder.class);
  }

  public static final int OFFER_ID_FIELD_NUMBER = 1;
  private int offerId_ = 0;
  /**
   * <code>int32 offer_id = 1;</code>
   * @return The offerId.
   */
  @java.lang.Override
  public int getOfferId() {
    return offerId_;
  }

  public static final int TITLE_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object title_ = "";
  /**
   * <code>string title = 2;</code>
   * @return The title.
   */
  @java.lang.Override
  public java.lang.String getTitle() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      title_ = s;
      return s;
    }
  }
  /**
   * <code>string title = 2;</code>
   * @return The bytes for title.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTitleBytes() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      title_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CATEGORY_FIELD_NUMBER = 3;
  private int category_ = 0;
  /**
   * <code>.streaming.Category category = 3;</code>
   * @return The enum numeric value on the wire for category.
   */
  @java.lang.Override public int getCategoryValue() {
    return category_;
  }
  /**
   * <code>.streaming.Category category = 3;</code>
   * @return The category.
   */
  @java.lang.Override public sr.grpc.gen.Category getCategory() {
    sr.grpc.gen.Category result = sr.grpc.gen.Category.forNumber(category_);
    return result == null ? sr.grpc.gen.Category.UNRECOGNIZED : result;
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object description_ = "";
  /**
   * <code>string description = 4;</code>
   * @return The description.
   */
  @java.lang.Override
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   * <code>string description = 4;</code>
   * @return The bytes for description.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRICE_INTEGER_PART_FIELD_NUMBER = 5;
  private int priceIntegerPart_ = 0;
  /**
   * <code>uint32 price_integer_part = 5;</code>
   * @return The priceIntegerPart.
   */
  @java.lang.Override
  public int getPriceIntegerPart() {
    return priceIntegerPart_;
  }

  public static final int PRICE_DECIMAL_PART_FIELD_NUMBER = 6;
  private int priceDecimalPart_ = 0;
  /**
   * <code>uint32 price_decimal_part = 6;</code>
   * @return The priceDecimalPart.
   */
  @java.lang.Override
  public int getPriceDecimalPart() {
    return priceDecimalPart_;
  }

  public static final int AVAILABLE_AMOUNT_FIELD_NUMBER = 7;
  private int availableAmount_ = 0;
  /**
   * <code>uint32 available_amount = 7;</code>
   * @return The availableAmount.
   */
  @java.lang.Override
  public int getAvailableAmount() {
    return availableAmount_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (offerId_ != 0) {
      output.writeInt32(1, offerId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(title_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, title_);
    }
    if (category_ != sr.grpc.gen.Category.FOODS.getNumber()) {
      output.writeEnum(3, category_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(description_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 4, description_);
    }
    if (priceIntegerPart_ != 0) {
      output.writeUInt32(5, priceIntegerPart_);
    }
    if (priceDecimalPart_ != 0) {
      output.writeUInt32(6, priceDecimalPart_);
    }
    if (availableAmount_ != 0) {
      output.writeUInt32(7, availableAmount_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (offerId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, offerId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(title_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, title_);
    }
    if (category_ != sr.grpc.gen.Category.FOODS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, category_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(description_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(4, description_);
    }
    if (priceIntegerPart_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(5, priceIntegerPart_);
    }
    if (priceDecimalPart_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(6, priceDecimalPart_);
    }
    if (availableAmount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(7, availableAmount_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof sr.grpc.gen.Offer)) {
      return super.equals(obj);
    }
    sr.grpc.gen.Offer other = (sr.grpc.gen.Offer) obj;

    if (getOfferId()
        != other.getOfferId()) return false;
    if (!getTitle()
        .equals(other.getTitle())) return false;
    if (category_ != other.category_) return false;
    if (!getDescription()
        .equals(other.getDescription())) return false;
    if (getPriceIntegerPart()
        != other.getPriceIntegerPart()) return false;
    if (getPriceDecimalPart()
        != other.getPriceDecimalPart()) return false;
    if (getAvailableAmount()
        != other.getAvailableAmount()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + OFFER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getOfferId();
    hash = (37 * hash) + TITLE_FIELD_NUMBER;
    hash = (53 * hash) + getTitle().hashCode();
    hash = (37 * hash) + CATEGORY_FIELD_NUMBER;
    hash = (53 * hash) + category_;
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    hash = (37 * hash) + PRICE_INTEGER_PART_FIELD_NUMBER;
    hash = (53 * hash) + getPriceIntegerPart();
    hash = (37 * hash) + PRICE_DECIMAL_PART_FIELD_NUMBER;
    hash = (53 * hash) + getPriceDecimalPart();
    hash = (37 * hash) + AVAILABLE_AMOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getAvailableAmount();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static sr.grpc.gen.Offer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.Offer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.Offer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.Offer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.Offer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.Offer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.Offer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.Offer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static sr.grpc.gen.Offer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static sr.grpc.gen.Offer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.gen.Offer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.Offer parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(sr.grpc.gen.Offer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code streaming.Offer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:streaming.Offer)
      sr.grpc.gen.OfferOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sr.grpc.gen.SubscribingProto.internal_static_streaming_Offer_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sr.grpc.gen.SubscribingProto.internal_static_streaming_Offer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sr.grpc.gen.Offer.class, sr.grpc.gen.Offer.Builder.class);
    }

    // Construct using sr.grpc.gen.Offer.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      offerId_ = 0;
      title_ = "";
      category_ = 0;
      description_ = "";
      priceIntegerPart_ = 0;
      priceDecimalPart_ = 0;
      availableAmount_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return sr.grpc.gen.SubscribingProto.internal_static_streaming_Offer_descriptor;
    }

    @java.lang.Override
    public sr.grpc.gen.Offer getDefaultInstanceForType() {
      return sr.grpc.gen.Offer.getDefaultInstance();
    }

    @java.lang.Override
    public sr.grpc.gen.Offer build() {
      sr.grpc.gen.Offer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public sr.grpc.gen.Offer buildPartial() {
      sr.grpc.gen.Offer result = new sr.grpc.gen.Offer(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(sr.grpc.gen.Offer result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.offerId_ = offerId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.title_ = title_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.category_ = category_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.description_ = description_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.priceIntegerPart_ = priceIntegerPart_;
      }
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.priceDecimalPart_ = priceDecimalPart_;
      }
      if (((from_bitField0_ & 0x00000040) != 0)) {
        result.availableAmount_ = availableAmount_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof sr.grpc.gen.Offer) {
        return mergeFrom((sr.grpc.gen.Offer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(sr.grpc.gen.Offer other) {
      if (other == sr.grpc.gen.Offer.getDefaultInstance()) return this;
      if (other.getOfferId() != 0) {
        setOfferId(other.getOfferId());
      }
      if (!other.getTitle().isEmpty()) {
        title_ = other.title_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.category_ != 0) {
        setCategoryValue(other.getCategoryValue());
      }
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      if (other.getPriceIntegerPart() != 0) {
        setPriceIntegerPart(other.getPriceIntegerPart());
      }
      if (other.getPriceDecimalPart() != 0) {
        setPriceDecimalPart(other.getPriceDecimalPart());
      }
      if (other.getAvailableAmount() != 0) {
        setAvailableAmount(other.getAvailableAmount());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              offerId_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              title_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 24: {
              category_ = input.readEnum();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 34: {
              description_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            case 40: {
              priceIntegerPart_ = input.readUInt32();
              bitField0_ |= 0x00000010;
              break;
            } // case 40
            case 48: {
              priceDecimalPart_ = input.readUInt32();
              bitField0_ |= 0x00000020;
              break;
            } // case 48
            case 56: {
              availableAmount_ = input.readUInt32();
              bitField0_ |= 0x00000040;
              break;
            } // case 56
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int offerId_ ;
    /**
     * <code>int32 offer_id = 1;</code>
     * @return The offerId.
     */
    @java.lang.Override
    public int getOfferId() {
      return offerId_;
    }
    /**
     * <code>int32 offer_id = 1;</code>
     * @param value The offerId to set.
     * @return This builder for chaining.
     */
    public Builder setOfferId(int value) {

      offerId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 offer_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearOfferId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      offerId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object title_ = "";
    /**
     * <code>string title = 2;</code>
     * @return The title.
     */
    public java.lang.String getTitle() {
      java.lang.Object ref = title_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        title_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     * @return The bytes for title.
     */
    public com.google.protobuf.ByteString
        getTitleBytes() {
      java.lang.Object ref = title_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        title_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     * @param value The title to set.
     * @return This builder for chaining.
     */
    public Builder setTitle(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      title_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTitle() {
      title_ = getDefaultInstance().getTitle();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     * @param value The bytes for title to set.
     * @return This builder for chaining.
     */
    public Builder setTitleBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      title_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private int category_ = 0;
    /**
     * <code>.streaming.Category category = 3;</code>
     * @return The enum numeric value on the wire for category.
     */
    @java.lang.Override public int getCategoryValue() {
      return category_;
    }
    /**
     * <code>.streaming.Category category = 3;</code>
     * @param value The enum numeric value on the wire for category to set.
     * @return This builder for chaining.
     */
    public Builder setCategoryValue(int value) {
      category_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.streaming.Category category = 3;</code>
     * @return The category.
     */
    @java.lang.Override
    public sr.grpc.gen.Category getCategory() {
      sr.grpc.gen.Category result = sr.grpc.gen.Category.forNumber(category_);
      return result == null ? sr.grpc.gen.Category.UNRECOGNIZED : result;
    }
    /**
     * <code>.streaming.Category category = 3;</code>
     * @param value The category to set.
     * @return This builder for chaining.
     */
    public Builder setCategory(sr.grpc.gen.Category value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000004;
      category_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.streaming.Category category = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearCategory() {
      bitField0_ = (bitField0_ & ~0x00000004);
      category_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     * <code>string description = 4;</code>
     * @return The description.
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string description = 4;</code>
     * @return The bytes for description.
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string description = 4;</code>
     * @param value The description to set.
     * @return This builder for chaining.
     */
    public Builder setDescription(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      description_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string description = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearDescription() {
      description_ = getDefaultInstance().getDescription();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string description = 4;</code>
     * @param value The bytes for description to set.
     * @return This builder for chaining.
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      description_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }

    private int priceIntegerPart_ ;
    /**
     * <code>uint32 price_integer_part = 5;</code>
     * @return The priceIntegerPart.
     */
    @java.lang.Override
    public int getPriceIntegerPart() {
      return priceIntegerPart_;
    }
    /**
     * <code>uint32 price_integer_part = 5;</code>
     * @param value The priceIntegerPart to set.
     * @return This builder for chaining.
     */
    public Builder setPriceIntegerPart(int value) {

      priceIntegerPart_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 price_integer_part = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearPriceIntegerPart() {
      bitField0_ = (bitField0_ & ~0x00000010);
      priceIntegerPart_ = 0;
      onChanged();
      return this;
    }

    private int priceDecimalPart_ ;
    /**
     * <code>uint32 price_decimal_part = 6;</code>
     * @return The priceDecimalPart.
     */
    @java.lang.Override
    public int getPriceDecimalPart() {
      return priceDecimalPart_;
    }
    /**
     * <code>uint32 price_decimal_part = 6;</code>
     * @param value The priceDecimalPart to set.
     * @return This builder for chaining.
     */
    public Builder setPriceDecimalPart(int value) {

      priceDecimalPart_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 price_decimal_part = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearPriceDecimalPart() {
      bitField0_ = (bitField0_ & ~0x00000020);
      priceDecimalPart_ = 0;
      onChanged();
      return this;
    }

    private int availableAmount_ ;
    /**
     * <code>uint32 available_amount = 7;</code>
     * @return The availableAmount.
     */
    @java.lang.Override
    public int getAvailableAmount() {
      return availableAmount_;
    }
    /**
     * <code>uint32 available_amount = 7;</code>
     * @param value The availableAmount to set.
     * @return This builder for chaining.
     */
    public Builder setAvailableAmount(int value) {

      availableAmount_ = value;
      bitField0_ |= 0x00000040;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 available_amount = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearAvailableAmount() {
      bitField0_ = (bitField0_ & ~0x00000040);
      availableAmount_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:streaming.Offer)
  }

  // @@protoc_insertion_point(class_scope:streaming.Offer)
  private static final sr.grpc.gen.Offer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new sr.grpc.gen.Offer();
  }

  public static sr.grpc.gen.Offer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Offer>
      PARSER = new com.google.protobuf.AbstractParser<Offer>() {
    @java.lang.Override
    public Offer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Offer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Offer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public sr.grpc.gen.Offer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
