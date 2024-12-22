package com.wora.ecommerce.userservice.user.application.dto.response;

public record UserResponseDTO(Long id,
                              String email,
                              String fullName,
                              RoleResponseDTO role
) {
}
