package br.com.coin.converter.models;

import br.com.coin.converter.records.ExchangeRateObj;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiSearch {
    public Coin getCoinInfo(String base) {
        try {
            String apiKey = "SUA_CHAVE_DA_API_AQUI";
            URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + base);
            Gson gson = new GsonBuilder().create();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            ExchangeRateObj apiObject = gson.fromJson(json, ExchangeRateObj.class);

            return new Coin(apiObject);
        } catch (RuntimeException | IOException | InterruptedException error) {
            System.out.println(error.getMessage());
            throw new RuntimeException(error);
        }
    }
}
