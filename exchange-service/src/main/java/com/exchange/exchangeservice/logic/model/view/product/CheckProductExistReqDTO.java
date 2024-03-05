package com.exchange.exchangeservice.logic.model.view.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckProductExistReqDTO {
	public String productId;
}
