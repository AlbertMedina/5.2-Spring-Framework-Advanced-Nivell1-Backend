package com.videostore.videostore.application.model;

import java.time.LocalDate;

public record FavouriteDetails(
        Long id,
        LocalDate favouriteDate,
        MovieDetails movieDetails
) {
}
