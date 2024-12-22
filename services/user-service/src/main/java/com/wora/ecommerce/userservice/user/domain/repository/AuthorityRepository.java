package com.wora.ecommerce.userservice.user.domain.repository;

import com.wora.ecommerce.userservice.user.domain.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
