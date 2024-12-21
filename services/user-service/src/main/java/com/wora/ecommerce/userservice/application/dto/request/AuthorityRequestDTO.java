package com.wora.ecommerce.userservice.application.dto.request;

import com.wora.ecommerce.userservice.common.application.validation.UniqueField;
import com.wora.ecommerce.userservice.domain.entity.Authority;
import jakarta.validation.constraints.NotBlank;

public record AuthorityRequestDTO(
        @NotBlank @UniqueField(fieldName = "name", entityClass = Authority.class) String name) {
}
