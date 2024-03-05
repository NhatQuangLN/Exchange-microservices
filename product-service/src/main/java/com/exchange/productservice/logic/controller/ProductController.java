package com.exchange.productservice.logic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.productservice.logic.model.view.CheckProductReqDTO;
import com.exchange.productservice.logic.model.view.CheckProductResDTO;
import com.exchange.productservice.logic.model.view.CreateProductReqDTO;
import com.exchange.productservice.logic.model.view.CreateProductResDTO;
import com.exchange.productservice.logic.model.view.GetAllProductReqDTO;
import com.exchange.productservice.logic.model.view.GetAllProductResDTO;
import com.exchange.productservice.logic.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/api/product/get-all")
	public List<GetAllProductResDTO> getAllProducts(GetAllProductReqDTO getAllProductReqDTO) {

		return productService.getAllProducts();
	}

	@PostMapping("/api/product/create")
	public CreateProductResDTO createProduct(@RequestBody CreateProductReqDTO createProductReqDTO) {

		String productId = productService.createProduct(createProductReqDTO);

		CreateProductResDTO createProductResDTO = new CreateProductResDTO();
		createProductResDTO.data.productId = productId;
		return createProductResDTO;
	}

	@PostMapping("/api/product-check")
	public CheckProductResDTO checkProduct(@RequestBody CheckProductReqDTO checkProductReqDTO) {

		System.out.println("ddddddddddd" + checkProductReqDTO);
		CheckProductResDTO checkProductResDTO = new CheckProductResDTO();
		checkProductResDTO.data.isExisted = productService.isProductExist(checkProductReqDTO.productId);

		return checkProductResDTO;
	}
}
