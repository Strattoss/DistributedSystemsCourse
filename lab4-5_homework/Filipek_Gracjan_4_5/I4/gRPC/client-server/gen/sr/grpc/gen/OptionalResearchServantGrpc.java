package sr.grpc.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: researching_optional.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OptionalResearchServantGrpc {

  private OptionalResearchServantGrpc() {}

  public static final java.lang.String SERVICE_NAME = "researching_optional.OptionalResearchServant";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.Empty,
      sr.grpc.gen.Data> getSendWithEmptyParameterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendWithEmptyParameter",
      requestType = sr.grpc.gen.Empty.class,
      responseType = sr.grpc.gen.Data.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.Empty,
      sr.grpc.gen.Data> getSendWithEmptyParameterMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.Empty, sr.grpc.gen.Data> getSendWithEmptyParameterMethod;
    if ((getSendWithEmptyParameterMethod = OptionalResearchServantGrpc.getSendWithEmptyParameterMethod) == null) {
      synchronized (OptionalResearchServantGrpc.class) {
        if ((getSendWithEmptyParameterMethod = OptionalResearchServantGrpc.getSendWithEmptyParameterMethod) == null) {
          OptionalResearchServantGrpc.getSendWithEmptyParameterMethod = getSendWithEmptyParameterMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.Empty, sr.grpc.gen.Data>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendWithEmptyParameter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Data.getDefaultInstance()))
              .setSchemaDescriptor(new OptionalResearchServantMethodDescriptorSupplier("SendWithEmptyParameter"))
              .build();
        }
      }
    }
    return getSendWithEmptyParameterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.Data,
      sr.grpc.gen.Empty> getSendWithEmptyReturnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendWithEmptyReturn",
      requestType = sr.grpc.gen.Data.class,
      responseType = sr.grpc.gen.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.Data,
      sr.grpc.gen.Empty> getSendWithEmptyReturnMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.Data, sr.grpc.gen.Empty> getSendWithEmptyReturnMethod;
    if ((getSendWithEmptyReturnMethod = OptionalResearchServantGrpc.getSendWithEmptyReturnMethod) == null) {
      synchronized (OptionalResearchServantGrpc.class) {
        if ((getSendWithEmptyReturnMethod = OptionalResearchServantGrpc.getSendWithEmptyReturnMethod) == null) {
          OptionalResearchServantGrpc.getSendWithEmptyReturnMethod = getSendWithEmptyReturnMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.Data, sr.grpc.gen.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendWithEmptyReturn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Data.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OptionalResearchServantMethodDescriptorSupplier("SendWithEmptyReturn"))
              .build();
        }
      }
    }
    return getSendWithEmptyReturnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.Empty,
      sr.grpc.gen.Empty> getSendWithEmptyAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendWithEmptyAll",
      requestType = sr.grpc.gen.Empty.class,
      responseType = sr.grpc.gen.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.Empty,
      sr.grpc.gen.Empty> getSendWithEmptyAllMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.Empty, sr.grpc.gen.Empty> getSendWithEmptyAllMethod;
    if ((getSendWithEmptyAllMethod = OptionalResearchServantGrpc.getSendWithEmptyAllMethod) == null) {
      synchronized (OptionalResearchServantGrpc.class) {
        if ((getSendWithEmptyAllMethod = OptionalResearchServantGrpc.getSendWithEmptyAllMethod) == null) {
          OptionalResearchServantGrpc.getSendWithEmptyAllMethod = getSendWithEmptyAllMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.Empty, sr.grpc.gen.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendWithEmptyAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OptionalResearchServantMethodDescriptorSupplier("SendWithEmptyAll"))
              .build();
        }
      }
    }
    return getSendWithEmptyAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.Data,
      sr.grpc.gen.Data> getSendDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendData",
      requestType = sr.grpc.gen.Data.class,
      responseType = sr.grpc.gen.Data.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.Data,
      sr.grpc.gen.Data> getSendDataMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.Data, sr.grpc.gen.Data> getSendDataMethod;
    if ((getSendDataMethod = OptionalResearchServantGrpc.getSendDataMethod) == null) {
      synchronized (OptionalResearchServantGrpc.class) {
        if ((getSendDataMethod = OptionalResearchServantGrpc.getSendDataMethod) == null) {
          OptionalResearchServantGrpc.getSendDataMethod = getSendDataMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.Data, sr.grpc.gen.Data>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Data.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Data.getDefaultInstance()))
              .setSchemaDescriptor(new OptionalResearchServantMethodDescriptorSupplier("SendData"))
              .build();
        }
      }
    }
    return getSendDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.DataRepeated,
      sr.grpc.gen.DataRepeated> getSendDataRepeatedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDataRepeated",
      requestType = sr.grpc.gen.DataRepeated.class,
      responseType = sr.grpc.gen.DataRepeated.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.DataRepeated,
      sr.grpc.gen.DataRepeated> getSendDataRepeatedMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.DataRepeated, sr.grpc.gen.DataRepeated> getSendDataRepeatedMethod;
    if ((getSendDataRepeatedMethod = OptionalResearchServantGrpc.getSendDataRepeatedMethod) == null) {
      synchronized (OptionalResearchServantGrpc.class) {
        if ((getSendDataRepeatedMethod = OptionalResearchServantGrpc.getSendDataRepeatedMethod) == null) {
          OptionalResearchServantGrpc.getSendDataRepeatedMethod = getSendDataRepeatedMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.DataRepeated, sr.grpc.gen.DataRepeated>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendDataRepeated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.DataRepeated.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.DataRepeated.getDefaultInstance()))
              .setSchemaDescriptor(new OptionalResearchServantMethodDescriptorSupplier("SendDataRepeated"))
              .build();
        }
      }
    }
    return getSendDataRepeatedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.DataExplicitlyOptional,
      sr.grpc.gen.DataExplicitlyOptional> getSendDataExplicitlyOptionalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDataExplicitlyOptional",
      requestType = sr.grpc.gen.DataExplicitlyOptional.class,
      responseType = sr.grpc.gen.DataExplicitlyOptional.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.DataExplicitlyOptional,
      sr.grpc.gen.DataExplicitlyOptional> getSendDataExplicitlyOptionalMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.DataExplicitlyOptional, sr.grpc.gen.DataExplicitlyOptional> getSendDataExplicitlyOptionalMethod;
    if ((getSendDataExplicitlyOptionalMethod = OptionalResearchServantGrpc.getSendDataExplicitlyOptionalMethod) == null) {
      synchronized (OptionalResearchServantGrpc.class) {
        if ((getSendDataExplicitlyOptionalMethod = OptionalResearchServantGrpc.getSendDataExplicitlyOptionalMethod) == null) {
          OptionalResearchServantGrpc.getSendDataExplicitlyOptionalMethod = getSendDataExplicitlyOptionalMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.DataExplicitlyOptional, sr.grpc.gen.DataExplicitlyOptional>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendDataExplicitlyOptional"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.DataExplicitlyOptional.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.DataExplicitlyOptional.getDefaultInstance()))
              .setSchemaDescriptor(new OptionalResearchServantMethodDescriptorSupplier("SendDataExplicitlyOptional"))
              .build();
        }
      }
    }
    return getSendDataExplicitlyOptionalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.DataOneOf,
      sr.grpc.gen.DataOneOf> getSendDataOneOfMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDataOneOf",
      requestType = sr.grpc.gen.DataOneOf.class,
      responseType = sr.grpc.gen.DataOneOf.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.DataOneOf,
      sr.grpc.gen.DataOneOf> getSendDataOneOfMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.DataOneOf, sr.grpc.gen.DataOneOf> getSendDataOneOfMethod;
    if ((getSendDataOneOfMethod = OptionalResearchServantGrpc.getSendDataOneOfMethod) == null) {
      synchronized (OptionalResearchServantGrpc.class) {
        if ((getSendDataOneOfMethod = OptionalResearchServantGrpc.getSendDataOneOfMethod) == null) {
          OptionalResearchServantGrpc.getSendDataOneOfMethod = getSendDataOneOfMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.DataOneOf, sr.grpc.gen.DataOneOf>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendDataOneOf"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.DataOneOf.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.DataOneOf.getDefaultInstance()))
              .setSchemaDescriptor(new OptionalResearchServantMethodDescriptorSupplier("SendDataOneOf"))
              .build();
        }
      }
    }
    return getSendDataOneOfMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OptionalResearchServantStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OptionalResearchServantStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OptionalResearchServantStub>() {
        @java.lang.Override
        public OptionalResearchServantStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OptionalResearchServantStub(channel, callOptions);
        }
      };
    return OptionalResearchServantStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OptionalResearchServantBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OptionalResearchServantBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OptionalResearchServantBlockingStub>() {
        @java.lang.Override
        public OptionalResearchServantBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OptionalResearchServantBlockingStub(channel, callOptions);
        }
      };
    return OptionalResearchServantBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OptionalResearchServantFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OptionalResearchServantFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OptionalResearchServantFutureStub>() {
        @java.lang.Override
        public OptionalResearchServantFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OptionalResearchServantFutureStub(channel, callOptions);
        }
      };
    return OptionalResearchServantFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sendWithEmptyParameter(sr.grpc.gen.Empty request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Data> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendWithEmptyParameterMethod(), responseObserver);
    }

    /**
     */
    default void sendWithEmptyReturn(sr.grpc.gen.Data request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendWithEmptyReturnMethod(), responseObserver);
    }

    /**
     */
    default void sendWithEmptyAll(sr.grpc.gen.Empty request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendWithEmptyAllMethod(), responseObserver);
    }

    /**
     */
    default void sendData(sr.grpc.gen.Data request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Data> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendDataMethod(), responseObserver);
    }

    /**
     */
    default void sendDataRepeated(sr.grpc.gen.DataRepeated request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.DataRepeated> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendDataRepeatedMethod(), responseObserver);
    }

    /**
     */
    default void sendDataExplicitlyOptional(sr.grpc.gen.DataExplicitlyOptional request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.DataExplicitlyOptional> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendDataExplicitlyOptionalMethod(), responseObserver);
    }

    /**
     */
    default void sendDataOneOf(sr.grpc.gen.DataOneOf request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.DataOneOf> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendDataOneOfMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OptionalResearchServant.
   */
  public static abstract class OptionalResearchServantImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OptionalResearchServantGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OptionalResearchServant.
   */
  public static final class OptionalResearchServantStub
      extends io.grpc.stub.AbstractAsyncStub<OptionalResearchServantStub> {
    private OptionalResearchServantStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OptionalResearchServantStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OptionalResearchServantStub(channel, callOptions);
    }

    /**
     */
    public void sendWithEmptyParameter(sr.grpc.gen.Empty request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Data> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendWithEmptyParameterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendWithEmptyReturn(sr.grpc.gen.Data request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendWithEmptyReturnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendWithEmptyAll(sr.grpc.gen.Empty request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendWithEmptyAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendData(sr.grpc.gen.Data request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Data> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendDataRepeated(sr.grpc.gen.DataRepeated request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.DataRepeated> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendDataRepeatedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendDataExplicitlyOptional(sr.grpc.gen.DataExplicitlyOptional request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.DataExplicitlyOptional> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendDataExplicitlyOptionalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendDataOneOf(sr.grpc.gen.DataOneOf request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.DataOneOf> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendDataOneOfMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OptionalResearchServant.
   */
  public static final class OptionalResearchServantBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OptionalResearchServantBlockingStub> {
    private OptionalResearchServantBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OptionalResearchServantBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OptionalResearchServantBlockingStub(channel, callOptions);
    }

    /**
     */
    public sr.grpc.gen.Data sendWithEmptyParameter(sr.grpc.gen.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendWithEmptyParameterMethod(), getCallOptions(), request);
    }

    /**
     */
    public sr.grpc.gen.Empty sendWithEmptyReturn(sr.grpc.gen.Data request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendWithEmptyReturnMethod(), getCallOptions(), request);
    }

    /**
     */
    public sr.grpc.gen.Empty sendWithEmptyAll(sr.grpc.gen.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendWithEmptyAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public sr.grpc.gen.Data sendData(sr.grpc.gen.Data request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public sr.grpc.gen.DataRepeated sendDataRepeated(sr.grpc.gen.DataRepeated request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendDataRepeatedMethod(), getCallOptions(), request);
    }

    /**
     */
    public sr.grpc.gen.DataExplicitlyOptional sendDataExplicitlyOptional(sr.grpc.gen.DataExplicitlyOptional request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendDataExplicitlyOptionalMethod(), getCallOptions(), request);
    }

    /**
     */
    public sr.grpc.gen.DataOneOf sendDataOneOf(sr.grpc.gen.DataOneOf request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendDataOneOfMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OptionalResearchServant.
   */
  public static final class OptionalResearchServantFutureStub
      extends io.grpc.stub.AbstractFutureStub<OptionalResearchServantFutureStub> {
    private OptionalResearchServantFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OptionalResearchServantFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OptionalResearchServantFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.Data> sendWithEmptyParameter(
        sr.grpc.gen.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendWithEmptyParameterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.Empty> sendWithEmptyReturn(
        sr.grpc.gen.Data request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendWithEmptyReturnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.Empty> sendWithEmptyAll(
        sr.grpc.gen.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendWithEmptyAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.Data> sendData(
        sr.grpc.gen.Data request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.DataRepeated> sendDataRepeated(
        sr.grpc.gen.DataRepeated request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendDataRepeatedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.DataExplicitlyOptional> sendDataExplicitlyOptional(
        sr.grpc.gen.DataExplicitlyOptional request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendDataExplicitlyOptionalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.DataOneOf> sendDataOneOf(
        sr.grpc.gen.DataOneOf request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendDataOneOfMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_WITH_EMPTY_PARAMETER = 0;
  private static final int METHODID_SEND_WITH_EMPTY_RETURN = 1;
  private static final int METHODID_SEND_WITH_EMPTY_ALL = 2;
  private static final int METHODID_SEND_DATA = 3;
  private static final int METHODID_SEND_DATA_REPEATED = 4;
  private static final int METHODID_SEND_DATA_EXPLICITLY_OPTIONAL = 5;
  private static final int METHODID_SEND_DATA_ONE_OF = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_WITH_EMPTY_PARAMETER:
          serviceImpl.sendWithEmptyParameter((sr.grpc.gen.Empty) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.Data>) responseObserver);
          break;
        case METHODID_SEND_WITH_EMPTY_RETURN:
          serviceImpl.sendWithEmptyReturn((sr.grpc.gen.Data) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.Empty>) responseObserver);
          break;
        case METHODID_SEND_WITH_EMPTY_ALL:
          serviceImpl.sendWithEmptyAll((sr.grpc.gen.Empty) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.Empty>) responseObserver);
          break;
        case METHODID_SEND_DATA:
          serviceImpl.sendData((sr.grpc.gen.Data) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.Data>) responseObserver);
          break;
        case METHODID_SEND_DATA_REPEATED:
          serviceImpl.sendDataRepeated((sr.grpc.gen.DataRepeated) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.DataRepeated>) responseObserver);
          break;
        case METHODID_SEND_DATA_EXPLICITLY_OPTIONAL:
          serviceImpl.sendDataExplicitlyOptional((sr.grpc.gen.DataExplicitlyOptional) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.DataExplicitlyOptional>) responseObserver);
          break;
        case METHODID_SEND_DATA_ONE_OF:
          serviceImpl.sendDataOneOf((sr.grpc.gen.DataOneOf) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.DataOneOf>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendWithEmptyParameterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.grpc.gen.Empty,
              sr.grpc.gen.Data>(
                service, METHODID_SEND_WITH_EMPTY_PARAMETER)))
        .addMethod(
          getSendWithEmptyReturnMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.grpc.gen.Data,
              sr.grpc.gen.Empty>(
                service, METHODID_SEND_WITH_EMPTY_RETURN)))
        .addMethod(
          getSendWithEmptyAllMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.grpc.gen.Empty,
              sr.grpc.gen.Empty>(
                service, METHODID_SEND_WITH_EMPTY_ALL)))
        .addMethod(
          getSendDataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.grpc.gen.Data,
              sr.grpc.gen.Data>(
                service, METHODID_SEND_DATA)))
        .addMethod(
          getSendDataRepeatedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.grpc.gen.DataRepeated,
              sr.grpc.gen.DataRepeated>(
                service, METHODID_SEND_DATA_REPEATED)))
        .addMethod(
          getSendDataExplicitlyOptionalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.grpc.gen.DataExplicitlyOptional,
              sr.grpc.gen.DataExplicitlyOptional>(
                service, METHODID_SEND_DATA_EXPLICITLY_OPTIONAL)))
        .addMethod(
          getSendDataOneOfMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.grpc.gen.DataOneOf,
              sr.grpc.gen.DataOneOf>(
                service, METHODID_SEND_DATA_ONE_OF)))
        .build();
  }

  private static abstract class OptionalResearchServantBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OptionalResearchServantBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sr.grpc.gen.DataProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OptionalResearchServant");
    }
  }

  private static final class OptionalResearchServantFileDescriptorSupplier
      extends OptionalResearchServantBaseDescriptorSupplier {
    OptionalResearchServantFileDescriptorSupplier() {}
  }

  private static final class OptionalResearchServantMethodDescriptorSupplier
      extends OptionalResearchServantBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OptionalResearchServantMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OptionalResearchServantGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OptionalResearchServantFileDescriptorSupplier())
              .addMethod(getSendWithEmptyParameterMethod())
              .addMethod(getSendWithEmptyReturnMethod())
              .addMethod(getSendWithEmptyAllMethod())
              .addMethod(getSendDataMethod())
              .addMethod(getSendDataRepeatedMethod())
              .addMethod(getSendDataExplicitlyOptionalMethod())
              .addMethod(getSendDataOneOfMethod())
              .build();
        }
      }
    }
    return result;
  }
}
