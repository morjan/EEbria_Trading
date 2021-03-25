package eebria_trading.service;

import eebria_trading.entity.Drink;

import java.util.List;

public interface DataService {
    List<Drink> getAllProducts();
    List<Drink> getProductsByIds(List<Long> drinkIds);
    List<Drink> getProductsByType(String type);
    Drink getCheaperProduct(List<Drink> drinks);
    Drink getExpensiveProduct(List<Drink> drinks);

    List<Drink> sortProductsByPriceAscending(List<Drink> drinks);
    List<Drink> sortProductsByPriceDescending(List<Drink> drinks);
    List<Drink> sortProductsByNameAscending(List<Drink> drinks);
    List<Drink> sortProductsByNameDescending(List<Drink> drinks);
}
