package com.videostore.videostore.application.usecase.rental;

import com.videostore.videostore.application.port.in.rental.GetRentalsByUserUseCase;
import com.videostore.videostore.domain.exception.notfound.MovieNotFoundException;
import com.videostore.videostore.domain.exception.notfound.UserNotFoundException;
import com.videostore.videostore.domain.model.movie.Movie;
import com.videostore.videostore.domain.model.movie.valueobject.MovieId;
import com.videostore.videostore.domain.model.rental.Rental;
import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.domain.model.user.valueobject.UserId;
import com.videostore.videostore.domain.repository.MovieRepository;
import com.videostore.videostore.domain.repository.RentalRepository;
import com.videostore.videostore.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetRentalsByUserUseCaseImpl implements GetRentalsByUserUseCase {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;

    public GetRentalsByUserUseCaseImpl(RentalRepository rentalRepository, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rental> execute(Long userId) {
        User user = userRepository.findById(new UserId(userId))
                .orElseThrow(() -> new UserNotFoundException(userId));

        return rentalRepository.findAllByUser(user.getId());
    }
}
