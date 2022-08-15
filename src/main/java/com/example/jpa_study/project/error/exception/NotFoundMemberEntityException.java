package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class NotFoundMemberEntityException extends BusinessException {
    public NotFoundMemberEntityException(ErrorCode errorCode) {
        super(errorCode);
    }
}
