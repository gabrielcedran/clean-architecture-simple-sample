package br.com.cedran.application.sales.queries.detail;

import br.com.cedran.application.interfaces.DatabaseService;
import br.com.cedran.application.sales.queries.list.SaleListModel;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class GetSaleDetailsImpl implements GetSaleDetails {

    private DatabaseService databaseService;

    public GetSaleDetailsImpl(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Override
    public SaleDetailsModel execute(UUID id) {
        return Optional.ofNullable(databaseService.obtainSaleById(id))
                .map(sale -> new SaleDetailsModel.SaleDetailsModelBuilder()
                .id(sale.getId())
                .date(sale.getDate())
                .customerName(sale.getCustomer().getName())
                .employeeName(sale.getEmployee().getName())
                .productName(sale.getProduct().getName())
                .quantity(sale.getQuantity())
                .unitPrice(sale.getUnitPrice())
                .totalPrice(sale.getTotalPrice())
                .build())
                .orElseThrow(() -> new EntityNotFoundException());
    }
}
