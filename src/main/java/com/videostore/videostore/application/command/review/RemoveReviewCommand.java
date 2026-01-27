package com.videostore.videostore.application.command.review;

public record RemoveReviewCommand(
        Long userId,
        Long movieId
) {
}
