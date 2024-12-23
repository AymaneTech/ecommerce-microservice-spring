package com.wora.ecommerce.catalogservice.product.domain.document;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class Category {

    @Id
    @JsonProperty("_id")
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
