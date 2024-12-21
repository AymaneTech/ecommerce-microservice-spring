package com.wora.ecommerce.userservice.domain.repository;

import com.wora.ecommerce.userservice.domain.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
