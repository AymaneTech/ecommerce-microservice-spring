package com.wora.ecommerce.userservice.application.dto.response;

public record UserResponseDTO(Long id,
                              String email,
                              String fullName,
                              RoleResponseDTO role
) {
}
