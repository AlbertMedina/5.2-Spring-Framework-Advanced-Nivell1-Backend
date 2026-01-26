package com.videostore.videostore.domain.model.rental;

import com.videostore.videostore.domain.model.movie.Movie;
import com.videostore.videostore.domain.model.rental.valueobject.RentalDate;
import com.videostore.videostore.domain.model.user.User;

public class Rental {

    private final User user;
    private final Movie movie;
    private final RentalDate rentalDate;

    public Rental(User user, Movie movie, RentalDate rentalDate) {
        this.user = user;
        this.movie = movie;
        this.rentalDate = rentalDate;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public RentalDate getRentalDate() {
        return rentalDate;
    }
}
