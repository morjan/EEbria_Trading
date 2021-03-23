package eebria_trading.service;

import eebria_trading.entity.Drink;

import java.util.List;

public interface DataService {
    List<Drink> getAllProducts();
    List<Drink> getProductsByType(String type);
    Drink getCheaperProduct();
    Drink getExpensiveProduct();

    List<Drink> sortProductsByPriceAscending();
    List<Drink> sortProductsByPriceDescending();
    List<Drink> sortProductsByNameAscending();
    List<Drink> sortProductsByNameDescending();
}
