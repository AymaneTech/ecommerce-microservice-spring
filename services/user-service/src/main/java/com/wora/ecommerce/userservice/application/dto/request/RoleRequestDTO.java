package com.wora.ecommerce.userservice.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RoleRequestDTO(@NotBlank String name,
                             @NotNull List<AuthorityRequestDTO> authorities) {
}
