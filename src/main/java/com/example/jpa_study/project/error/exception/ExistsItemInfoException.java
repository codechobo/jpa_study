package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class ExistsItemInfoException extends BusinessException {
    public ExistsItemInfoException(ErrorCode errorCode) {
        super(errorCode);
    }
}
