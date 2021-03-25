package eebria_trading.service;

import eebria_trading.entity.Drink;
import eebria_trading.entity.DrinkType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DataServiceImpl implements DataService {
    private static List<Drink> drinkList;


    public DataServiceImpl(ApplicationContext applicationContext) {
        DataServiceImpl.drinkList = (List<Drink>) applicationContext.getBean("drinkList");
    }

    @Override
    public List<Drink> getAllProducts() {
        return drinkList;
    }

    @Override
    public List<Drink> getProductsByIds(List<Long> drinkIds) {
        return drinkList.stream()
                .filter(drink -> drinkIds.contains(drink.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Drink> getProductsByType(String type) {
        return drinkList
                .stream()
                .filter(drink -> drink.getType().equals(DrinkType.valueOf(type))).collect(Collectors.toList());
    }

    @Override
    public Drink getCheaperProduct(List<Drink> drinks) {
        return drinks
                .stream()
                .min(Comparator.comparing(Drink::getPrice))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Drink getExpensiveProduct(List<Drink> drinks) {
        return drinks
                .stream()
                .max(Comparator.comparing(Drink::getPrice))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Drink> sortProductsByPriceAscending(List<Drink> drinks) {
        return drinks
                .stream()
                .sorted(Comparator.comparing(Drink::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Drink> sortProductsByPriceDescending(List<Drink> drinks) {
        return drinks
                .stream()
                .sorted(Comparator.comparing(Drink::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Drink> sortProductsByNameAscending(List<Drink> drinks) {
        return drinks
                .stream()
                .sorted(Comparator.comparing(Drink::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Drink> sortProductsByNameDescending(List<Drink> drinks) {
        return drinks
                .stream()
                .sorted(Comparator.comparing(Drink::getName).reversed())
                .collect(Collectors.toList());
    }
}
