package com.wora.ecommerce.userservice.domain.repository;

import com.wora.ecommerce.userservice.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
