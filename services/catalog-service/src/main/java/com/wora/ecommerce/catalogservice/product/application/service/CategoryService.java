package com.wora.ecommerce.catalogservice.product.application.service;

import com.wora.ecommerce.catalogservice.product.domain.document.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(String id);
}
