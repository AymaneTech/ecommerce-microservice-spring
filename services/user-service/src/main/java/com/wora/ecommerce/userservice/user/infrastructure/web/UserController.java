package com.wora.ecommerce.userservice.user.infrastructure.web;

import com.wora.ecommerce.userservice.user.application.dto.request.UpdateUserRequestDTO;
import com.wora.ecommerce.userservice.user.application.dto.request.UserLoginRequestDTO;
import com.wora.ecommerce.userservice.user.application.dto.request.UserRegistrationRequestDTO;
import com.wora.ecommerce.userservice.user.application.dto.response.UserResponseDTO;
import com.wora.ecommerce.userservice.user.application.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/auth/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRegistrationRequestDTO request) {
        UserResponseDTO user = service.register(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody @Valid UserLoginRequestDTO request) {
        UserResponseDTO user = service.login(request);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        UserResponseDTO user = service.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateUserRequestDTO request) {
        UserResponseDTO user = service.update(id, request);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

