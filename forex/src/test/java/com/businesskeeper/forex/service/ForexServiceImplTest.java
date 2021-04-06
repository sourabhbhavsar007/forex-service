package com.businesskeeper.forex.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.businesskeeper.forex.model.ExchangeResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "36000")
public class ForexServiceImplTest {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void getAllCurrencies() {
		FluxExchangeResult<ExchangeResponse> result = webTestClient.get()
				.uri("http://api.exchangeratesapi.io/v1/latest?access_key=66dd3cde076e1bbe28740dc72259e138")
				.accept(MediaType.TEXT_EVENT_STREAM).exchange().expectStatus().isOk()
				.returnResult(ExchangeResponse.class);
	}
}
