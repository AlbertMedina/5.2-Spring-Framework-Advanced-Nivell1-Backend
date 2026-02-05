package com.videostore.videostore.domain.exception.notfound;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super("User", id);
    }

    public UserNotFoundException(String username) {
        super("User " + username + " not found");
    }
}
