package com.videostore.videostore.application.usecase.movie;

import com.videostore.videostore.domain.exception.MovieNotFoundException;
import com.videostore.videostore.domain.model.Movie;
import com.videostore.videostore.domain.repository.MovieRepository;

public class GetMovieUseCase {

    private final MovieRepository movieRepository;

    public GetMovieUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }
}
