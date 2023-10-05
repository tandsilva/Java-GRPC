package br.com.content4devs.Repository;

import br.com.content4devs.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product ,Long> {
    Optional<Product>findByNameIgnoreCase(String name);


}
