package br.com.cedran.presentation.sales;

import br.com.cedran.application.sales.commands.create.CreateSale;
import br.com.cedran.application.sales.commands.create.CreateSaleModel;
import br.com.cedran.application.sales.queries.detail.GetSaleDetails;
import br.com.cedran.application.sales.queries.detail.SaleDetailsModel;
import br.com.cedran.application.sales.queries.list.GetSales;
import br.com.cedran.application.sales.queries.list.SaleListModel;
import br.com.cedran.domain.sales.Sale;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private CreateSale createSale;
    private GetSales getSales;
    private GetSaleDetails getSaleDetails;

    public SalesController(CreateSale createSale, GetSales getSales, GetSaleDetails getSaleDetails) {
        this.createSale = createSale;
        this.getSales = getSales;
        this.getSaleDetails = getSaleDetails;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Sale create(@RequestBody CreateSaleModel createSaleModel) {
        return createSale.execute(createSaleModel);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SaleListModel> list() {
        return getSales.execute();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SaleDetailsModel details(@PathVariable UUID id) {
        return getSaleDetails.execute(id);
    }

}
