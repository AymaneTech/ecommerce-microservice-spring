package com.wora.ecommerce.userservice.common.domain.vo;

import java.time.LocalDateTime;

public record ErrorResponse(int code, LocalDateTime timestamp, String message, String description, Object errors) {
}

