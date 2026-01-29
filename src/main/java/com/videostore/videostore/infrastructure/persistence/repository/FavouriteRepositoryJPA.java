package com.videostore.videostore.infrastructure.persistence.repository;

import com.videostore.videostore.infrastructure.persistence.entity.FavouriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteRepositoryJPA extends JpaRepository<FavouriteEntity, Long> {
}
