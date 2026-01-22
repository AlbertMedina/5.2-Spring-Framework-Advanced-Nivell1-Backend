package com.videostore.videostore.domain.service;

import com.videostore.videostore.domain.exception.BusinessRuleViolationException;

public class FavouriteDomainService {

    public void validateAddFavorite(boolean isAlreadyFavorite) {
        if (isAlreadyFavorite) {
            throw new BusinessRuleViolationException("User has already added this movie to favorites");
        }
    }

    public void validateRemoveFavorite(boolean isFavorite) {
        if (!isFavorite) {
            throw new BusinessRuleViolationException("User cannot remove a movie that is not in favorites");
        }
    }
}
