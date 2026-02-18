package com.videostore.videostore.application.port.in.movie;

import com.videostore.videostore.domain.common.RatingSummary;

public interface GetMovieRatingUseCase {
    RatingSummary execute(Long movieId);
}
