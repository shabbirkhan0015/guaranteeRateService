package com.guaranteeRateService.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GRException extends RuntimeException {
    private ErrorCode error;
    public GRException(ErrorCode error){
        super(error.getErrorMessage());
        this.error = error;
    }
    public GRException(String errorMessage){
        super(errorMessage);
    }
}
