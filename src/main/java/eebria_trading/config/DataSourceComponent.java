package eebria_trading.config;

import eebria_trading.entity.Drink;
import eebria_trading.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSourceComponent {
    private static List<Drink> drinkList;

    @Autowired
    APIService apiService;

    private DataSourceComponent() {}

    @Bean("drinkList")
    public static List<Drink> getDrinkList() {
        return drinkList;
    }

    @PostConstruct
    public void init() throws IOException, InterruptedException {
        if(drinkList == null) {
            drinkList = new ArrayList();
        }

        drinkList = apiService.getData();
    }
}
