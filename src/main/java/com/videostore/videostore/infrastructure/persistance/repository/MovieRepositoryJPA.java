package com.videostore.videostore.infrastructure.persistance.repository;

import com.videostore.videostore.infrastructure.persistance.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepositoryJPA extends JpaRepository<MovieEntity, Long> {
}
