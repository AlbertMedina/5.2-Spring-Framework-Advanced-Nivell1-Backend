package com.videostore.videostore.application.port.in.rental;

import com.videostore.videostore.domain.model.rental.Rental;

import java.util.List;

public interface GetMyRentalsUseCase {
    List<Rental> execute(String username);
}
