package br.com.content4devs.service.impl;

import br.com.content4devs.Domain.Product;
import br.com.content4devs.Repository.ProductRepository;
import br.com.content4devs.dto.ProductOutputDto;
import br.com.content4devs.dto.Product_InputDto;
import br.com.content4devs.service.IProductService;
import br.com.content4devs.util.ProductConverterUtil;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductOutputDto create(Product_InputDto inputDto) {
        var product = ProductConverterUtil.productImputDtoToProduct(inputDto);
        var productCreate = this.productRepository.save(product);

        return ProductConverterUtil.productToProductOutputDto(productCreate);
    }

    @Override
    public ProductOutputDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductOutputDto> findAll() {
        return null;
    }
}
