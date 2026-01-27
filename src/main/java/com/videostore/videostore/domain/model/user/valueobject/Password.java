package com.videostore.videostore.domain.model.user.valueobject;

public record Password(String value) {

    public Password {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        //TODO: password requirements
    }
}
