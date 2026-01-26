package com.videostore.videostore.domain.model.review;

import com.videostore.videostore.domain.model.movie.Movie;
import com.videostore.videostore.domain.model.review.valueobject.Comment;
import com.videostore.videostore.domain.model.review.valueobject.Rating;
import com.videostore.videostore.domain.model.user.User;

public class Review {

    private final User user;
    private final Movie movie;
    private final Rating rating;
    private final Comment comment;

    public Review(User user, Movie movie, Rating rating, Comment comment) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public Rating getRating() {
        return rating;
    }

    public Comment getComment() {
        return comment;
    }
}
