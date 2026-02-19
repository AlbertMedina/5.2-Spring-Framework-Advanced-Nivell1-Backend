package com.videostore.videostore.application.port.in.movie;

import com.videostore.videostore.application.model.MovieDetails;

public interface GetMovieUseCase {
    MovieDetails execute(Long id);
}
