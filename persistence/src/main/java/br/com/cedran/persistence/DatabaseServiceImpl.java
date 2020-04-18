package br.com.cedran.persistence;

import br.com.cedran.application.interfaces.DatabaseService;
import br.com.cedran.domain.customers.Customer;
import br.com.cedran.domain.employees.Employee;
import br.com.cedran.domain.products.Product;
import br.com.cedran.domain.sales.Sale;
import br.com.cedran.persistence.repositories.customers.CustomersRepository;
import br.com.cedran.persistence.repositories.employees.EmployeesRepository;
import br.com.cedran.persistence.repositories.products.ProductsRepository;
import br.com.cedran.persistence.repositories.sales.SalesRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private SalesRepository salesRepository;
    private CustomersRepository customersRepository;
    private EmployeesRepository employeesRepository;
    private ProductsRepository productsRepository;


    public DatabaseServiceImpl(SalesRepository salesRepository, CustomersRepository customersRepository,
                               EmployeesRepository employeesRepository, ProductsRepository productsRepository) {
        this.salesRepository = salesRepository;
        this.customersRepository = customersRepository;
        this.employeesRepository = employeesRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public Customer obtainCustomerById(UUID id) {
        return this.customersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found."));
    }

    @Override
    public Employee obtainEmployeeById(UUID id) {
        return this.employeesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found."));
    }

    @Override
    public Product obtainProductById(UUID id) {
        return this.productsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found."));
    }

    @Override
    public Sale saveSale(Sale sale) {
        return this.salesRepository.save(sale);
    }
}
