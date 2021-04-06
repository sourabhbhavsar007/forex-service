package com.businesskeeper.forex.service;

import reactor.core.publisher.Mono;

public interface ForexService {

	Mono<Object> fetchExchangeRates(String apiKey, String date, String baseCurrency, String targetCurrency);

	Mono<Object> fetchAllExchangeRates(String accessKey);

}
