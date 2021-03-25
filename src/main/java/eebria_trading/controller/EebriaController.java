package eebria_trading.controller;

import eebria_trading.entity.Drink;
import eebria_trading.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Drink> getAllProductsByType(@RequestParam String productType) {
        return dataService.getProductsByType(productType);
    }

    @GetMapping(value = "/cheaperProduct", produces = "application/json")
    public Drink getCheaperProduct(@RequestParam List<Long> drinksId) {
        List<Drink> drinks = dataService.getProductsByIds(drinksId);
        return dataService.getCheaperProduct(drinks);
    }

    @GetMapping(value = "/expensiveProduct", produces = "application/json")
    public Drink getExpensiveProduct(@RequestParam List<Long> drinksId) {
        List<Drink> drinks = dataService.getProductsByIds(drinksId);
        return dataService.getExpensiveProduct(drinks);
    }

        @GetMapping(value = "/sortProductsByPriceAscending", produces = "application/json")
    public List<Drink> sortProductsByPriceAscending(@RequestParam List<Long> drinksId) {
        List<Drink> drinks = dataService.getProductsByIds(drinksId);
        return dataService.sortProductsByPriceAscending(drinks);
    }

    @GetMapping(value = "/sortProductsByPriceDescending", produces = "application/json")
    public List<Drink> sortProductsByPriceDescending(@RequestParam List<Long> drinksId) {
        List<Drink> drinks = dataService.getProductsByIds(drinksId);
        return dataService.sortProductsByPriceDescending(drinks);
    }

    @GetMapping(value = "sortProductsByNameAscending", produces = "application/json")
    public List<Drink> sortProductsByNameAscending(@RequestParam List<Long> drinksId) {
        List<Drink> drinks = dataService.getProductsByIds(drinksId);
        return dataService.sortProductsByNameAscending(drinks);
    }

    @GetMapping(value = "sortProductsByNameDescending", produces = "application/json")
    public List<Drink> sortProductsByNameDescending(@RequestParam List<Long> drinksId) {
        List<Drink> drinks = dataService.getProductsByIds(drinksId);
        return dataService.sortProductsByNameDescending(drinks);
    }
}
