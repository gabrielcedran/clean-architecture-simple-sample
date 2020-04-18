package br.com.cedran.persistence.repositories.customers;

import br.com.cedran.domain.customers.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomersRepository extends JpaRepository<Customer, UUID> {
}
