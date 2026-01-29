package com.videostore.videostore.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "favourites")
public class FavouriteEntity {

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
    private LocalDate favouriteDate;

    protected FavouriteEntity() {
    }

    public FavouriteEntity(UserEntity user, MovieEntity movie, LocalDate favouriteDate) {
        this.user = user;
        this.movie = movie;
        this.favouriteDate = favouriteDate;
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

    public LocalDate getFavouriteDate() {
        return favouriteDate;
    }
}
