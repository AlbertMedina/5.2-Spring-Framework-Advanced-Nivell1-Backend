package com.videostore.videostore.web.controller.review.dto.request;

public record AddReviewRequest(
        Long movieId,
        int rating,
        String comment
) {
}
