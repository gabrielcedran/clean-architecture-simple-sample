package br.com.cedran.persistence.repositories.products;

import br.com.cedran.domain.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Product, UUID> {
}
