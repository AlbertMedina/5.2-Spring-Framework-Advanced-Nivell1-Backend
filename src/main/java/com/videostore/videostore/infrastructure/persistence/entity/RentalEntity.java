package com.videostore.videostore.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "rentals")
public class RentalEntity {

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
    private LocalDate rentalDate;

    protected RentalEntity() {
    }

    public RentalEntity(UserEntity user, MovieEntity movie, LocalDate rentalDate) {
        this.user = user;
        this.movie = movie;
        this.rentalDate = rentalDate;
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

    public LocalDate getRentalDate() {
        return rentalDate;
    }
}
