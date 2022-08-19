package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class NotFoundOrderEntityException extends BusinessException {
    public NotFoundOrderEntityException(ErrorCode errorCode) {
        super(errorCode);
    }
}
