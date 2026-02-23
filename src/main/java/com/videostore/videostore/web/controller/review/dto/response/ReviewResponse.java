package com.videostore.videostore.web.controller.review.dto.response;

import com.videostore.videostore.application.model.ReviewDetails;

public record ReviewResponse(
        Long id,
        int rating,
        String comment,
        String reviewDate,
        Long userId,
        String username
) {
    public static ReviewResponse from(ReviewDetails reviewDetails) {
        return new ReviewResponse(
                reviewDetails.id(),
                reviewDetails.rating(),
                reviewDetails.comment(),
                reviewDetails.reviewDate().toString(),
                reviewDetails.userId(),
                reviewDetails.username()
        );
    }
}
