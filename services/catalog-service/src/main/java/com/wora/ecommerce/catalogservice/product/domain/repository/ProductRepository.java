package com.wora.ecommerce.catalogservice.product.domain.repository;

import com.wora.ecommerce.catalogservice.product.domain.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
