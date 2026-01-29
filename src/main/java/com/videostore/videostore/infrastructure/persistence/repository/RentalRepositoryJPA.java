package com.videostore.videostore.infrastructure.persistence.repository;

import com.videostore.videostore.infrastructure.persistence.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepositoryJPA extends JpaRepository<RentalEntity, Long> {
}
