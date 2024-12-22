package com.wora.ecommerce.userservice.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserRequestDTO(@NotBlank String email,
                                   @NotBlank String fullName,
                                   @NotBlank String password,
                                   @NotNull Long roleId
) {
}
