package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class NotFoundMemberEntityException extends BusinessException {
    public NotFoundMemberEntityException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
