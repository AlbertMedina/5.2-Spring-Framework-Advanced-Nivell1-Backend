package com.videostore.videostore.infrastructure.persistance.repository;

import com.videostore.videostore.infrastructure.persistance.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepositoryJPA extends JpaRepository<RentalEntity, Long> {
}
