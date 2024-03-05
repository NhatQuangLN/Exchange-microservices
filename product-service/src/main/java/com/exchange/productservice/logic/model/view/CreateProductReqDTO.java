package com.exchange.productservice.logic.model.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductReqDTO {

	public String productName;

	public String productDescription;
}
