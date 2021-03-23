package eebria_trading.controller;

import eebria_trading.entity.Drink;
import eebria_trading.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EebriaController {
    @Autowired
    DataService dataService;

    @GetMapping(value = "/products", produces = "application/json")
    public List<Drink> getAllProducts() {
        return dataService.getAllProducts();
    }

    @GetMapping(value = "/productsByType", produces = "application/json")
    public List<Drink> getAllProductsByType() {
        return dataService.getProductsByType("cider");
    }

    @GetMapping(value = "/cheaperProduct", produces = "application/json")
    public Drink getCheaperProduct() {
        return dataService.getCheaperProduct();
    }

    @GetMapping(value = "/expensiveProduct", produces = "application/json")
    public Drink getExpensiveProduct() {
        return dataService.getExpensiveProduct();
    }

    @GetMapping(value = "/sortProductsByPriceAscending", produces = "application/json")
    public List<Drink> sortProductsByPriceAscending() {
        return dataService.sortProductsByPriceAscending();
    }

    @GetMapping(value = "/sortProductsByPriceDescending", produces = "application/json")
    public List<Drink> sortProductsByPriceDescending() {
        return dataService.sortProductsByPriceDescending();
    }

    @GetMapping(value = "sortProductsByNameAscending", produces = "application/json")
    public List<Drink> sortProductsByNameAscending() {
        return dataService.sortProductsByNameAscending();
    }

    @GetMapping(value = "sortProductsByNameDescending", produces = "application/json")
    public List<Drink> sortProductsByNameDescending() {
        return dataService.sortProductsByNameDescending();
    }
}
