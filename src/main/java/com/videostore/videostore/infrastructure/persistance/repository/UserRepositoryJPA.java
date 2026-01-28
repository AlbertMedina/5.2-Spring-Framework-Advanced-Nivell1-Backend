package com.videostore.videostore.infrastructure.persistance.repository;

import com.videostore.videostore.infrastructure.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {
}
