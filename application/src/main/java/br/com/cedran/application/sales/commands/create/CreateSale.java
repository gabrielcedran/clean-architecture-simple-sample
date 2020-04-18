package br.com.cedran.application.sales.commands.create;

import br.com.cedran.domain.sales.Sale;

public interface CreateSale {

    Sale execute(CreateSaleModel model);
}
