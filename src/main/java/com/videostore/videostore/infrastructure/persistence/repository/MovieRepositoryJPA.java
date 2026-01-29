package com.videostore.videostore.infrastructure.persistence.repository;

import com.videostore.videostore.infrastructure.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepositoryJPA extends JpaRepository<MovieEntity, Long> {
}
