package com.videostore.videostore.application.usecase.movie;

import com.videostore.videostore.domain.exception.BusinessRuleViolationException;
import com.videostore.videostore.domain.exception.MovieNotFoundException;
import com.videostore.videostore.domain.model.Movie;
import com.videostore.videostore.domain.repository.MovieRepository;
import com.videostore.videostore.domain.repository.RentalRepository;

public class RemoveMovieUseCase {

    private final MovieRepository movieRepository;
    private final RentalRepository rentalRepository;

    public RemoveMovieUseCase(MovieRepository movieRepository, RentalRepository rentalRepository) {
        this.movieRepository = movieRepository;
        this.rentalRepository = rentalRepository;
    }

    public void execute(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));

        int activeRentals = rentalRepository.activeRentalsByMovie(id);
        if (activeRentals > 0) {
            throw new BusinessRuleViolationException("Cannot remove movie with active rentals");
        }

        movieRepository.delete(movie);
    }
}
