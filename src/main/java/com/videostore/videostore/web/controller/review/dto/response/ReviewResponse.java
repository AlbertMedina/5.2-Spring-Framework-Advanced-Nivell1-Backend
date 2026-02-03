package com.videostore.videostore.web.controller.review.dto.response;

import com.videostore.videostore.domain.model.review.Review;

public record ReviewResponse(
        Long id,
        Long userId,
        Long movieId,
        int rating,
        String comment,
        String reviewDate
) {
    public static ReviewResponse fromDomain(Review review) {
        return new ReviewResponse(
                review.getId().value(),
                review.getUserId().value(),
                review.getMovieId().value(),
                review.getRating().value(),
                review.getComment().value(),
                review.getReviewDate().toString()
        );
    }
}
