package com.videostore.videostore.application.port.in.movie;

import com.videostore.videostore.application.command.movie.GetAllMoviesCommand;
import com.videostore.videostore.application.model.MovieDetails;
import com.videostore.videostore.domain.common.PagedResult;

public interface GetAllMoviesUseCase {
    PagedResult<MovieDetails> execute(GetAllMoviesCommand getAllMoviesCommand);
}
