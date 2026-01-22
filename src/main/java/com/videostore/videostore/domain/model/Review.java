package com.videostore.videostore.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long userId;
    public Long movieId;
    public int score;
    public String comment;

    public Review() {
    }

    public Review(Long userId, Long movieId, int score, String comment) {
        this.userId = userId;
        this.movieId = movieId;
        this.score = score;
        this.comment = comment;
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

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}
