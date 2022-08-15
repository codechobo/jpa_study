package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class NotEnoughStockException extends BusinessException {
    public NotEnoughStockException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
