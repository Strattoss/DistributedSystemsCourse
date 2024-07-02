// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscribing.proto

// Protobuf Java Version: 4.26.1
package sr.grpc.gen;

/**
 * Protobuf type {@code streaming.CreateSubscriptionRequest}
 */
public final class CreateSubscriptionRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:streaming.CreateSubscriptionRequest)
    CreateSubscriptionRequestOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      CreateSubscriptionRequest.class.getName());
  }
  // Use CreateSubscriptionRequest.newBuilder() to construct.
  private CreateSubscriptionRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CreateSubscriptionRequest() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return sr.grpc.gen.SubscribingProto.internal_static_streaming_CreateSubscriptionRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return sr.grpc.gen.SubscribingProto.internal_static_streaming_CreateSubscriptionRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            sr.grpc.gen.CreateSubscriptionRequest.class, sr.grpc.gen.CreateSubscriptionRequest.Builder.class);
  }

  private int bitField0_;
  public static final int USER_ID_FIELD_NUMBER = 1;
  private int userId_ = 0;
  /**
   * <code>uint32 user_id = 1;</code>
   * @return The userId.
   */
  @java.lang.Override
  public int getUserId() {
    return userId_;
  }

  public static final int OFFER_FILTER_FIELD_NUMBER = 2;
  private sr.grpc.gen.OfferFilter offerFilter_;
  /**
   * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
   * @return Whether the offerFilter field is set.
   */
  @java.lang.Override
  public boolean hasOfferFilter() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
   * @return The offerFilter.
   */
  @java.lang.Override
  public sr.grpc.gen.OfferFilter getOfferFilter() {
    return offerFilter_ == null ? sr.grpc.gen.OfferFilter.getDefaultInstance() : offerFilter_;
  }
  /**
   * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
   */
  @java.lang.Override
  public sr.grpc.gen.OfferFilterOrBuilder getOfferFilterOrBuilder() {
    return offerFilter_ == null ? sr.grpc.gen.OfferFilter.getDefaultInstance() : offerFilter_;
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
    if (userId_ != 0) {
      output.writeUInt32(1, userId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(2, getOfferFilter());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, userId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getOfferFilter());
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
    if (!(obj instanceof sr.grpc.gen.CreateSubscriptionRequest)) {
      return super.equals(obj);
    }
    sr.grpc.gen.CreateSubscriptionRequest other = (sr.grpc.gen.CreateSubscriptionRequest) obj;

    if (getUserId()
        != other.getUserId()) return false;
    if (hasOfferFilter() != other.hasOfferFilter()) return false;
    if (hasOfferFilter()) {
      if (!getOfferFilter()
          .equals(other.getOfferFilter())) return false;
    }
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
    hash = (37 * hash) + USER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getUserId();
    if (hasOfferFilter()) {
      hash = (37 * hash) + OFFER_FILTER_FIELD_NUMBER;
      hash = (53 * hash) + getOfferFilter().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static sr.grpc.gen.CreateSubscriptionRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static sr.grpc.gen.CreateSubscriptionRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.CreateSubscriptionRequest parseFrom(
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
  public static Builder newBuilder(sr.grpc.gen.CreateSubscriptionRequest prototype) {
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
   * Protobuf type {@code streaming.CreateSubscriptionRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:streaming.CreateSubscriptionRequest)
      sr.grpc.gen.CreateSubscriptionRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sr.grpc.gen.SubscribingProto.internal_static_streaming_CreateSubscriptionRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sr.grpc.gen.SubscribingProto.internal_static_streaming_CreateSubscriptionRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sr.grpc.gen.CreateSubscriptionRequest.class, sr.grpc.gen.CreateSubscriptionRequest.Builder.class);
    }

    // Construct using sr.grpc.gen.CreateSubscriptionRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage
              .alwaysUseFieldBuilders) {
        getOfferFilterFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      userId_ = 0;
      offerFilter_ = null;
      if (offerFilterBuilder_ != null) {
        offerFilterBuilder_.dispose();
        offerFilterBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return sr.grpc.gen.SubscribingProto.internal_static_streaming_CreateSubscriptionRequest_descriptor;
    }

    @java.lang.Override
    public sr.grpc.gen.CreateSubscriptionRequest getDefaultInstanceForType() {
      return sr.grpc.gen.CreateSubscriptionRequest.getDefaultInstance();
    }

    @java.lang.Override
    public sr.grpc.gen.CreateSubscriptionRequest build() {
      sr.grpc.gen.CreateSubscriptionRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public sr.grpc.gen.CreateSubscriptionRequest buildPartial() {
      sr.grpc.gen.CreateSubscriptionRequest result = new sr.grpc.gen.CreateSubscriptionRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(sr.grpc.gen.CreateSubscriptionRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.userId_ = userId_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.offerFilter_ = offerFilterBuilder_ == null
            ? offerFilter_
            : offerFilterBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof sr.grpc.gen.CreateSubscriptionRequest) {
        return mergeFrom((sr.grpc.gen.CreateSubscriptionRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(sr.grpc.gen.CreateSubscriptionRequest other) {
      if (other == sr.grpc.gen.CreateSubscriptionRequest.getDefaultInstance()) return this;
      if (other.getUserId() != 0) {
        setUserId(other.getUserId());
      }
      if (other.hasOfferFilter()) {
        mergeOfferFilter(other.getOfferFilter());
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
              userId_ = input.readUInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              input.readMessage(
                  getOfferFilterFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private int userId_ ;
    /**
     * <code>uint32 user_id = 1;</code>
     * @return The userId.
     */
    @java.lang.Override
    public int getUserId() {
      return userId_;
    }
    /**
     * <code>uint32 user_id = 1;</code>
     * @param value The userId to set.
     * @return This builder for chaining.
     */
    public Builder setUserId(int value) {

      userId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 user_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      userId_ = 0;
      onChanged();
      return this;
    }

    private sr.grpc.gen.OfferFilter offerFilter_;
    private com.google.protobuf.SingleFieldBuilder<
        sr.grpc.gen.OfferFilter, sr.grpc.gen.OfferFilter.Builder, sr.grpc.gen.OfferFilterOrBuilder> offerFilterBuilder_;
    /**
     * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
     * @return Whether the offerFilter field is set.
     */
    public boolean hasOfferFilter() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
     * @return The offerFilter.
     */
    public sr.grpc.gen.OfferFilter getOfferFilter() {
      if (offerFilterBuilder_ == null) {
        return offerFilter_ == null ? sr.grpc.gen.OfferFilter.getDefaultInstance() : offerFilter_;
      } else {
        return offerFilterBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
     */
    public Builder setOfferFilter(sr.grpc.gen.OfferFilter value) {
      if (offerFilterBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        offerFilter_ = value;
      } else {
        offerFilterBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
     */
    public Builder setOfferFilter(
        sr.grpc.gen.OfferFilter.Builder builderForValue) {
      if (offerFilterBuilder_ == null) {
        offerFilter_ = builderForValue.build();
      } else {
        offerFilterBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
     */
    public Builder mergeOfferFilter(sr.grpc.gen.OfferFilter value) {
      if (offerFilterBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          offerFilter_ != null &&
          offerFilter_ != sr.grpc.gen.OfferFilter.getDefaultInstance()) {
          getOfferFilterBuilder().mergeFrom(value);
        } else {
          offerFilter_ = value;
        }
      } else {
        offerFilterBuilder_.mergeFrom(value);
      }
      if (offerFilter_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
     */
    public Builder clearOfferFilter() {
      bitField0_ = (bitField0_ & ~0x00000002);
      offerFilter_ = null;
      if (offerFilterBuilder_ != null) {
        offerFilterBuilder_.dispose();
        offerFilterBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
     */
    public sr.grpc.gen.OfferFilter.Builder getOfferFilterBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getOfferFilterFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
     */
    public sr.grpc.gen.OfferFilterOrBuilder getOfferFilterOrBuilder() {
      if (offerFilterBuilder_ != null) {
        return offerFilterBuilder_.getMessageOrBuilder();
      } else {
        return offerFilter_ == null ?
            sr.grpc.gen.OfferFilter.getDefaultInstance() : offerFilter_;
      }
    }
    /**
     * <code>optional .streaming.OfferFilter offer_filter = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        sr.grpc.gen.OfferFilter, sr.grpc.gen.OfferFilter.Builder, sr.grpc.gen.OfferFilterOrBuilder> 
        getOfferFilterFieldBuilder() {
      if (offerFilterBuilder_ == null) {
        offerFilterBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            sr.grpc.gen.OfferFilter, sr.grpc.gen.OfferFilter.Builder, sr.grpc.gen.OfferFilterOrBuilder>(
                getOfferFilter(),
                getParentForChildren(),
                isClean());
        offerFilter_ = null;
      }
      return offerFilterBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:streaming.CreateSubscriptionRequest)
  }

  // @@protoc_insertion_point(class_scope:streaming.CreateSubscriptionRequest)
  private static final sr.grpc.gen.CreateSubscriptionRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new sr.grpc.gen.CreateSubscriptionRequest();
  }

  public static sr.grpc.gen.CreateSubscriptionRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateSubscriptionRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreateSubscriptionRequest>() {
    @java.lang.Override
    public CreateSubscriptionRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<CreateSubscriptionRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateSubscriptionRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public sr.grpc.gen.CreateSubscriptionRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
