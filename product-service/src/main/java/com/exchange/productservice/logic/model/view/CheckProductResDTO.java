package com.exchange.productservice.logic.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CheckProductResDTO {

	public Data data = new Data();

	public static class Data {
		public Boolean isExisted;
	}
}
