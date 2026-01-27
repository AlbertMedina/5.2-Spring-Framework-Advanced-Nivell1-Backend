package com.videostore.videostore.domain.exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("Wrong username/email or password");
    }
}
