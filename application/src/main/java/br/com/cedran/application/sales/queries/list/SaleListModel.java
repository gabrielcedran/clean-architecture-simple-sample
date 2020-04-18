package br.com.cedran.application.sales.queries.list;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Simple DTO - data structure
 */
public class SaleListModel {

    private UUID id;
    private LocalDateTime date;
    private String customerName;
    private String employeeName;
    private String productName;
    private Double unitPrice;
    private Integer quantity;
    private Double totalPrice;

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getProductName() {
        return productName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public static class SaleListModelBuilder {
        private SaleListModel saleListModel = new SaleListModel();

        public SaleListModelBuilder id(UUID id) {
            saleListModel.id = id;
            return this;
        }

        public SaleListModelBuilder date(LocalDateTime date) {
            saleListModel.date = date;
            return this;
        }

        public SaleListModelBuilder customerName(String customerName) {
            saleListModel.customerName = customerName;
            return this;
        }

        public SaleListModelBuilder employeeName(String employeeName) {
            saleListModel.employeeName = employeeName;
            return this;
        }

        public SaleListModelBuilder productName(String productName) {
            saleListModel.productName = productName;
            return this;
        }

        public SaleListModelBuilder unitPrice(Double unitPrice) {
            saleListModel.unitPrice = unitPrice;
            return this;
        }

        public SaleListModelBuilder quantity(Integer quantity) {
            saleListModel.quantity = quantity;
            return this;
        }

        public SaleListModelBuilder totalPrice(Double totalPrice) {
            saleListModel.totalPrice = totalPrice;
            return this;
        }

        public SaleListModel build() {
            return saleListModel;
        }
    }
}
