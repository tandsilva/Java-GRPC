package br.com.content4devs.service;

import br.com.content4devs.dto.ProductOutputDto;
import br.com.content4devs.dto.Product_InputDto;

import java.util.List;

public interface IProductService {
    ProductOutputDto create (Product_InputDto inputDto);
    ProductOutputDto findById (Long id);

    void delete (Long id);
List<ProductOutputDto> findAll();

}
