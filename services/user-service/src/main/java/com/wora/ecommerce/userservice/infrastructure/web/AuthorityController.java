package com.wora.ecommerce.userservice.infrastructure.web;

import com.wora.ecommerce.userservice.application.dto.request.AuthorityRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.AuthorityResponseDTO;
import com.wora.ecommerce.userservice.application.service.AuthorityService;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authorities")
@RequiredArgsConstructor
public class AuthorityController {
    private final AuthorityService service;

    @GetMapping
    public ResponseEntity<List<AuthorityResponseDTO>> findAll() {
        List<AuthorityResponseDTO> authorities = service.findAll();
        return ResponseEntity.ok(authorities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorityResponseDTO> findById(@PathVariable Long id) {
        AuthorityResponseDTO authority = service.findById(id);
        return ResponseEntity.ok(authority);
    }

    @PostMapping
    public ResponseEntity<AuthorityResponseDTO> create(@RequestBody @Valid AuthorityRequestDTO request) {
        AuthorityResponseDTO authority = service.create(request);
        return ResponseEntity.ok(authority);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorityResponseDTO> update(@PathVariable Long id, @RequestBody @Valid AuthorityRequestDTO request) {
        AuthorityResponseDTO authority = service.update(id, request);
        return ResponseEntity.ok(authority);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
