package com.wora.ecommerce.userservice.infrastructure.web;

import com.wora.ecommerce.userservice.application.dto.request.RoleRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.RoleResponseDTO;
import com.wora.ecommerce.userservice.application.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService service;

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> findAll() {
        List<RoleResponseDTO> roles = service.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> findById(@PathVariable Long id) {
        RoleResponseDTO role = service.findById(id);
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> create(@RequestBody @Valid RoleRequestDTO request) {
        RoleResponseDTO role = service.create(request);
        return ResponseEntity.ok(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> update(@PathVariable Long id, @RequestBody @Valid RoleRequestDTO request) {
        RoleResponseDTO role = service.update(id, request);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
