package com.nelson.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductException(ResourceNotFoundException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
                .message(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .date(LocalDate.now())
                .build(), HttpStatus.NOT_FOUND
                );
    }
}
