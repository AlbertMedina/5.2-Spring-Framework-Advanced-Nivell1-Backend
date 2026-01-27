package com.videostore.videostore.application.usecase.review;

import com.videostore.videostore.domain.model.review.Review;
import com.videostore.videostore.domain.repository.ReviewRepository;

import java.util.List;

public class GetReviewsByMovieUseCase {

    private final ReviewRepository reviewRepository;

    public GetReviewsByMovieUseCase(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> execute(Long movieId) {
        return reviewRepository.findAllByMovie(movieId);
    }
}
