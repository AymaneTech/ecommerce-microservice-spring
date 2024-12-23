package com.wora.ecommerce.catalogservice.common.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String entityName, Object id) {
        super(entityName + " with id " + id + " not found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
