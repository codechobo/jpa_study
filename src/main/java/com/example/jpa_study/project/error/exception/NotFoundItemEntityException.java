package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class NotFoundItemEntityException extends BusinessException {

    public NotFoundItemEntityException(ErrorCode errorCode) {
        super(errorCode);
    }
}
