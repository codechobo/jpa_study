package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class ExistsMemberInfoException extends BusinessException {

    public ExistsMemberInfoException(ErrorCode errorCode) {
        super(errorCode);
    }
}
