package com.wora.ecommerce.userservice.application.dto.request;

import com.wora.ecommerce.userservice.common.application.validation.UniqueField;
import com.wora.ecommerce.userservice.domain.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegistrationRequestDTO(
        @NotBlank @UniqueField(fieldName = "email", entityClass = User.class, message = "Email already taken") String email,
        @NotBlank String fullName,
        @NotBlank String password,
        @NotNull Long roleId
) {
}
