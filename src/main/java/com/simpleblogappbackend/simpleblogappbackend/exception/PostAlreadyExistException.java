package com.simpleblogappbackend.simpleblogappbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class PostAlreadyExistException extends RuntimeException {
    public PostAlreadyExistException(String message) {
        super(message);
    }
}
