package com.videostore.videostore.application.command.review;

public record AddReviewCommand(
        Long userId,
        Long movieId,
        int rating,
        String comment
) {
}
