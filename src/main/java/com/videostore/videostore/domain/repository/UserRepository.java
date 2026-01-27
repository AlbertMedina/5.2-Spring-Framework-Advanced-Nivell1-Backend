package com.videostore.videostore.domain.repository;

import com.videostore.videostore.domain.model.user.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    User registerUser(User user);

    void removeUser(User user);
}
