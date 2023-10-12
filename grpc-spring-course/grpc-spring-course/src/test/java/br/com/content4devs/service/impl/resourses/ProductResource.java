package br.com.content4devs.service.impl.resourses;

import br.com.content4devs.ProductRequest;
import br.com.content4devs.ProductResponse;
import br.com.content4devs.ProductServiceGrpc;
import br.com.content4devs.service.impl.ProductServiceImpl;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
//eh equivalente ao rest contoller eh da lib que foi add ao projeto para dar suporte ao grpc no spring vai atender nossas requisições
@GrpcService
public class ProductResource extends ProductServiceGrpc.ProductServiceImplBase {
    @Override
    public void create(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        super.create(request, responseObserver);


    }
}
