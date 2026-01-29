package com.videostore.videostore.domain.model.rental;

import com.videostore.videostore.domain.model.movie.valueobject.MovieId;
import com.videostore.videostore.domain.model.rental.valueobject.RentalDate;
import com.videostore.videostore.domain.model.rental.valueobject.RentalId;
import com.videostore.videostore.domain.model.user.valueobject.UserId;

public class Rental {

    private final RentalId id;
    private final UserId userId;
    private final MovieId movieId;
    private final RentalDate rentalDate;

    public Rental(RentalId id, UserId userId, MovieId movieId, RentalDate rentalDate) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.rentalDate = rentalDate;
    }

    public RentalId getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public RentalDate getRentalDate() {
        return rentalDate;
    }

    public static Rental create(RentalId id, UserId userId, MovieId movieId, RentalDate rentalDate) {
        return new Rental(id, userId, movieId, rentalDate);
    }
}
