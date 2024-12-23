package com.wora.ecommerce.catalogservice.product.domain.repository;

import com.wora.ecommerce.catalogservice.product.domain.document.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
