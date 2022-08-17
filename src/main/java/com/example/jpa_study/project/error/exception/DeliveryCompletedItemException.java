package com.example.jpa_study.project.error.exception;

import com.example.jpa_study.project.error.ErrorCode;

public class DeliveryCompletedItemException extends BusinessException {
    public DeliveryCompletedItemException(ErrorCode errorCode) {
        super(errorCode);
    }
}
