package com.videostore.videostore.domain.exception;

public class MovieAlreadyReviewedException extends RuntimeException {
    public MovieAlreadyReviewedException(Long userId, Long movieId) {
        super("User " + userId + " has already a review on movie " + movieId);
    }
}
