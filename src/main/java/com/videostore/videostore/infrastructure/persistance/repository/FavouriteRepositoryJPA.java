package com.videostore.videostore.infrastructure.persistance.repository;

import com.videostore.videostore.infrastructure.persistance.entity.FavouriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteRepositoryJPA extends JpaRepository<FavouriteEntity, Long> {
}
