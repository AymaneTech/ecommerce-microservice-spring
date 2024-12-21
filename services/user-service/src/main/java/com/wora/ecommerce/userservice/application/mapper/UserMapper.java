package com.wora.ecommerce.userservice.application.mapper;

import com.wora.ecommerce.userservice.application.dto.request.UpdateUserRequestDTO;
import com.wora.ecommerce.userservice.application.dto.request.UserRegistrationRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.UserResponseDTO;
import com.wora.ecommerce.userservice.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRegistrationRequestDTO request);

    void updateEntity(@MappingTarget User user, UpdateUserRequestDTO request);

    UserResponseDTO toResponseDTO(User user);
}
