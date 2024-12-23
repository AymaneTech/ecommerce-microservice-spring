package com.wora.ecommerce.catalogservice.product.application.service.impl;

import com.wora.ecommerce.catalogservice.common.exception.ResourceNotFoundException;
import com.wora.ecommerce.catalogservice.product.application.service.CategoryService;
import com.wora.ecommerce.catalogservice.product.domain.document.Category;
import com.wora.ecommerce.catalogservice.product.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepository repository;

    public DefaultCategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category", id));
    }
}
