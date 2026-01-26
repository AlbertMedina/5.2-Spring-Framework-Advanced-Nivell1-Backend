package com.videostore.videostore.domain.model.valueobject;

public record UserName(String username) {

    public UserName {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (username.matches(".*\\s+.*")) {
            throw new IllegalArgumentException("Username cannot contain whitespace");
        }

        if (!username.matches("^[A-Za-z0-9_-]+$")) {
            throw new IllegalArgumentException("Username may only contain letters, numbers, underscores and hyphens");
        }

        if (username.length() < 3) {
            throw new IllegalArgumentException("Username must be at least 3 characters long");
        }
    }
}
