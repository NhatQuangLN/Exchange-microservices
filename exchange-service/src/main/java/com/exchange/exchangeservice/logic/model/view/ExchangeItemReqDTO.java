package com.exchange.exchangeservice.logic.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeItemReqDTO {

	public String productIdFrom;

	public String productIdTo;

}
