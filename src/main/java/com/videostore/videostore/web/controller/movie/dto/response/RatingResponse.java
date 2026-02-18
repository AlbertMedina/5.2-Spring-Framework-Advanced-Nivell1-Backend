package com.videostore.videostore.web.controller.movie.dto.response;

public record RatingResponse(
        double average,
        int count
) {
}
