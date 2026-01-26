package com.videostore.videostore.application.usecase.movie;

import com.videostore.videostore.application.usecase.movie.query.GetAllMoviesQuery;
import com.videostore.videostore.domain.model.movie.Movie;
import com.videostore.videostore.domain.repository.MovieRepository;

import java.util.List;

public class GetAllMoviesUseCase {

    private final MovieRepository movieRepository;

    public GetAllMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> execute(GetAllMoviesQuery getAllMoviesQuery) {
        return movieRepository.findAll(getAllMoviesQuery.page(),
                getAllMoviesQuery.amount(),
                getAllMoviesQuery.genre(),
                getAllMoviesQuery.onlyAvailable()
        );
    }
}
