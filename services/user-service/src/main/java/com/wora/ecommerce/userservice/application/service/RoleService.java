package com.wora.ecommerce.userservice.application.service;

import com.wora.ecommerce.userservice.application.dto.request.RoleRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.RoleResponseDTO;
import com.wora.ecommerce.userservice.common.application.service.CrudService;
import com.wora.ecommerce.userservice.domain.entity.Role;

public interface RoleService extends CrudService<Long, RoleRequestDTO, RoleResponseDTO> {
    Role findEntityById(Long id);
}
