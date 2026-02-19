package com.videostore.videostore.application.port.in.movie;

import com.videostore.videostore.application.command.movie.AddMovieCommand;
import com.videostore.videostore.application.model.MovieDetails;

public interface AddMovieUseCase {
    MovieDetails execute(AddMovieCommand command);
}
