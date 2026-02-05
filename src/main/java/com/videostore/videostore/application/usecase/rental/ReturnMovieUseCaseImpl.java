package com.videostore.videostore.application.usecase.rental;

import com.videostore.videostore.application.command.rental.ReturnMovieCommand;
import com.videostore.videostore.application.port.in.rental.ReturnMovieUseCase;
import com.videostore.videostore.domain.exception.notfound.RentalNotFoundException;
import com.videostore.videostore.domain.exception.notfound.UserNotFoundException;
import com.videostore.videostore.domain.model.movie.valueobject.MovieId;
import com.videostore.videostore.domain.model.rental.Rental;
import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.domain.model.user.valueobject.Username;
import com.videostore.videostore.domain.repository.RentalRepository;
import com.videostore.videostore.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReturnMovieUseCaseImpl implements ReturnMovieUseCase {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;

    public ReturnMovieUseCaseImpl(RentalRepository rentalRepository, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void execute(ReturnMovieCommand command) {
        Username username = new Username(command.username());
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username.value()));

        Rental rental = rentalRepository.findByUserIdAndMovieId(user.getId(), new MovieId(command.movieId()))
                .orElseThrow(() -> new RentalNotFoundException("User cannot return a movie they haven't rented"));

        rentalRepository.removeRental(rental.getId());
    }
}
