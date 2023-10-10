package br.com.content4devs.service.impl;

import br.com.content4devs.Domain.Product;
import br.com.content4devs.Repository.ProductRepository;
import br.com.content4devs.dto.ProductOutputDto;
import br.com.content4devs.dto.Product_InputDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {


    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;



    @Test
    @DisplayName("Quando o create product service eh chamado uma data valida do produto eh chamada ")

    public void createProductSuccessTest(){

             Product product = new Product(1l,"product name chapeu",11.00,11);
//foi adicionado um import statico para retirar o mokito que estava exposto
        when(productRepository.save(any())).thenReturn(product);
     Product_InputDto inputDto =  new Product_InputDto("product name chapeu",11.00,11);
       ProductOutputDto outputDto = productService.create(inputDto);

        assertThat(outputDto).usingRecursiveComparison().isEqualTo(product);
        //pegar a saida do product service ela deve ser igual ao product , porque o product eh o retorno mocado do repository
        //no momento que eu estiver salvando um produto vai pegar exatamente o retorno do repository ,a unica diferenca eh que no input nao tem id

    }

}
