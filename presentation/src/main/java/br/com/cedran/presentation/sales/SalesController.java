package br.com.cedran.presentation.sales;

import br.com.cedran.application.sales.commands.create.CreateSale;
import br.com.cedran.application.sales.commands.create.CreateSaleModel;
import br.com.cedran.domain.sales.Sale;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private CreateSale createSale;

    public SalesController(CreateSale createSale) {
        this.createSale = createSale;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Sale create(@RequestBody CreateSaleModel createSaleModel) {
        return createSale.execute(createSaleModel);
    }

}
