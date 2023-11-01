package br.com.content4devs.resources;

import br.com.content4devs.ProductRequest;
import br.com.content4devs.ProductResponse;
import br.com.content4devs.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:applicationTest.properties")//esta chamando a configuracao do bnco aqui h2
@DirtiesContext//para evitar problemas de portas locadas no teste
public class ProductResourceIntregationTest {

// soh eh possivel sdevido ao importe no pom Din jarin  (lembra)
@GrpcClient("inProcess")
//vai realizar chamadas blocantes
    private ProductServiceGrpc.ProductServiceBlockingStub serviceBlockingStub;

@Test
@DisplayName("Se a data for valida um produto eh criado")
    public  void  createProductSucessTest(){
    //o metodo create precisa receber um product request


   ProductRequest productRequest = ProductRequest.newBuilder()
            .setName("product name")
                    .setPrice(10.00)
                    .setQuantityInStock(100)
                    .build();



         ProductResponse productResponse = serviceBlockingStub.create(productRequest);
         //os nomes que estao sendo chamados aqui são os nomes do  arquivo protp
        Assertions.assertThat(productRequest).usingRecursiveComparison().comparingOnlyFields("name","price","quantity_in_stock")
            .isEqualTo(productResponse);


}

}
