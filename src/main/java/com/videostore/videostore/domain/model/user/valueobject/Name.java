package com.videostore.videostore.domain.model.user.valueobject;

public record Name(String name) {
    public Name {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (!name.matches("^[A-Za-zÀ-ÿ' -]+$")) {
            throw new IllegalArgumentException("Invalid name format");
        }
    }
}
