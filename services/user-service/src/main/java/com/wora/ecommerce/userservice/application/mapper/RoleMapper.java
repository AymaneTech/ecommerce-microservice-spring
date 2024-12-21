package com.wora.ecommerce.userservice.application.mapper;

import com.wora.ecommerce.userservice.application.dto.request.RoleRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.RoleResponseDTO;
import com.wora.ecommerce.userservice.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toEntity(RoleRequestDTO request);

    void updateEntity(@MappingTarget Role role, RoleRequestDTO request);

    RoleResponseDTO toResponseDTO(Role role);
}
