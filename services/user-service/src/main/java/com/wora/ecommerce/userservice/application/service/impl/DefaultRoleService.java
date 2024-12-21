package com.wora.ecommerce.userservice.application.service.impl;

import com.wora.ecommerce.userservice.application.dto.request.RoleRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.RoleResponseDTO;
import com.wora.ecommerce.userservice.application.mapper.RoleMapper;
import com.wora.ecommerce.userservice.application.service.RoleService;
import com.wora.ecommerce.userservice.common.application.service.ApplicationService;
import com.wora.ecommerce.userservice.common.domain.exception.ResourceNotFoundException;
import com.wora.ecommerce.userservice.domain.entity.Role;
import com.wora.ecommerce.userservice.domain.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class DefaultRoleService implements RoleService {
    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public List<RoleResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    @Override
    public RoleResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("role", id));
    }

    @Override
    public RoleResponseDTO create(RoleRequestDTO dto) {
        Role savedRole = repository.save(mapper.toEntity(dto));
        return mapper.toResponseDTO(savedRole);
    }

    @Override
    public RoleResponseDTO update(Long id, RoleRequestDTO dto) {
        Role role = findEntityById(id);
        mapper.updateEntity(role, dto);
        return mapper.toResponseDTO(role);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("role", id);

        repository.deleteById(id);
    }

    public Role findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("role", id));
    }
}
