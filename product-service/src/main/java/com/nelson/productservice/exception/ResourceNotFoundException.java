package com.nelson.productservice.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{

    private String errorCode;

    public ResourceNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
