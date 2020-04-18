package br.com.cedran.persistence.repositories.sales;

import br.com.cedran.domain.sales.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesRepository extends JpaRepository<Sale, UUID> {
}
