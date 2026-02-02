package com.videostore.videostore.web.controller.favourite.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AddFavouriteRequest(
        @NotNull @Positive Long userId,
        @NotNull @Positive Long movieId
) {
}
