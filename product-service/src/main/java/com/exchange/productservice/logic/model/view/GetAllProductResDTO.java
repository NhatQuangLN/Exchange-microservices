package com.exchange.productservice.logic.model.view;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllProductResDTO {

	@Id
	private String productId;

	private String productName;

	private String productDescription;
}
