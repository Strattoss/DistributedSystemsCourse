/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package sr.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import sr.grpc.gen.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class grpcClient 
{
	private final ManagedChannel channel;

	private final OptionalResearchServantGrpc.OptionalResearchServantBlockingStub stub;

	/** Construct client connecting to HelloWorld server at {@code host:port}. */
	public grpcClient(String remoteHost, int remotePort) 
	{
		channel = ManagedChannelBuilder.forAddress(remoteHost, remotePort)
				.usePlaintext()
				.build();

		stub = OptionalResearchServantGrpc.newBlockingStub(channel);
	}
	
	

	public static void main(String[] args) throws Exception 
	{
		grpcClient client = new grpcClient("127.0.0.5", 50051);
		client.test();
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}


	public void test() throws InterruptedException
	{
		String line = null;
		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

		do {
			try {
				System.out.print("==> ");
				System.out.flush();
				line = in.readLine();
				switch (line) {
					case "empty-both": {
						sendEmptyParamsAndReturn();
						break;
					}


					case "data-all-full": {
						sendDataWithAllFieldsFull();
						break;
					}
					case "data-all-empty": {
						sendDataWithAllFieldsEmpty();
						break;
					}


					case "data-repeated-all-full": {
						sendDataRepeatedWithAllFieldsFull();
						break;
					}
					case "data-repeated-all-empty": {
						sendDataRepeatedWithAllFieldsEmpty();
						break;
					}


					case "data-one-of-int": {
						sendDataOneofWithInt();
						break;
					}
					case "data-one-of-unset": {
						sendDataOneofWithUnsetValue();
						break;
					}
					case "data-one-of-empty": {
						sendDataOneofWithEmptyValue();
						break;
					}


					case "data-inexpl-empty": {
						sendInexplicitlyOptionalEmptyData();
						break;
					}
					case "data-inexpl-unset": {
						sendInexplicitlyOptionalUnsetData();
						break;
					}
					case "data-expl-empty": {
						sendExplicitlyOptionalEmptyData();
						break;
					}
					case "data-expl-unset": {
						sendExplicitlyOptionalUnsetData();
						break;
					}


					case "all": {
						sendEmptyParamsAndReturn();

						sendDataWithAllFieldsFull();
						sendDataWithAllFieldsEmpty();

						sendDataRepeatedWithAllFieldsFull();
						sendDataRepeatedWithAllFieldsEmpty();

						sendDataOneofWithInt();
						sendDataOneofWithEmptyValue();
						sendDataOneofWithUnsetValue();

						sendInexplicitlyOptionalEmptyData();
						sendInexplicitlyOptionalUnsetData();
						sendExplicitlyOptionalEmptyData();
						sendExplicitlyOptionalUnsetData();
						break;
					}
					case "x":
					case "":
						break;
					default:
						System.out.println("???");
						break;
				}
			} catch (java.io.IOException ex) {
				System.err.println(ex);
			}
		} while (!line.equals("x"));
		
		shutdown();
	}

	private void sendEmptyParamsAndReturn() {
		var request = Empty.newBuilder().build();
		var response = stub.sendWithEmptyAll(request);
	}

	private void sendDataWithAllFieldsFull() {
		var request = Data.newBuilder()
				.setInt32(10)
				.setData(Data.newBuilder().setInt32(20).build())
				.build();
		var response = stub.sendData(request);
	}

	private void sendDataWithAllFieldsEmpty() {
		var request = Data.newBuilder().build();
		var response = stub.sendData(request);
	}

	private void sendDataRepeatedWithAllFieldsFull() {
		var request = DataRepeated.newBuilder()
				.addAllInts32(List.of(1, 2, 3))
				.addData(Data.newBuilder().setInt32(10).build())
				.build();
		var response = stub.sendDataRepeated(request);
	}

	private void sendDataRepeatedWithAllFieldsEmpty() {
		var request = DataRepeated.newBuilder()
				.addAllInts32(List.of())
				.addAllData(List.of())
				.build();
		var response = stub.sendDataRepeated(request);
	}

	private void sendDataOneofWithInt() {
		var request = DataOneOf.newBuilder().setInt32(10).build();
		var response = stub.sendDataOneOf(request);
		System.out.println("sendDataOneofWithInt");
		System.out.println("response.hasInt32(): " + response.hasInt32());
		System.out.println("response.hasData(): " + response.hasData());
		System.out.println("response.hasEmpty(): " + response.hasEmpty());
		System.out.println();
	}

	private void sendDataOneofWithEmptyValue() {
		var request = DataOneOf.newBuilder().setEmpty(Empty.newBuilder().build()).build();
		var response = stub.sendDataOneOf(request);
		System.out.println("sendDataOneofWithEmptyValue");
		System.out.println("response.hasInt32(): " + response.hasInt32());
		System.out.println("response.hasData(): " + response.hasData());
		System.out.println("response.hasEmpty(): " + response.hasEmpty());
		System.out.println();
	}

	private void sendDataOneofWithUnsetValue() {
		var request = DataOneOf.newBuilder().build();
		var response = stub.sendDataOneOf(request);
		System.out.println("sendDataOneofWithUnsetValue");
		System.out.println("response.hasInt32(): " + response.hasInt32());
		System.out.println("response.hasData(): " + response.hasData());
		System.out.println("response.hasEmpty(): " + response.hasEmpty());
		System.out.println();
	}

	private void sendInexplicitlyOptionalEmptyData() {
		var request = Data.newBuilder().setInt32(0).setData(Data.getDefaultInstance()).build();
		var response = stub.sendData(request);
		// there is no hasPrimitive method for primitive types
		System.out.println("sendInexplicitlyOptionalEmptyData");
		System.out.println("response.hasInt32(): doesn't exist for implicitly optional");		// there is no hasPrimitive method for primitive types
		System.out.println("response.hasData(): " + response.hasData());
		System.out.println();
	}

	private void sendInexplicitlyOptionalUnsetData() {
		var request = Data.newBuilder().build();
		var response = stub.sendData(request);
		System.out.println("sendInexplicitlyOptionalUnsetData");
		System.out.println("response.hasInt32(): doesn't exist for implicitly optional");	// there is no hasPrimitive method for primitive types
		System.out.println("response.hasData(): " + response.hasData());
		System.out.println();
	}

	private void sendExplicitlyOptionalEmptyData() {
		var request = DataExplicitlyOptional.newBuilder().setInt32(0).setData(Data.getDefaultInstance()).build();
		var response = stub.sendDataExplicitlyOptional(request);
		System.out.println("sendExplicitlyOptionalEmptyData");
		System.out.println("response.hasInt32(): " + response.hasInt32());
		System.out.println("response.hasData(): " + response.hasData());
		System.out.println();
	}

	private void sendExplicitlyOptionalUnsetData() {
		var request = DataExplicitlyOptional.newBuilder().build();
		var response = stub.sendDataExplicitlyOptional(request);
		System.out.println("sendExplicitlyOptionalUnsetData");
		System.out.println("response.hasInt32(): " + response.hasInt32());
		System.out.println("response.hasData(): " + response.hasData());
		System.out.println();
	}

}
