package br.com.content4devs.Resources;

import br.com.content4devs.ProductRequest;
import br.com.content4devs.ProductResponse;
import br.com.content4devs.ProductServiceGrpc;
import br.com.content4devs.dto.ProductOutputDto;
import br.com.content4devs.dto.Product_InputDto;
import br.com.content4devs.service.IProductService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductResource extends ProductServiceGrpc.ProductServiceImplBase {

// criei uma instancia da product service
//criei um contrutor sobre este parametro o spring cuida
    private  final IProductService productService;

    public ProductResource(IProductService productService) {
        this.productService = productService;
    }


    @Override
    public void create(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
     //implementar a logica que vai enviar as informaoes para camada de servico
//o nome  o preco e a quantidade estao vindo pela request

    Product_InputDto inputDto =   new Product_InputDto(
        request.getName(),
        request.getPrice(),
        request.getQuantityInStock()
        );
    ProductOutputDto outputDto = this.productService.create(inputDto);
    ProductResponse  response = ProductResponse.newBuilder()
            .setId(outputDto.getId())
            .setName(outputDto.getName())
            .setQuantityInStock(outputDto.getQuantityInStock())
            .build();


    responseObserver.onNext(response);
    responseObserver.onCompleted();
    }
}
