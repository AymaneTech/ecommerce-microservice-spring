package com.wora.ecommerce.userservice.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RoleRequestDTO(@NotBlank String name) {
}
