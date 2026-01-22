package com.videostore.videostore.domain.service;

public class ReviewDomainService {

    public void validateReview(boolean hasRentedMovie, boolean hasAlreadyReviewed) {
        if (!hasRentedMovie) {
            throw new RuntimeException("User cannot review a movie they haven't rented");
        }

        if (hasAlreadyReviewed) {
            throw new RuntimeException("User has already reviewed this movie");
        }
    }
}
