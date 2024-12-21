package com.wora.ecommerce.userservice.application.service.impl;

import com.wora.ecommerce.userservice.application.dto.request.UpdateUserRequestDTO;
import com.wora.ecommerce.userservice.application.dto.request.UserLoginRequestDTO;
import com.wora.ecommerce.userservice.application.dto.request.UserRegistrationRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.UserResponseDTO;
import com.wora.ecommerce.userservice.application.mapper.UserMapper;
import com.wora.ecommerce.userservice.application.service.RoleService;
import com.wora.ecommerce.userservice.application.service.UserService;
import com.wora.ecommerce.userservice.common.application.service.ApplicationService;
import com.wora.ecommerce.userservice.common.domain.exception.ResourceNotFoundException;
import com.wora.ecommerce.userservice.domain.entity.Role;
import com.wora.ecommerce.userservice.domain.entity.User;
import com.wora.ecommerce.userservice.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class DefautlUserService implements UserService {
    private final UserRepository repository;
    private final RoleService roleService;
    private final UserMapper mapper;

    @Override
    public UserResponseDTO register(UserRegistrationRequestDTO request) {
        User user = mapper.toEntity(request)
                .password("hashed password")
                .role(roleService.findEntityById(request.roleId()));

        User savedUser = repository.save(user);
        return mapper.toResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO login(UserLoginRequestDTO request) {
        User user = findByEmail(request.email());
        // todo check password and generate token
        return mapper.toResponseDTO(user);
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("user", id));
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    @Override
    public UserResponseDTO update(Long id, UpdateUserRequestDTO request) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user", id));

        mapper.updateEntity(user, request);
        user.password("hashed password")
                .role(roleService.findEntityById(request.roleId()));
        User updatedUser = repository.save(user);
        return mapper.toResponseDTO(updatedUser);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("user", id);

        repository.deleteById(id);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with email %s not found", email)));
    }
}
