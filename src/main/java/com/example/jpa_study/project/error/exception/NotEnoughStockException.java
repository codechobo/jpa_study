package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class NotEnoughStockException extends BusinessException {
    public NotEnoughStockException(ErrorCode errorCode) {
        super(errorCode);
    }
}
