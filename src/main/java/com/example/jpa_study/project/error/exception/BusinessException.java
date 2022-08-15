package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class BusinessException extends RuntimeException {
    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
    }
}
