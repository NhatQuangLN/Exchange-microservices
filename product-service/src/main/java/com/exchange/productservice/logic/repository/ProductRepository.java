package com.exchange.productservice.logic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exchange.productservice.logic.model.db.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
