package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class ItemSaveFailException extends BusinessException {

    public ItemSaveFailException(ErrorCode errorCode) {
        super(errorCode);
    }
}
