package br.com.cedran.domain.sales;

import br.com.cedran.domain.common.IEntity;
import br.com.cedran.domain.customers.Customer;
import br.com.cedran.domain.products.Product;
import br.com.cedran.domain.employees.Employee;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sales")
public class Sale implements IEntity<UUID> {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column
    private Integer quantity;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Sale() {

    }
    public UUID getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public static class SaleBuilder {
        private Sale sale = new Sale();

        public SaleBuilder quantity(Integer quantity) {
            sale.quantity = quantity;
            return this;
        }

        public SaleBuilder unitPrice(Double unitPrice) {
            sale.unitPrice = unitPrice;
            return this;
        }

        public SaleBuilder date(LocalDateTime date) {
            sale.date = date;
            return this;
        }

        public SaleBuilder customer(Customer customer) {
            sale.customer = customer;
            return this;
        }

        public SaleBuilder employee(Employee employee) {
            sale.employee = employee;
            return this;
        }

        public SaleBuilder product(Product product) {
            sale.product = product;
            return this;
        }

        public Sale build() {
            checkAllFieldsProvided();
            if (sale.id == null) {
                sale.id = UUID.randomUUID();
            }
            sale.totalPrice = new BigDecimal(sale.quantity).multiply(new BigDecimal(sale.unitPrice)).doubleValue();
            return sale;
        }

        private void checkAllFieldsProvided() {
            checkFieldProvided("quantity");
            checkFieldProvided("unitPrice");
            checkFieldProvided("date");
            checkFieldProvided("customer");
            checkFieldProvided("employee");
            checkFieldProvided("product");
        }

        private void checkFieldProvided(String attributeName) {
            try {
                Field attribute = Sale.class.getDeclaredField(attributeName);
                attribute.setAccessible(true);
                if (attribute.get(sale) == null) {
                    throw new RuntimeException(String.format("%s not provided.", attribute.getName()));
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException("Unexpected exception");
            }
        }
    }
}
