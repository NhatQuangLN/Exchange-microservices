package com.exchange.exchangeservice.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.exchange.exchangeservice.logic.model.db.Exchange;
import com.exchange.exchangeservice.logic.model.view.ExchangeItemReqDTO;
import com.exchange.exchangeservice.logic.model.view.product.CheckProductExistReqDTO;
import com.exchange.exchangeservice.logic.model.view.product.CheckProductExistResDTO;
import com.exchange.exchangeservice.logic.repository.ExchangeRepository;
import com.exchange.exchangeservice.utils.SystemCode;

import reactor.core.publisher.Mono;

@Service
public class ExchangeService {
	@Autowired
	private ExchangeRepository exchangeRepository;

	@Autowired
	private WebClient.Builder webClientBuilder;

	public String exchangeService(ExchangeItemReqDTO exchangeItemReqDTO) {
		Exchange exchange = Exchange.builder().productIdFrom(exchangeItemReqDTO.productIdFrom)
				.productIdTo(exchangeItemReqDTO.productIdTo).status(SystemCode.REQUEST_EXCHANGE).build();

		exchangeRepository.save(exchange);

		return exchange.getExchangeId();
	}

	public boolean checkExistProduct(String productId) {
		CheckProductExistReqDTO checkProductExistReqDTO = new CheckProductExistReqDTO();
		checkProductExistReqDTO.productId = productId;

		CheckProductExistResDTO resObject = webClientBuilder.build().post()
				.uri("http://product-service/api/product-check").contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(checkProductExistReqDTO), CheckProductExistReqDTO.class).retrieve()
				.bodyToMono(CheckProductExistResDTO.class).block();

		return resObject.data.isExisted;

	}

}
