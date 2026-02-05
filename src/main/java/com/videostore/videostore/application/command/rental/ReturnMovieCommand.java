package com.videostore.videostore.application.command.rental;

public record ReturnMovieCommand(
        String username,
        Long movieId
) {
}
