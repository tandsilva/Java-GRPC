package br.com.content4devs.util;

import br.com.content4devs.Domain.Product;
import br.com.content4devs.dto.ProductOutputDto;
import br.com.content4devs.dto.Product_InputDto;


public class ProductConverterUtil {

    //vai pegar o retorno da minha classe de repository e tranformar em uma saida DTO
    public static ProductOutputDto productToProductOutputDto(Product product){
    return  new ProductOutputDto(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getQuantityInStock()
    );
    }
    public static Product  productImputDtoToProduct(Product_InputDto product){
        return  new Product(
                 null,
                product.getName(),
                product.getPrice(),
                product.getQuantityInStock()
        );
    }


}
