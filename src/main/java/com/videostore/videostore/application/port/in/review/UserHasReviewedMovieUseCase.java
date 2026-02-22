package com.videostore.videostore.application.port.in.review;

public interface UserHasReviewedMovieUseCase {
    boolean execute(String username, Long movieId);
}
