package com.videostore.videostore.domain.model.rental.valueobject;

import java.time.LocalDate;

public record RentalDate(LocalDate value) {

    public RentalDate {
        if (value == null) {
            throw new IllegalArgumentException("Rental date cannot be null");
        }
        if (value.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Rental date cannot be in the future");
        }
    }
}
