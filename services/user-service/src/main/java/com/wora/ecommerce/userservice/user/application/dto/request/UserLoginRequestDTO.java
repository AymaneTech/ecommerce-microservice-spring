package com.wora.ecommerce.userservice.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserLoginRequestDTO(@NotBlank String email,
                                  @NotBlank String password) {
}
