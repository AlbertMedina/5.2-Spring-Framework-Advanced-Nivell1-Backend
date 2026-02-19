package com.videostore.videostore.application.model;

import com.videostore.videostore.domain.common.RatingSummary;
import com.videostore.videostore.domain.model.movie.Movie;

public record MovieDetails(
        Movie movie,
        RatingSummary rating
) {
}
