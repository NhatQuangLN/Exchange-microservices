package com.exchange.productservice.logic.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductResDTO {

	public Data data = new Data();

	public static class Data {
		public String productId;
	}
}
