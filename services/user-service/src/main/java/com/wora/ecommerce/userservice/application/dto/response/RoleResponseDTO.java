package com.wora.ecommerce.userservice.application.dto.response;

import java.util.List;

public record RoleResponseDTO(Long id,
                              String name,
                              List<AuthorityResponseDTO> authorities
) {
}
