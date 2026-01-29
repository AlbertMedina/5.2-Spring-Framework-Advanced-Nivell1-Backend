package com.videostore.videostore.infrastructure.persistence.repository;

import com.videostore.videostore.infrastructure.persistence.entity.FavouriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavouriteRepositoryJPA extends JpaRepository<FavouriteEntity, Long> {
    
    Optional<FavouriteEntity> findByUserIdAndMovieId(Long userId, Long movieId);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);

    List<FavouriteEntity> findAllByUserId(Long userId);
}
