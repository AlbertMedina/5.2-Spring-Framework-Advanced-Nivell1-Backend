package com.videostore.videostore.domain.model.user.valueobject;

public record Surname(String surname) {
    public Surname {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Surname cannot be empty");
        }

        if (!surname.matches("^[A-Za-zÀ-ÿ' -]+$")) {
            throw new IllegalArgumentException("Invalid surname format");
        }
    }
}
