package com.videostore.videostore.application.usecase.user;

import com.videostore.videostore.application.port.in.user.GetUserByUsernameUseCase;
import com.videostore.videostore.domain.exception.notfound.UserNotFoundException;
import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.domain.model.user.valueobject.Username;
import com.videostore.videostore.domain.repository.UserRepository;

public class GetUserByUsernameUseCaseImpl implements GetUserByUsernameUseCase {

    private final UserRepository userRepository;

    public GetUserByUsernameUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(String username) {
        return userRepository.findByUsername(new Username(username))
                .orElseThrow(() -> new UserNotFoundException(username));
    }
}
