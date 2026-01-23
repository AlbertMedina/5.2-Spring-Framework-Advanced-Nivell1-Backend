package com.videostore.videostore.application.usecase.movie;

import com.videostore.videostore.application.command.movie.UpdateMovieInfoCommand;
import com.videostore.videostore.domain.exception.MovieNotFoundException;
import com.videostore.videostore.domain.model.Movie;
import com.videostore.videostore.domain.repository.MovieRepository;

public class UpdateMovieInfoUseCase {

    private final MovieRepository movieRepository;

    public UpdateMovieInfoUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute(Long id, UpdateMovieInfoCommand command) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));

        movie.setTitle(command.getTitle());
        movie.setYear(command.getYear());
        movie.setGenre(command.getGenre());
        movie.setDuration(command.getDuration());
        movie.setDirector(command.getDirector());
        movie.setSynopsis(command.getSynopsis());

        return movieRepository.save(movie);
    }
}
