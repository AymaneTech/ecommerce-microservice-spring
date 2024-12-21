package com.wora.ecommerce.userservice.application.service;

import com.wora.ecommerce.userservice.application.dto.request.AuthorityRequestDTO;
import com.wora.ecommerce.userservice.application.dto.response.AuthorityResponseDTO;
import com.wora.ecommerce.userservice.common.application.service.CrudService;

public interface AuthorityService extends CrudService<Long, AuthorityRequestDTO, AuthorityResponseDTO> {
}
