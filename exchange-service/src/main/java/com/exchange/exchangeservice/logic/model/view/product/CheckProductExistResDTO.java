package com.exchange.exchangeservice.logic.model.view.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckProductExistResDTO {
	public Data data = new Data();

	public static class Data {
		public Boolean isExisted;
	}
}
