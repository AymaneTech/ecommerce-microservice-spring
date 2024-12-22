package com.wora.ecommerce.userservice.user.application.service;

import com.wora.ecommerce.userservice.common.domain.exception.ResourceNotFoundException;
import com.wora.ecommerce.userservice.user.application.dto.response.AuthorityResponseDTO;
import com.wora.ecommerce.userservice.user.application.mapper.AuthorityMapper;
import com.wora.ecommerce.userservice.user.application.service.impl.DefaultAuthorityService;
import com.wora.ecommerce.userservice.user.domain.entity.Authority;
import com.wora.ecommerce.userservice.user.domain.repository.AuthorityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class AuthorityServiceUnitTest {
    @Mock
    private AuthorityRepository repository;
    @Mock
    private AuthorityMapper mapper;
    private AuthorityService underTest;

    private Authority authority;

    @BeforeEach
    void setup() {
        underTest = new DefaultAuthorityService(repository, mapper);
        authority = new Authority(1L, "ADMIN");
    }

    @Nested
    class FindAllTests {
        @Test
        void givenAuthoritiesDoesNotExists_whenFindAll_thenReturnEmptyList() {
            given(repository.findAll())
                    .willReturn(List.of());

            List<AuthorityResponseDTO> actual = underTest.findAll();
            assertThat(actual).isEmpty();
        }

        @Test
        void givenAuthoritiesListExists_whenFindAll_thenReturnAuthoritiesList() {
            given(repository.findAll())
                    .willReturn(List.of(authority));

            List<AuthorityResponseDTO> actual = underTest.findAll();
            assertThat(actual).hasSize(1);
        }
    }

    @Nested
    class FindByIdTests {
        @Test
        void givenAuthorityDoesNotExists_whenFindById_thenThrowResourceNotFoundException() {
            given(repository.findById(1L))
                    .willReturn(Optional.empty());

            assertThatExceptionOfType(ResourceNotFoundException.class)
                    .isThrownBy(() -> underTest.findById(1L))
                    .withMessage("authority with id 1 not found");
        }

        @Test
        void givenAuthorityExists_whenFindById_thenReturnAuthority() {
            given(repository.findById(1L))
                    .willReturn(Optional.of(authority));
            given(mapper.toResponseDTO(authority))
                    .willReturn(new AuthorityResponseDTO(1L, "ADMIN"));

            AuthorityResponseDTO actual = underTest.findById(1L);
            assertThat(actual).isNotNull();
        }
    }

}