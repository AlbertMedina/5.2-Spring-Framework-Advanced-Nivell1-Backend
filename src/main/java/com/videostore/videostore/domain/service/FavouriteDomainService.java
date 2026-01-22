package com.videostore.videostore.domain.service;

public class FavouriteDomainService {

    public void validateAddFavorite(boolean isAlreadyFavorite) {
        if (isAlreadyFavorite) {
            throw new RuntimeException("User has already added this movie to favorites");
        }
    }
    
    public void validateRemoveFavorite(boolean isFavorite) {
        if (!isFavorite) {
            throw new RuntimeException("User cannot remove a movie that is not in favorites");
        }
    }
}
