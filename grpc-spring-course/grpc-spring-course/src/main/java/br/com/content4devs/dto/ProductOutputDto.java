package br.com.content4devs.dto;

public class ProductOutputDto {
    private final Long id;

    private final String name;
    private final Double price;
    private final Integer quantityInStock;

    public ProductOutputDto(Long id, String name, Double price, Integer quantityInStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public Long getId() {
        return id;
    }
}
