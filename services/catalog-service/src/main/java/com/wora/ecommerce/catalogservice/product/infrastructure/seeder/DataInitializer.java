package com.wora.ecommerce.catalogservice.product.infrastructure.seeder;

import com.wora.ecommerce.catalogservice.product.domain.document.Category;
import com.wora.ecommerce.catalogservice.product.domain.document.Product;
import com.wora.ecommerce.catalogservice.product.domain.repository.CategoryRepository;
import com.wora.ecommerce.catalogservice.product.domain.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataInitializer(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Bean
    CommandLineRunner initCategories() {
        return args -> {
            if (categoryRepository.count() == 0) {
                System.out.println("data already seeded");
                return;
            }
            System.out.println("Initializing categories...");
            categoryRepository.save(new Category("Electronics", "Electronic devices"));
        };
    }

    @Bean
    CommandLineRunner initProduct(){
        return args -> {
            if (productRepository.count() == 0) {
                System.out.println("data already seeded");
                return;
            }
            System.out.println("Initializing products...");
            categoryRepository.findAll().forEach(category -> {
                productRepository.save(new Product("Product 1", "Product 1 description", category));
                productRepository.save(new Product("Product 2", "Product 2 description", category));
            });
        };
    }

}
