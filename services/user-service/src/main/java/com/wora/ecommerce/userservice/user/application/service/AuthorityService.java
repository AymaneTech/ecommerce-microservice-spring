package com.wora.ecommerce.userservice.user.application.service;

import com.wora.ecommerce.userservice.user.application.dto.request.AuthorityRequestDTO;
import com.wora.ecommerce.userservice.user.application.dto.response.AuthorityResponseDTO;
import com.wora.ecommerce.userservice.common.application.service.CrudService;

public interface AuthorityService extends CrudService<Long, AuthorityRequestDTO, AuthorityResponseDTO> {
}
