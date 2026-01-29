package com.videostore.videostore.domain.model.favourite;

import com.videostore.videostore.domain.model.favourite.valueobject.FavouriteDate;
import com.videostore.videostore.domain.model.favourite.valueobject.FavouriteId;
import com.videostore.videostore.domain.model.movie.valueobject.MovieId;
import com.videostore.videostore.domain.model.user.valueobject.UserId;

public class Favourite {

    private final FavouriteId id;
    private final UserId userId;
    private final MovieId movieId;
    private final FavouriteDate favouriteDate;

    public Favourite(FavouriteId id, UserId userId, MovieId movieId, FavouriteDate favouriteDate) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.favouriteDate = favouriteDate;
    }

    public FavouriteId getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public FavouriteDate getFavouriteDate() {
        return favouriteDate;
    }

    public static Favourite create(FavouriteId id, UserId userId, MovieId movieId, FavouriteDate favouriteDate) {
        return new Favourite(id, userId, movieId, favouriteDate);
    }
}
