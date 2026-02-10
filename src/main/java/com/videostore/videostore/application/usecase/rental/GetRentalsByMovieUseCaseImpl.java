package com.videostore.videostore.application.usecase.rental;

import com.videostore.videostore.application.port.in.rental.GetRentalsByMovieUseCase;
import com.videostore.videostore.domain.exception.notfound.MovieNotFoundException;
import com.videostore.videostore.domain.model.movie.Movie;
import com.videostore.videostore.domain.model.movie.valueobject.MovieId;
import com.videostore.videostore.domain.model.rental.Rental;
import com.videostore.videostore.domain.repository.MovieRepository;
import com.videostore.videostore.domain.repository.RentalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetRentalsByMovieUseCaseImpl implements GetRentalsByMovieUseCase {

    private final RentalRepository rentalRepository;
    private final MovieRepository movieRepository;

    public GetRentalsByMovieUseCaseImpl(RentalRepository rentalRepository, MovieRepository movieRepository) {
        this.rentalRepository = rentalRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rental> execute(Long movieId) {
        Movie movie = movieRepository.findById(new MovieId(movieId))
                .orElseThrow(() -> new MovieNotFoundException(movieId));

        return rentalRepository.findAllByMovie(movie.getId());
    }
}
