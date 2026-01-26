package com.videostore.videostore.domain.model.review.valueobject;

public record Rating(int value) {
    
    public Rating {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Invalid rating (the rating must be between 1 and 5)");
        }
    }
}
