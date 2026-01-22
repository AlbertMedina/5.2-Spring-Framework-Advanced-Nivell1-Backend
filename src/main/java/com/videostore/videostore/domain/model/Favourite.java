package com.videostore.videostore.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "favourites")
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long userId;
    public Long movieId;
    public LocalDate date;

    public Favourite() {
    }

    public Favourite(Long userId, Long movieId, LocalDate date) {
        this.userId = userId;
        this.movieId = movieId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public LocalDate getDate() {
        return date;
    }
}
