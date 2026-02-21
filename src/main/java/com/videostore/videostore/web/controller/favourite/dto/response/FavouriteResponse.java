package com.videostore.videostore.web.controller.favourite.dto.response;

import com.videostore.videostore.application.model.FavouriteDetails;
import com.videostore.videostore.web.controller.movie.dto.response.MovieResponse;

public record FavouriteResponse(
        Long id,
        MovieResponse movie,
        String favouriteDate
) {
    public static FavouriteResponse from(FavouriteDetails favouriteDetails) {
        return new FavouriteResponse(
                favouriteDetails.id(),
                MovieResponse.from(favouriteDetails.movieDetails()),
                favouriteDetails.favouriteDate().toString()
        );
    }
}
