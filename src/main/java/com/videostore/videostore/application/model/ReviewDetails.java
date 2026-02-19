package com.videostore.videostore.application.model;

import com.videostore.videostore.domain.model.review.Review;

public record ReviewDetails(
        Review review,
        String username
) {
}