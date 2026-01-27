package com.videostore.videostore.domain.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super("Username " + username + " already exists");
    }
}
