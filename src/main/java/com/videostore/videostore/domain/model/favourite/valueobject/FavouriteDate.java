package com.videostore.videostore.domain.model.favourite.valueobject;

import java.time.LocalDate;

public record FavouriteDate(LocalDate value) {

    public FavouriteDate {
        if (value == null) {
            throw new IllegalArgumentException("Favourite date cannot be null");
        }
        if (value.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Favourite date cannot be in the future");
        }
    }
}
