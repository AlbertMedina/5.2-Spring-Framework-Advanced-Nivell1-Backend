package com.videostore.videostore.domain.service;

import com.videostore.videostore.domain.model.Movie;

public class RentalDomainService {

    public void validateRental(Movie movie, boolean hasRentedMovie, int totalActiveRentalsOfMovie) {
        if (hasRentedMovie) {
            throw new RuntimeException("User has already rented this movie");
        }

        if (totalActiveRentalsOfMovie >= movie.getNumberOfCopies()) {
            throw new RuntimeException("No copies available for this movie");
        }
    }

    public void validateReturn(boolean hasRentedMovie) {
        if (!hasRentedMovie) {
            throw new RuntimeException("User cannot return a movie they haven't rented");
        }
    }
}
