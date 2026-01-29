package com.videostore.videostore.infrastructure.persistence.repository;

import com.videostore.videostore.infrastructure.persistence.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RentalRepositoryJPA extends JpaRepository<RentalEntity, Long> {

    Optional<RentalEntity> findByUserIdAndMovieId(Long userId, Long movieId);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);

    List<RentalEntity> findAllByUserId(Long userId);

    List<RentalEntity> findAllByMovieId(Long movieId);

    int countByMovieId(Long movieId);
}
