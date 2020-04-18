package br.com.cedran.application.sales.queries.detail;

import java.util.UUID;

public interface GetSaleDetails {

    SaleDetailsModel execute(UUID id);
}
