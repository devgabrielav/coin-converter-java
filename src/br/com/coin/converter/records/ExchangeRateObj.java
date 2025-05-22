package br.com.coin.converter.records;

import java.util.Map;

public record ExchangeRateObj(String result, String time_last_update_utc, String base_code, Map<String, Double> conversion_rates) {
}
