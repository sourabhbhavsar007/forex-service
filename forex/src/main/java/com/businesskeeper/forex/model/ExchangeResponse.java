package com.businesskeeper.forex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeResponse {

	@JsonProperty("result")
	private String result;
	
	@JsonProperty("base")
	private String base;
	
	@JsonProperty("date")
	private String date;

	//@JsonProperty("rates")
	//private List<String> rates;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
