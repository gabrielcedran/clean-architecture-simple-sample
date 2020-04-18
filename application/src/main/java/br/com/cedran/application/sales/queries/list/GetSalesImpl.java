package br.com.cedran.application.sales.queries.list;

import br.com.cedran.application.interfaces.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetSalesImpl implements GetSales {

    private DatabaseService databaseService;

    public GetSalesImpl(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Override
    public List<SaleListModel> execute() {
        return this.databaseService.getAllSales()
                .stream()
                .map(sale -> new SaleListModel.SaleListModelBuilder()
                        .id(sale.getId())
                        .date(sale.getDate())
                        .customerName(sale.getCustomer().getName())
                        .employeeName(sale.getEmployee().getName())
                        .productName(sale.getProduct().getName())
                        .quantity(sale.getQuantity())
                        .unitPrice(sale.getUnitPrice())
                        .totalPrice(sale.getTotalPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
