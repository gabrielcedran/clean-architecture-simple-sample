package br.com.cedran.application.interfaces;

import br.com.cedran.domain.customers.Customer;
import br.com.cedran.domain.products.Product;
import br.com.cedran.domain.employees.Employee;
import br.com.cedran.domain.sales.Sale;

import java.util.List;
import java.util.UUID;
// From business perspective at application level, does it matter if it a database or something else?
// It is even a violation of the Interface Segregation Principle and Single Responsibility Principle
// For the sake of simplicity, it will be kept like this
public interface DatabaseService {

    Customer obtainCustomerById(UUID id);
    Employee obtainEmployeeById(UUID id);
    Product obtainProductById(UUID id);
    Sale obtainSaleById(UUID id);
    Sale saveSale(Sale sale);
    List<Sale> getAllSales();

}
