package com.businesskeeper.forex.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.businesskeeper.forex.service.ForexService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/exchange-rate")
public class ForexController {
	
	private ForexService forexService;
    private Environment env;
    private static final Logger logger = LoggerFactory.getLogger(ForexController.class);
    
    
    @Autowired
    public ForexController(ForexService forexService, Environment env) {
		super();
		this.forexService = forexService;
		this.env = env;
	}
    
    /**
     * This is our main API which passes date and base and target currency to fetch exchange rates from api.exchangerates.io 
     * 
     * We use WebClient to call exchange rates API. 
     * 
     *  From Postman, we call localhost:8080/api/exchange-rate/2020-03-03/INR/USD and after processing, 
     *  we use web client to call external API.
     *  
     *  The web client API can be seen in logs : 
     *  http://api.exchangeratesapi.io/v1/convert?access_key=66dd3cde076e1bbe28740dc72259e138&from=INR&to=USD&amount=1&date=2020-03-03
     *
     *	However, since I use free and trial version of exchangerates.io, they have restricted this 
     *  request and we get response as 403 Forbidden access.
     *
     *
     *
     * @param date
     * @param baseCurrency
     * @param targetCurrency
     * @return
     * @throws ParseException
     */
	
    @GetMapping("/{date}/{baseCurrency}/{targetCurrency}")
	public Mono<Object> displayExchangeRates(@PathVariable String date, @PathVariable String baseCurrency, @PathVariable String targetCurrency) throws ParseException {
    
    	logger.info("Getting access key and calling ForexService...");
    	String accessKey = env.getProperty("app.api.key");
    	
    	return forexService.fetchExchangeRates(accessKey, date, baseCurrency, targetCurrency);
    	
	}
    
    /**
     * This API is only accessible to trial users, so we will use this and display all exchange rates with base as Euro.
     * 
     * 
     * @param date
     * @param baseCurrency
     * @param targetCurrency
     * @return
     * @throws ParseException
     */
    
    @GetMapping("/getAllCurrencies")
	public Mono<Object> displayAllExchangeRates(){
    
    	logger.info("Getting access key and calling ForexService...");
    	String accessKey = env.getProperty("app.api.key");
    	
    	return forexService.fetchAllExchangeRates(accessKey);
    	
	}
	
}
