package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class NotFoundItemTypeException extends BusinessException {
    public NotFoundItemTypeException(ErrorCode errorCode) {
        super(errorCode);
    }
}
