package com.wora.ecommerce.userservice.application.mapper;

import com.wora.ecommerce.userservice.application.dto.request.AuthorityRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.AuthorityResponseDTO;
import com.wora.ecommerce.userservice.domain.entity.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorityMapper {
    Authority toEntity(AuthorityRequestDTO request);

    void updateEntity(@MappingTarget Authority authority, AuthorityRequestDTO request);

    AuthorityResponseDTO toResponseDTO(Authority authority);
}
