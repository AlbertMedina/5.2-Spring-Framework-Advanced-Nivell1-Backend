package com.videostore.videostore.web.controller.rental.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RentMovieRequest(
        @NotNull @Positive Long userId,
        @NotNull @Positive Long movieId
) {
}
