package com.wora.ecommerce.userservice.user.application.service;

import com.wora.ecommerce.userservice.user.application.dto.request.RoleRequestDTO;
import com.wora.ecommerce.userservice.user.application.dto.response.RoleResponseDTO;
import com.wora.ecommerce.userservice.common.application.service.CrudService;
import com.wora.ecommerce.userservice.user.domain.entity.Role;

public interface RoleService extends CrudService<Long, RoleRequestDTO, RoleResponseDTO> {
    Role findEntityById(Long id);
}
