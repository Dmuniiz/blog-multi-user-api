package com.devtiro.blog.exception;

public class ValidationExceptionMessage extends RuntimeException {

    public ValidationExceptionMessage(String message) {
        super(message);
    }
}