package br.com.content4devs.util;

import br.com.content4devs.Domain.Product;
import br.com.content4devs.dto.Product_InputDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductConverterUtilTest {
    @Test
    public void productToProductOutputDtoTest(){
        var product = new Product(1L,"product name",10.00,10);
        var productOutputDto = ProductConverterUtil.productToProductOutputDto(product);

//nao eh o do jupter
        //Vai comparar um campo com outro usando recursao
        Assertions.assertThat(product).usingRecursiveComparison().isEqualTo(productOutputDto);

    }

    @Test
    public void productInputProductTest(){
        var productInput = new Product_InputDto("product name",10.00,10);
        var product = ProductConverterUtil.productImputDtoToProduct(productInput);


        Assertions.assertThat(productInput).usingRecursiveComparison().isEqualTo(product);

    }

}
