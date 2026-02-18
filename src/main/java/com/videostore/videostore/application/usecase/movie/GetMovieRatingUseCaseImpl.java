package com.videostore.videostore.application.usecase.movie;

import com.videostore.videostore.application.port.in.movie.GetMovieRatingUseCase;
import com.videostore.videostore.domain.common.RatingSummary;
import com.videostore.videostore.domain.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class GetMovieRatingUseCaseImpl implements GetMovieRatingUseCase {

    private final ReviewRepository reviewRepository;

    public GetMovieRatingUseCaseImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public RatingSummary execute(Long movieId) {
        return reviewRepository.getAverageRatingByMovieId(movieId)
                .orElse(new RatingSummary(0.0, 0));
    }
}
