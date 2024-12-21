package com.wora.ecommerce.userservice.application.service.impl;

import com.wora.ecommerce.userservice.application.dto.request.AuthorityRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.AuthorityResponseDTO;
import com.wora.ecommerce.userservice.application.mapper.AuthorityMapper;
import com.wora.ecommerce.userservice.application.service.AuthorityService;
import com.wora.ecommerce.userservice.common.application.service.ApplicationService;
import com.wora.ecommerce.userservice.common.domain.exception.ResourceNotFoundException;
import com.wora.ecommerce.userservice.domain.entity.Authority;
import com.wora.ecommerce.userservice.domain.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class DefaultAuthorityService implements AuthorityService {
    private final AuthorityRepository repository;
    private final AuthorityMapper mapper;

    @Override
    public List<AuthorityResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    @Override
    public AuthorityResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("authority", id));
    }

    @Override
    public AuthorityResponseDTO create(AuthorityRequestDTO dto) {
        Authority savedAuthority = repository.save(mapper.toEntity(dto));
        return mapper.toResponseDTO(savedAuthority);
    }

    @Override
    public AuthorityResponseDTO update(Long id, AuthorityRequestDTO dto) {
        Authority authority = findEntityById(id);
        mapper.updateEntity(authority, dto);
        return mapper.toResponseDTO(authority);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("authority", id);

        repository.deleteById(id);
    }

    public Authority findEntityById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("authority", id));
    }
}
