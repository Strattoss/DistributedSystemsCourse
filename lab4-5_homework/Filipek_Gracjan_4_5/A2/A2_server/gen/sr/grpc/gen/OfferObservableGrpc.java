package sr.grpc.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: subscribing.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OfferObservableGrpc {

  private OfferObservableGrpc() {}

  public static final java.lang.String SERVICE_NAME = "streaming.OfferObservable";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.CreateSubscriptionRequest,
      sr.grpc.gen.CreateSubscriptionResponse> getCreateSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubscription",
      requestType = sr.grpc.gen.CreateSubscriptionRequest.class,
      responseType = sr.grpc.gen.CreateSubscriptionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.CreateSubscriptionRequest,
      sr.grpc.gen.CreateSubscriptionResponse> getCreateSubscriptionMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.CreateSubscriptionRequest, sr.grpc.gen.CreateSubscriptionResponse> getCreateSubscriptionMethod;
    if ((getCreateSubscriptionMethod = OfferObservableGrpc.getCreateSubscriptionMethod) == null) {
      synchronized (OfferObservableGrpc.class) {
        if ((getCreateSubscriptionMethod = OfferObservableGrpc.getCreateSubscriptionMethod) == null) {
          OfferObservableGrpc.getCreateSubscriptionMethod = getCreateSubscriptionMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.CreateSubscriptionRequest, sr.grpc.gen.CreateSubscriptionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.CreateSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.CreateSubscriptionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OfferObservableMethodDescriptorSupplier("CreateSubscription"))
              .build();
        }
      }
    }
    return getCreateSubscriptionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.SubscribeRequest,
      sr.grpc.gen.SubscribeResponse> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Subscribe",
      requestType = sr.grpc.gen.SubscribeRequest.class,
      responseType = sr.grpc.gen.SubscribeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.SubscribeRequest,
      sr.grpc.gen.SubscribeResponse> getSubscribeMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.SubscribeRequest, sr.grpc.gen.SubscribeResponse> getSubscribeMethod;
    if ((getSubscribeMethod = OfferObservableGrpc.getSubscribeMethod) == null) {
      synchronized (OfferObservableGrpc.class) {
        if ((getSubscribeMethod = OfferObservableGrpc.getSubscribeMethod) == null) {
          OfferObservableGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.SubscribeRequest, sr.grpc.gen.SubscribeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.SubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.SubscribeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OfferObservableMethodDescriptorSupplier("Subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OfferObservableStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OfferObservableStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OfferObservableStub>() {
        @java.lang.Override
        public OfferObservableStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OfferObservableStub(channel, callOptions);
        }
      };
    return OfferObservableStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OfferObservableBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OfferObservableBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OfferObservableBlockingStub>() {
        @java.lang.Override
        public OfferObservableBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OfferObservableBlockingStub(channel, callOptions);
        }
      };
    return OfferObservableBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OfferObservableFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OfferObservableFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OfferObservableFutureStub>() {
        @java.lang.Override
        public OfferObservableFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OfferObservableFutureStub(channel, callOptions);
        }
      };
    return OfferObservableFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createSubscription(sr.grpc.gen.CreateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.CreateSubscriptionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSubscriptionMethod(), responseObserver);
    }

    /**
     */
    default void subscribe(sr.grpc.gen.SubscribeRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.SubscribeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OfferObservable.
   */
  public static abstract class OfferObservableImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OfferObservableGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OfferObservable.
   */
  public static final class OfferObservableStub
      extends io.grpc.stub.AbstractAsyncStub<OfferObservableStub> {
    private OfferObservableStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OfferObservableStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OfferObservableStub(channel, callOptions);
    }

    /**
     */
    public void createSubscription(sr.grpc.gen.CreateSubscriptionRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.CreateSubscriptionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribe(sr.grpc.gen.SubscribeRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.SubscribeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OfferObservable.
   */
  public static final class OfferObservableBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OfferObservableBlockingStub> {
    private OfferObservableBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OfferObservableBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OfferObservableBlockingStub(channel, callOptions);
    }

    /**
     */
    public sr.grpc.gen.CreateSubscriptionResponse createSubscription(sr.grpc.gen.CreateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubscriptionMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<sr.grpc.gen.SubscribeResponse> subscribe(
        sr.grpc.gen.SubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OfferObservable.
   */
  public static final class OfferObservableFutureStub
      extends io.grpc.stub.AbstractFutureStub<OfferObservableFutureStub> {
    private OfferObservableFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OfferObservableFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OfferObservableFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.CreateSubscriptionResponse> createSubscription(
        sr.grpc.gen.CreateSubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubscriptionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SUBSCRIPTION = 0;
  private static final int METHODID_SUBSCRIBE = 1;

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
        case METHODID_CREATE_SUBSCRIPTION:
          serviceImpl.createSubscription((sr.grpc.gen.CreateSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.CreateSubscriptionResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((sr.grpc.gen.SubscribeRequest) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.SubscribeResponse>) responseObserver);
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
          getCreateSubscriptionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sr.grpc.gen.CreateSubscriptionRequest,
              sr.grpc.gen.CreateSubscriptionResponse>(
                service, METHODID_CREATE_SUBSCRIPTION)))
        .addMethod(
          getSubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              sr.grpc.gen.SubscribeRequest,
              sr.grpc.gen.SubscribeResponse>(
                service, METHODID_SUBSCRIBE)))
        .build();
  }

  private static abstract class OfferObservableBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OfferObservableBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sr.grpc.gen.SubscribingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OfferObservable");
    }
  }

  private static final class OfferObservableFileDescriptorSupplier
      extends OfferObservableBaseDescriptorSupplier {
    OfferObservableFileDescriptorSupplier() {}
  }

  private static final class OfferObservableMethodDescriptorSupplier
      extends OfferObservableBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OfferObservableMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OfferObservableGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OfferObservableFileDescriptorSupplier())
              .addMethod(getCreateSubscriptionMethod())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
