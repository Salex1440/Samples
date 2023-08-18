package com.salex.grpc.client;

import com.salex.grpc.HelloRequest;
import com.salex.grpc.HelloResponse;
import com.salex.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Salex")
                .setLastName("gRPC")
                .build());

        System.out.println(helloResponse.getGreeting());
        channel.shutdown();
    }
}
