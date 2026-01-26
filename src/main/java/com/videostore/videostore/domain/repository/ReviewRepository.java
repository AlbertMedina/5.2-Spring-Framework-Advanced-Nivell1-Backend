package com.videostore.videostore.domain.repository;

import com.videostore.videostore.domain.model.review.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    Optional<Review> findById(Long id);

    List<Review> findAllByMovie(Long movieId);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);

    Review save(Review review);

    void deleteById(Long id);
}
