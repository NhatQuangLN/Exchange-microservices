package com.exchange.exchangeservice.logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.exchangeservice.logic.model.view.ExchangeItemReqDTO;
import com.exchange.exchangeservice.logic.model.view.ExchangeItemResDTO;
import com.exchange.exchangeservice.logic.service.ExchangeService;

@RestController
public class ExchangeController {

	@Autowired
	private ExchangeService exchangeService;

	@PostMapping("/api/exchange-item")
	public ExchangeItemResDTO exchangeItem(@RequestBody ExchangeItemReqDTO exchangeItemReqDTO) {
		boolean isExistFrom = exchangeService.checkExistProduct(exchangeItemReqDTO.productIdFrom);

		if (!isExistFrom) {
			return ExchangeItemResDTO.builder().build();
		}

		boolean isExistTo = exchangeService.checkExistProduct(exchangeItemReqDTO.productIdTo);

		if (!isExistTo) {
			return ExchangeItemResDTO.builder().build();
		}

		String exchangeId = exchangeService.exchangeService(exchangeItemReqDTO);

		return ExchangeItemResDTO.builder().exchangeId(exchangeId).build();
	}
}
