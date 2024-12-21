package com.wora.ecommerce.userservice.application.service;

import com.wora.ecommerce.userservice.application.dto.request.UpdateUserRequestDTO;
import com.wora.ecommerce.userservice.application.dto.request.UserLoginRequestDTO;
import com.wora.ecommerce.userservice.application.dto.request.UserRegistrationRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO register(UserRegistrationRequestDTO request);

    UserResponseDTO login(UserLoginRequestDTO request);

    UserResponseDTO findById(Long id);

    List<UserResponseDTO> findAll();

    UserResponseDTO update(Long id, UpdateUserRequestDTO request);

    void delete(Long id);
}
