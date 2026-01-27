package com.videostore.videostore.domain.repository;

import com.videostore.videostore.domain.model.review.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    Optional<Review> findByUserIdAndMovieId(Long userId, Long movieId);

    List<Review> findAllByMovie(Long movieId);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);

    Review addReview(Review review);

    void removeReview(Review review);
}
