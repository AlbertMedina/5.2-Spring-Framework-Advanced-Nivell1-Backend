package com.videostore.videostore.infrastructure.persistence.adapter;

import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.domain.model.user.valueobject.UserId;
import com.videostore.videostore.domain.repository.UserRepository;
import com.videostore.videostore.infrastructure.persistence.entity.UserEntity;
import com.videostore.videostore.infrastructure.persistence.mapper.UserMapper;
import com.videostore.videostore.infrastructure.persistence.repository.UserRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;

    public UserRepositoryImpl(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @Override
    public Optional<User> findById(UserId id) {
        return userRepositoryJPA.findById(id.value())
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepositoryJPA.findByUsername(username)
                .map(UserMapper::toDomain);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepositoryJPA.existsByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepositoryJPA.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepositoryJPA.existsByEmail(email);
    }

    @Override
    public User registerUser(User user) {
        UserEntity entity = UserMapper.toEntity(user);

        return UserMapper.toDomain(userRepositoryJPA.save(entity));
    }

    @Override
    public void removeUser(User user) {
        UserEntity entity = UserMapper.toEntity(user);

        userRepositoryJPA.delete(entity);
    }
}
