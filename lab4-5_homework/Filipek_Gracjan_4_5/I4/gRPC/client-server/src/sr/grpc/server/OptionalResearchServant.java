package sr.grpc.server;

import io.grpc.stub.StreamObserver;
import sr.grpc.gen.*;
import sr.grpc.gen.OptionalResearchServantGrpc.OptionalResearchServantImplBase;

public class OptionalResearchServant extends OptionalResearchServantImplBase
{
	@Override
public void sendWithEmptyParameter(Empty request, StreamObserver<Data> responseObserver) {
	responseObserver.onNext(Data.newBuilder().build());
	responseObserver.onCompleted();
}

	@Override
	public void sendWithEmptyReturn(Data request, StreamObserver<Empty> responseObserver) {
		responseObserver.onNext(Empty.getDefaultInstance());
		responseObserver.onCompleted();
	}

	@Override
	public void sendWithEmptyAll(Empty request, StreamObserver<Empty> responseObserver) {
		responseObserver.onNext(request);
		responseObserver.onCompleted();
	}

	@Override
	public void sendData(Data request, StreamObserver<Data> responseObserver) {
		responseObserver.onNext(request);
		responseObserver.onCompleted();
	}

	@Override
	public void sendDataRepeated(DataRepeated request, StreamObserver<DataRepeated> responseObserver) {
		responseObserver.onNext(request);
		responseObserver.onCompleted();
	}

	@Override
	public void sendDataExplicitlyOptional(DataExplicitlyOptional request, StreamObserver<DataExplicitlyOptional> responseObserver) {
		responseObserver.onNext(request);
		responseObserver.onCompleted();
	}

	@Override
	public void sendDataOneOf(DataOneOf request, StreamObserver<DataOneOf> responseObserver) {
		responseObserver.onNext(request);
		responseObserver.onCompleted();
	}
}
