package com.guaranteeRateService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({GRException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> GRExceptionHandler(GRException exception){
        Map<String, String> error = new HashMap<>();
        error.put("errorCode", exception.getError().getErrorCode());
        error.put("message", exception.getError().getErrorMessage());
        error.put("timestamp", LocalDateTime.now().toString());
        return error;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionhandler(Exception exception){
        return "Something went Wrong!";
    }
}
