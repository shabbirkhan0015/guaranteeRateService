package com.guaranteeRateService.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
public enum ErrorCode {
    APPLICATION_NOT_FOUND("404_not_found","Application Not Found!");
    private String errorCode;
    private String errorMessage;
    ErrorCode(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
