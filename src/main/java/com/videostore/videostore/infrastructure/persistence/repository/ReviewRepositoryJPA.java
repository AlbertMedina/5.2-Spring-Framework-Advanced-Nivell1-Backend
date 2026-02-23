package com.videostore.videostore.infrastructure.persistence.repository;

import com.videostore.videostore.infrastructure.persistence.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepositoryJPA extends JpaRepository<ReviewEntity, Long> {

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);

    List<ReviewEntity> findAllByUserId(Long userId);

    List<ReviewEntity> findAllByMovieId(Long movieId);

    @Query("SELECT AVG(r.rating), COUNT(r) FROM ReviewEntity r WHERE r.movie.id = :movieId")
    Object findAverageRatingByMovieId(@Param("movieId") Long movieId);

    @Query("SELECT r.movie.id, AVG(r.rating), COUNT(r) FROM ReviewEntity r WHERE r.movie.id IN :movieIds GROUP BY r.movie.id")
    List<Object> findAverageRatingsByMovieIds(@Param("movieIds") List<Long> movieIds);
}
