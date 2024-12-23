package com.wora.ecommerce.userservice.common.domain.exception;

import java.time.LocalDateTime;

public record ErrorResponse(int code, LocalDateTime timestamp, String message, String description, Object errors) {
}

