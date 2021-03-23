package eebria_trading.service;

import com.google.gson.Gson;
import eebria_trading.entity.Drink;
import eebria_trading.entity.DrinkType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class APIServiceImpl implements APIService {

    @Override
    public List<Drink> getData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.eebria.com/"))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        List<Map> drinkMapList = new Gson().fromJson(response.body(), List.class);

        return mapDrinkLIst(drinkMapList);
    }

    @Override
    public List<Drink> mapDrinkLIst(List<Map> drinkMapList) {
        List<Drink> drinkList = new ArrayList<>();

        drinkMapList.forEach(drink -> drinkList
                .add(new Drink((String)drink.get("name"),
                        (String) drink.get("image"),
                        DrinkType.valueOf((String) drink.get("style")),
                        (Double) drink.get("price"))));

        return drinkList;
    }
}
