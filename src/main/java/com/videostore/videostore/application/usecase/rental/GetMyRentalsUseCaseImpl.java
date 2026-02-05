package com.videostore.videostore.application.usecase.rental;

import com.videostore.videostore.application.port.in.rental.GetMyRentalsUseCase;
import com.videostore.videostore.application.port.in.rental.GetRentalsByUserUseCase;
import com.videostore.videostore.domain.exception.notfound.UserNotFoundException;
import com.videostore.videostore.domain.model.rental.Rental;
import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.domain.model.user.valueobject.Username;
import com.videostore.videostore.domain.repository.RentalRepository;
import com.videostore.videostore.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetMyRentalsUseCaseImpl implements GetMyRentalsUseCase {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;

    public GetMyRentalsUseCaseImpl(RentalRepository rentalRepository, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rental> execute(String username) {
        Username usernameVo = new Username(username);
        User user = userRepository.findByUsername(usernameVo)
                .orElseThrow(() -> new UserNotFoundException(username));

        return rentalRepository.findAllByUser(user.getId());
    }
}

