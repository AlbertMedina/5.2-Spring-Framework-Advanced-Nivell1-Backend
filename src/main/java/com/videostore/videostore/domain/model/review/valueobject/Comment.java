package com.videostore.videostore.domain.model.review.valueobject;

public record Comment(String value) {
    
    public Comment {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Comment cannot be empty");
        }

        if (value.length() > 500) {
            throw new IllegalArgumentException("Comment can be up tu 500 characters long");
        }
    }
}
