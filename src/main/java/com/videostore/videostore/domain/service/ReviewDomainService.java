package com.videostore.videostore.domain.service;

import com.videostore.videostore.domain.exception.BusinessRuleViolationException;

public class ReviewDomainService {

    public void validateReview(boolean hasRentedMovie, boolean hasAlreadyReviewed) {
        if (!hasRentedMovie) {
            throw new BusinessRuleViolationException("User cannot review a movie they haven't rented");
        }

        if (hasAlreadyReviewed) {
            throw new BusinessRuleViolationException("User has already reviewed this movie");
        }
    }
}
