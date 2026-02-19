package com.videostore.videostore.application.port.in.movie;

import com.videostore.videostore.application.command.movie.UpdateMovieInfoCommand;
import com.videostore.videostore.application.model.MovieDetails;

public interface UpdateMovieInfoUseCase {
    MovieDetails execute(Long id, UpdateMovieInfoCommand command);
}
