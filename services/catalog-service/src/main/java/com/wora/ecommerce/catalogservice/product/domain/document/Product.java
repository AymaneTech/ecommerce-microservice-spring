package com.wora.ecommerce.catalogservice.product.domain.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class Product {

    @Id
    @JsonProperty("_id")
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @DBRef
    @NotNull
    private Category category;

    public Product(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
