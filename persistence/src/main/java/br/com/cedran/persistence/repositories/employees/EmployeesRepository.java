package br.com.cedran.persistence.repositories.employees;

import br.com.cedran.domain.employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeesRepository extends JpaRepository<Employee, UUID> {
}
