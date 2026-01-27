package com.videostore.videostore.application.usecase.user;

import com.videostore.videostore.application.command.user.LoginUserCommand;
import com.videostore.videostore.domain.exception.InvalidCredentialsException;
import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginUserUseCase {

    private final UserRepository userRepository;

    public LoginUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User execute(LoginUserCommand command) {
        User user = userRepository.findByUsername(command.usernameOrEmail())
                .or(() -> userRepository.findByEmail(command.usernameOrEmail()))
                .orElseThrow(InvalidCredentialsException::new);

        if (!command.password().equals(user.getPassword().value())) {
            throw new InvalidCredentialsException();
        }

        return user;
    }
}
