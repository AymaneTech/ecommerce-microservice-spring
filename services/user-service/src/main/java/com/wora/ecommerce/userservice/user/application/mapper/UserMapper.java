package com.wora.ecommerce.userservice.user.application.mapper;

import com.wora.ecommerce.userservice.user.application.dto.request.UpdateUserRequestDTO;
import com.wora.ecommerce.userservice.user.application.dto.request.UserRegistrationRequestDTO;
import com.wora.ecommerce.userservice.user.application.dto.response.UserResponseDTO;
import com.wora.ecommerce.userservice.user.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRegistrationRequestDTO request);

    void updateEntity(@MappingTarget User user, UpdateUserRequestDTO request);

    UserResponseDTO toResponseDTO(User user);
}
