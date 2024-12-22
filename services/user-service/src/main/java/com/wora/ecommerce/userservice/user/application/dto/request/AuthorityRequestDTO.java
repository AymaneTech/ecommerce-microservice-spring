package com.wora.ecommerce.userservice.user.application.dto.request;

import com.wora.ecommerce.userservice.common.application.validation.UniqueField;
import com.wora.ecommerce.userservice.user.domain.entity.Authority;
import jakarta.validation.constraints.NotBlank;

public record AuthorityRequestDTO(
        @NotBlank @UniqueField(fieldName = "name", entityClass = Authority.class) String name) {
}
