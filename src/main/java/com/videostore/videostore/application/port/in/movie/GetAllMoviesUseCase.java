package com.videostore.videostore.application.port.in.movie;

import com.videostore.videostore.application.command.movie.GetAllMoviesCommand;
import com.videostore.videostore.domain.common.PagedResult;
import com.videostore.videostore.domain.model.movie.Movie;

public interface GetAllMoviesUseCase {
    PagedResult<Movie> execute(GetAllMoviesCommand getAllMoviesCommand);
}
