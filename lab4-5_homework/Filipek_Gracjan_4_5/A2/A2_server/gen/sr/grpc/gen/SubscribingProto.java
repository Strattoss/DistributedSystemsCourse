// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscribing.proto
// Protobuf Java Version: 4.26.1

package sr.grpc.gen;

public final class SubscribingProto {
  private SubscribingProto() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      SubscribingProto.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_streaming_OfferFilter_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_streaming_OfferFilter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_streaming_Offer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_streaming_Offer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_streaming_CreateSubscriptionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_streaming_CreateSubscriptionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_streaming_CreateSubscriptionResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_streaming_CreateSubscriptionResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_streaming_SubscribeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_streaming_SubscribeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_streaming_SubscribeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_streaming_SubscribeResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021subscribing.proto\022\tstreaming\"\371\001\n\013Offer" +
      "Filter\022\022\n\ncategories\030\001 \003(\t\022\031\n\014minimalPri" +
      "ce\030\002 \001(\001H\000\210\001\001\022\031\n\014maximalPrice\030\003 \001(\001H\001\210\001\001" +
      "\022#\n\026minimalAvailableAmount\030\004 \001(\rH\002\210\001\001\022#\n" +
      "\026maximalAvailableAmount\030\005 \001(\rH\003\210\001\001B\017\n\r_m" +
      "inimalPriceB\017\n\r_maximalPriceB\031\n\027_minimal" +
      "AvailableAmountB\031\n\027_maximalAvailableAmou" +
      "nt\"\266\001\n\005Offer\022\020\n\010offer_id\030\001 \001(\005\022\r\n\005title\030" +
      "\002 \001(\t\022%\n\010category\030\003 \001(\0162\023.streaming.Cate" +
      "gory\022\023\n\013description\030\004 \001(\t\022\032\n\022price_integ" +
      "er_part\030\005 \001(\r\022\032\n\022price_decimal_part\030\006 \001(" +
      "\r\022\030\n\020available_amount\030\007 \001(\r\"p\n\031CreateSub" +
      "scriptionRequest\022\017\n\007user_id\030\001 \001(\r\0221\n\014off" +
      "er_filter\030\002 \001(\0132\026.streaming.OfferFilterH" +
      "\000\210\001\001B\017\n\r_offer_filter\"F\n\032CreateSubscript" +
      "ionResponse\022\017\n\007user_id\030\001 \001(\r\022\027\n\017subscrip" +
      "tion_id\030\002 \001(\r\"<\n\020SubscribeRequest\022\017\n\007use" +
      "r_id\030\001 \001(\r\022\027\n\017subscription_id\030\002 \001(\r\"b\n\021S" +
      "ubscribeResponse\022\027\n\017subscription_id\030\001 \001(" +
      "\r\022\023\n\013response_id\030\002 \001(\r\022\037\n\005offer\030\003 \001(\0132\020." +
      "streaming.Offer*V\n\010Category\022\t\n\005FOODS\020\000\022\013" +
      "\n\007CLOTHES\020\001\022\017\n\013ELECTRONICS\020\002\022\016\n\nAPPLIANC" +
      "ES\020\003\022\021\n\rMISCELLANEOUS\020\0042\302\001\n\017OfferObserva" +
      "ble\022c\n\022CreateSubscription\022$.streaming.Cr" +
      "eateSubscriptionRequest\032%.streaming.Crea" +
      "teSubscriptionResponse\"\000\022J\n\tSubscribe\022\033." +
      "streaming.SubscribeRequest\032\034.streaming.S" +
      "ubscribeResponse\"\0000\001B!\n\013sr.grpc.genB\020Sub" +
      "scribingProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_streaming_OfferFilter_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_streaming_OfferFilter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_streaming_OfferFilter_descriptor,
        new java.lang.String[] { "Categories", "MinimalPrice", "MaximalPrice", "MinimalAvailableAmount", "MaximalAvailableAmount", });
    internal_static_streaming_Offer_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_streaming_Offer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_streaming_Offer_descriptor,
        new java.lang.String[] { "OfferId", "Title", "Category", "Description", "PriceIntegerPart", "PriceDecimalPart", "AvailableAmount", });
    internal_static_streaming_CreateSubscriptionRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_streaming_CreateSubscriptionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_streaming_CreateSubscriptionRequest_descriptor,
        new java.lang.String[] { "UserId", "OfferFilter", });
    internal_static_streaming_CreateSubscriptionResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_streaming_CreateSubscriptionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_streaming_CreateSubscriptionResponse_descriptor,
        new java.lang.String[] { "UserId", "SubscriptionId", });
    internal_static_streaming_SubscribeRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_streaming_SubscribeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_streaming_SubscribeRequest_descriptor,
        new java.lang.String[] { "UserId", "SubscriptionId", });
    internal_static_streaming_SubscribeResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_streaming_SubscribeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_streaming_SubscribeResponse_descriptor,
        new java.lang.String[] { "SubscriptionId", "ResponseId", "Offer", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}