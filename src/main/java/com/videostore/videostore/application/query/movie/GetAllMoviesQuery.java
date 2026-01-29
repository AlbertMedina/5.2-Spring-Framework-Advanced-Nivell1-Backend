package com.videostore.videostore.application.query.movie;

import com.videostore.videostore.domain.model.movie.MovieSortBy;

public record GetAllMoviesQuery(
        int page,
        int amount,
        String genre,
        boolean onlyAvailable,
        String title,
        MovieSortBy sortBy,
        boolean ascending
) {
}
