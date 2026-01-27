package com.videostore.videostore.application.usecase.rental;

import com.videostore.videostore.domain.model.rental.Rental;
import com.videostore.videostore.domain.repository.RentalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetRentalsByUserUseCase {

    private final RentalRepository rentalRepository;

    public GetRentalsByUserUseCase(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Transactional(readOnly = true)
    public List<Rental> execute(Long userId) {
        return rentalRepository.findAllByUser(userId);
    }
}
