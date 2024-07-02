// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscribing.proto

// Protobuf Java Version: 4.26.1
package sr.grpc.gen;

/**
 * Protobuf type {@code streaming.SubscribeRequest}
 */
public final class SubscribeRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:streaming.SubscribeRequest)
    SubscribeRequestOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      SubscribeRequest.class.getName());
  }
  // Use SubscribeRequest.newBuilder() to construct.
  private SubscribeRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private SubscribeRequest() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return sr.grpc.gen.SubscribingProto.internal_static_streaming_SubscribeRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return sr.grpc.gen.SubscribingProto.internal_static_streaming_SubscribeRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            sr.grpc.gen.SubscribeRequest.class, sr.grpc.gen.SubscribeRequest.Builder.class);
  }

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

  public static final int SUBSCRIPTION_ID_FIELD_NUMBER = 2;
  private int subscriptionId_ = 0;
  /**
   * <code>uint32 subscription_id = 2;</code>
   * @return The subscriptionId.
   */
  @java.lang.Override
  public int getSubscriptionId() {
    return subscriptionId_;
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
    if (subscriptionId_ != 0) {
      output.writeUInt32(2, subscriptionId_);
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
    if (subscriptionId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, subscriptionId_);
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
    if (!(obj instanceof sr.grpc.gen.SubscribeRequest)) {
      return super.equals(obj);
    }
    sr.grpc.gen.SubscribeRequest other = (sr.grpc.gen.SubscribeRequest) obj;

    if (getUserId()
        != other.getUserId()) return false;
    if (getSubscriptionId()
        != other.getSubscriptionId()) return false;
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
    hash = (37 * hash) + SUBSCRIPTION_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSubscriptionId();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static sr.grpc.gen.SubscribeRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.SubscribeRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.SubscribeRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.SubscribeRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.SubscribeRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.SubscribeRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.SubscribeRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.SubscribeRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static sr.grpc.gen.SubscribeRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static sr.grpc.gen.SubscribeRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.gen.SubscribeRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.SubscribeRequest parseFrom(
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
  public static Builder newBuilder(sr.grpc.gen.SubscribeRequest prototype) {
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
   * Protobuf type {@code streaming.SubscribeRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:streaming.SubscribeRequest)
      sr.grpc.gen.SubscribeRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sr.grpc.gen.SubscribingProto.internal_static_streaming_SubscribeRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sr.grpc.gen.SubscribingProto.internal_static_streaming_SubscribeRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sr.grpc.gen.SubscribeRequest.class, sr.grpc.gen.SubscribeRequest.Builder.class);
    }

    // Construct using sr.grpc.gen.SubscribeRequest.newBuilder()
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
      userId_ = 0;
      subscriptionId_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return sr.grpc.gen.SubscribingProto.internal_static_streaming_SubscribeRequest_descriptor;
    }

    @java.lang.Override
    public sr.grpc.gen.SubscribeRequest getDefaultInstanceForType() {
      return sr.grpc.gen.SubscribeRequest.getDefaultInstance();
    }

    @java.lang.Override
    public sr.grpc.gen.SubscribeRequest build() {
      sr.grpc.gen.SubscribeRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public sr.grpc.gen.SubscribeRequest buildPartial() {
      sr.grpc.gen.SubscribeRequest result = new sr.grpc.gen.SubscribeRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(sr.grpc.gen.SubscribeRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.userId_ = userId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.subscriptionId_ = subscriptionId_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof sr.grpc.gen.SubscribeRequest) {
        return mergeFrom((sr.grpc.gen.SubscribeRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(sr.grpc.gen.SubscribeRequest other) {
      if (other == sr.grpc.gen.SubscribeRequest.getDefaultInstance()) return this;
      if (other.getUserId() != 0) {
        setUserId(other.getUserId());
      }
      if (other.getSubscriptionId() != 0) {
        setSubscriptionId(other.getSubscriptionId());
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
            case 16: {
              subscriptionId_ = input.readUInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
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

    private int subscriptionId_ ;
    /**
     * <code>uint32 subscription_id = 2;</code>
     * @return The subscriptionId.
     */
    @java.lang.Override
    public int getSubscriptionId() {
      return subscriptionId_;
    }
    /**
     * <code>uint32 subscription_id = 2;</code>
     * @param value The subscriptionId to set.
     * @return This builder for chaining.
     */
    public Builder setSubscriptionId(int value) {

      subscriptionId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 subscription_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSubscriptionId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      subscriptionId_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:streaming.SubscribeRequest)
  }

  // @@protoc_insertion_point(class_scope:streaming.SubscribeRequest)
  private static final sr.grpc.gen.SubscribeRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new sr.grpc.gen.SubscribeRequest();
  }

  public static sr.grpc.gen.SubscribeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SubscribeRequest>
      PARSER = new com.google.protobuf.AbstractParser<SubscribeRequest>() {
    @java.lang.Override
    public SubscribeRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<SubscribeRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SubscribeRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public sr.grpc.gen.SubscribeRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
