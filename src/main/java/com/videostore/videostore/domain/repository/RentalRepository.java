package com.videostore.videostore.domain.repository;

import com.videostore.videostore.domain.model.Rental;

import java.util.List;
import java.util.Optional;

public interface RentalRepository {

    Optional<Rental> findById(Long id);

    List<Rental> findAll();

    List<Rental> findAllByUser(Long userId);

    List<Rental> findAllByMovie(Long userId);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);

    int activeRentalsByMovie(Long movieId);

    Rental save(Rental rental);

    void deleteById(Long id);
}
