package com.videostore.videostore.infrastructure.persistance.repository;

import com.videostore.videostore.infrastructure.persistance.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositoryJPA extends JpaRepository<ReviewEntity, Long> {
}
