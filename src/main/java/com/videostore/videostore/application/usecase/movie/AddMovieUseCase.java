package com.videostore.videostore.application.usecase.movie;

import com.videostore.videostore.application.command.movie.AddMovieCommand;
import com.videostore.videostore.domain.model.Movie;
import com.videostore.videostore.domain.repository.MovieRepository;

public class AddMovieUseCase {

    private final MovieRepository movieRepository;

    public AddMovieUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute(AddMovieCommand command) {
        Movie movie = Movie.create(
                command.getTitle(),
                command.getYear(),
                command.getGenre(),
                command.getDuration(),
                command.getDirector(),
                command.getSynopsis(),
                command.getNumberOfCopies()
        );

        return movieRepository.save(movie);
    }
}
