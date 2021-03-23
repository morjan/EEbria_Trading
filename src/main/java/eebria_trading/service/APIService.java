package eebria_trading.service;

import eebria_trading.entity.Drink;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface APIService {
    List getData() throws IOException, InterruptedException;

    List<Drink> mapDrinkLIst(List<Map> drinkMapList);
}
