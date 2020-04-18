package br.com.cedran.application.sales.queries.detail;

import java.time.LocalDateTime;
import java.util.UUID;

public class SaleDetailsModel {
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

    public static class SaleDetailsModelBuilder {
        private SaleDetailsModel saleDetailsModel = new SaleDetailsModel();

        public SaleDetailsModelBuilder id(UUID id) {
            saleDetailsModel.id = id;
            return this;
        }

        public SaleDetailsModelBuilder date(LocalDateTime date) {
            saleDetailsModel.date = date;
            return this;
        }

        public SaleDetailsModelBuilder customerName(String customerName) {
            saleDetailsModel.customerName = customerName;
            return this;
        }

        public SaleDetailsModelBuilder employeeName(String employeeName) {
            saleDetailsModel.employeeName = employeeName;
            return this;
        }

        public SaleDetailsModelBuilder productName(String productName) {
            saleDetailsModel.productName = productName;
            return this;
        }

        public SaleDetailsModelBuilder unitPrice(Double unitPrice) {
            saleDetailsModel.unitPrice = unitPrice;
            return this;
        }

        public SaleDetailsModelBuilder quantity(Integer quantity) {
            saleDetailsModel.quantity = quantity;
            return this;
        }

        public SaleDetailsModelBuilder totalPrice(Double totalPrice) {
            saleDetailsModel.totalPrice = totalPrice;
            return this;
        }

        public SaleDetailsModel build() {
            return saleDetailsModel;
        }
    }
}
