package com.videostore.videostore.domain.model.user.valueobject;

public record Password(String value) {

    public Password {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }

    public static void validate(String rawPassword) {
        if (rawPassword == null || rawPassword.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        if (rawPassword.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (rawPassword.length() > 128) {
            throw new IllegalArgumentException("Password must be at most 128 characters long");
        }

        if (rawPassword.matches(".*\\s+.*")) {
            throw new IllegalArgumentException("Password cannot contain whitespace characters");
        }

        if (!rawPassword.matches(".*[A-Za-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one letter");
        }

        if (!rawPassword.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }
    }
}
