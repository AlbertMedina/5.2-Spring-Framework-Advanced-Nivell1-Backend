package com.videostore.videostore.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private MovieEntity movie;

    @Column(nullable = false)
    private int rating;

    @Column(length = 500, nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDate reviewDate;

    protected ReviewEntity() {
    }

    public ReviewEntity(UserEntity user, MovieEntity movie, int rating, String comment, LocalDate reviewDate) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }
}
