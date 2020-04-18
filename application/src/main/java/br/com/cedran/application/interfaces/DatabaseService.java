package br.com.cedran.application.interfaces;

import br.com.cedran.domain.customers.Customer;
import br.com.cedran.domain.products.Product;
import br.com.cedran.domain.employees.Employee;
import br.com.cedran.domain.sales.Sale;

import java.util.UUID;
// From business perspective at application level, does it matter if it a database or something else?
public interface DatabaseService {

    Customer obtainCustomerById(UUID id);
    Employee obtainEmployeeById(UUID id);
    Product obtainProductById(UUID id);
    Sale saveSale(Sale sale);
}
