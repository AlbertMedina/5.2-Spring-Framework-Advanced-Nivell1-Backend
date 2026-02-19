package com.videostore.videostore.application.port.in.review;

import com.videostore.videostore.application.model.ReviewDetails;

import java.util.List;

public interface GetReviewsByMovieUseCase {
    List<ReviewDetails> execute(Long movieId);
}
