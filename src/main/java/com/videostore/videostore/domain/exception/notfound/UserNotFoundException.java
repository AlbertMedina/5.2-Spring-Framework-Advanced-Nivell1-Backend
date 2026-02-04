package com.videostore.videostore.domain.exception.notfound;

import com.videostore.videostore.domain.model.user.valueobject.Username;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super("User", id);
    }

    public UserNotFoundException(String username) {
        super("User " + username + " not found");
    }
}
