package br.com.cedran.application.sales.commands.create;

import java.util.UUID;

public class CreateSaleModel {

    private UUID customerId;
    private UUID employeeId;
    private UUID productId;
    private Integer quantity;

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public UUID getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
