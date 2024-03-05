package com.exchange.productservice.logic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.productservice.logic.model.db.Product;
import com.exchange.productservice.logic.model.view.CreateProductReqDTO;
import com.exchange.productservice.logic.model.view.GetAllProductResDTO;
import com.exchange.productservice.logic.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public String createProduct(CreateProductReqDTO createProductReqDTO) {
		Product product = Product.builder().productName(createProductReqDTO.productName)
				.productDescription(createProductReqDTO.productDescription).build();

		Product productSave = productRepository.save(product);

		return productSave.getProductId();
	}

	public List<GetAllProductResDTO> getAllProducts() {

		List<Product> products = productRepository.findAll();

		return products.stream().map(product -> {
			return GetAllProductResDTO.builder().productDescription(product.getProductDescription())
					.productId(product.getProductId()).productName(product.getProductName()).build();
		}).toList();
	}

	public boolean isProductExist(String productId) {

		Optional<Product> productFind = productRepository.findById(productId);

		return productFind.isPresent();
	}
}
