package com.videostore.videostore.application.command.rental;

public record RentMovieCommand(
        String username,
        Long movieId
) {
}
