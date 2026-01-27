package com.videostore.videostore.application.usecase.review;

import com.videostore.videostore.application.command.review.RemoveReviewCommand;
import com.videostore.videostore.domain.exception.ReviewNotFoundException;
import com.videostore.videostore.domain.model.review.Review;
import com.videostore.videostore.domain.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemoveReviewUseCase {
    private final ReviewRepository reviewRepository;

    public RemoveReviewUseCase(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public void execute(RemoveReviewCommand command) {
        Review review = reviewRepository.findByUserIdAndMovieId(command.userId(), command.movieId())
                .orElseThrow(() -> new ReviewNotFoundException("User cannot remove a movie they haven't made"));

        reviewRepository.removeReview(review);
    }
}
