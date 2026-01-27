package com.videostore.videostore.domain.model.user.valueobject;

public record Password(String value) {

    public Password {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        if (value.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (value.length() > 128) {
            throw new IllegalArgumentException("Password must be at most 128 characters long");
        }

        if (value.matches(".*\\s+.*")) {
            throw new IllegalArgumentException("Password cannot contain whitespace characters");
        }

        if (!value.matches(".*[A-Za-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one letter");
        }

        if (!value.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }
    }
}
