package com.videostore.videostore.web.controller.movie.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AddMovieRequest(
        @NotNull @NotBlank String title,
        @Min(1895) int year,
        @NotNull @NotBlank String genre,
        @Positive int duration,
        @NotNull @NotBlank String director,
        @NotNull @NotBlank String synopsis,
        @Positive int numberOfCopies
) {
}
