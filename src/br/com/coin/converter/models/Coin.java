package br.com.coin.converter.models;

import br.com.coin.converter.records.ExchangeRateObj;

import java.util.Map;

public class Coin {
    private String lastUpdate;
    private String coinCode;
    private Map<String, Double> coinConvertions;

    public Coin(ExchangeRateObj apiObject) {
        this.lastUpdate = apiObject.time_last_update_utc();
        this.coinCode = apiObject.base_code();
        this.coinConvertions = apiObject.conversion_rates();
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public Map<String, Double> getCoinConvertions() {
        return coinConvertions;
    }

    public double convertion(double value, String convert) {
        var selectedKey = this.getCoinConvertions().get(convert);

        return value * selectedKey;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "lastUpdate='" + lastUpdate + '\'' +
                ", coinCode='" + coinCode + '\'' +
                ", coinConvertions=" + coinConvertions +
                '}';
    }
}
