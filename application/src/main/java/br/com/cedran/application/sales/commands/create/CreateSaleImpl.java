package br.com.cedran.application.sales.commands.create;

import br.com.cedran.application.interfaces.DatabaseService;
import br.com.cedran.application.interfaces.InventoryService;
import br.com.cedran.application.interfaces.SalesFactory;
import br.com.cedran.domain.sales.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class CreateSaleImpl implements CreateSale {

    private DatabaseService databaseService;
    private SalesFactory salesFactory;
    private InventoryService inventoryService;

    public CreateSaleImpl(DatabaseService databaseService,
                          @Autowired(required = false) SalesFactory salesFactory,
                          @Autowired(required = false) InventoryService inventoryService) {
        this.databaseService = databaseService;
        this.salesFactory = salesFactory;
        this.inventoryService = inventoryService;
    }

    @Override
    public Sale execute(CreateSaleModel model) {

        var date = LocalDateTime.now();
        var customer = databaseService.obtainCustomerById(model.getCustomerId());
        var employee = databaseService.obtainEmployeeById(model.getEmployeeId());
        var product = databaseService.obtainProductById(model.getProductId());
        var quantity = model.getQuantity();
        var sale = new Sale.SaleBuilder()
                .date(date)
                .customer(customer)
                .employee(employee)
                .product(product)
                .quantity(quantity)
                .unitPrice(product.getPrice())
                .build();
        sale = databaseService.saveSale(sale);
        // notify inventory
        return sale;
    }
}
