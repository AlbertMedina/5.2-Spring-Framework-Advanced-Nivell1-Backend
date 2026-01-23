package com.videostore.videostore.application.usecase.movie.query;

public record GetAllMoviesQuery(
        int page,
        int amount,
        String genre,
        boolean onlyAvailable
) {
}
