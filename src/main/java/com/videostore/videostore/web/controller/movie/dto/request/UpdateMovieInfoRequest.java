package com.videostore.videostore.web.controller.movie.dto.request;

public record UpdateMovieInfoRequest(
        String title,
        int year,
        String genre,
        int duration,
        String director,
        String synopsis
) {
}
