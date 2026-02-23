package com.videostore.videostore.web.controller.movie.dto.request;

public record AddMovieRequest(
        String title,
        int year,
        String genre,
        int duration,
        String director,
        String synopsis,
        int numberOfCopies
) {
}
