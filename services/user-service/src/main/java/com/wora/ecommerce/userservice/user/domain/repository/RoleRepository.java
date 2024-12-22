package com.wora.ecommerce.userservice.user.domain.repository;

import com.wora.ecommerce.userservice.user.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
