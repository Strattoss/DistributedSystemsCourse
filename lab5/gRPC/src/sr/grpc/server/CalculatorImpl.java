package sr.grpc.server;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.StreamObserver;
import sr.grpc.gen.ArithmeticOpResult;
import sr.grpc.gen.CalculatorGrpc.CalculatorImplBase;
import sr.grpc.gen.ErrorResponse;
import sr.grpc.gen.MultiplicationArguments;
import sr.grpc.gen.MultiplicationReturn;

public class CalculatorImpl extends CalculatorImplBase 
{
	@Override
	public void add(sr.grpc.gen.ArithmeticOpArguments request,
			io.grpc.stub.StreamObserver<sr.grpc.gen.ArithmeticOpResult> responseObserver) 
	{
		System.out.println("addRequest (" + request.getArg1() + ", " + request.getArg2() +")");
		int val = request.getArg1() + request.getArg2();
		ArithmeticOpResult result = ArithmeticOpResult.newBuilder().setRes(val).build();
		if(request.getArg1() > 100 && request.getArg2() > 100) try { Thread.sleep(5000); } catch(java.lang.InterruptedException ex) { }
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

	@Override
	public void subtract(sr.grpc.gen.ArithmeticOpArguments request,
			io.grpc.stub.StreamObserver<sr.grpc.gen.ArithmeticOpResult> responseObserver) 
	{
		System.out.println("subtractRequest (" + request.getArg1() + ", " + request.getArg2() +")");
		int val = request.getArg1() - request.getArg2();
		ArithmeticOpResult result = ArithmeticOpResult.newBuilder().setRes(val).build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

	@Override
	public void multiply(MultiplicationArguments request, StreamObserver<MultiplicationReturn> responseObserver) {
		System.out.println("subtractRequest (" + request.getArgsList() + ")");

		var res = request.getArgsList().stream()
				.reduce(((d1, d2) -> d1 * d2));

		if (request.getArgsList().isEmpty() || res.isEmpty()) {
//			Metadata.Key<ErrorResponse> errorResponseKey = ProtoUtils.keyForProto(ErrorResponse.getDefaultInstance());
//			ErrorResponse errorResponse = ErrorResponse.newBuilder().
//					setFaultyParameter("args")
//					.setDescription("Args cannot be empty")
//					.build();
//			Metadata metadata = new Metadata();
//			metadata.put(errorResponseKey, errorResponse);
			responseObserver.onError(Status.FAILED_PRECONDITION.withDescription("Args cannot be an empty list").asRuntimeException());
			return;
		}

		responseObserver.onNext(MultiplicationReturn.newBuilder().setArg(res.get()).build());
		responseObserver.onCompleted();
	}
}
