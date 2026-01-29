package com.videostore.videostore.infrastructure.persistence.repository;

import com.videostore.videostore.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {
}
