package com.videostore.videostore.infrastructure.security;

import com.videostore.videostore.application.port.in.user.GetUserByUsernameUseCase;
import com.videostore.videostore.domain.exception.notfound.UserNotFoundException;
import com.videostore.videostore.domain.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private final GetUserByUsernameUseCase getUserByUsernameUseCase;

    public CustomUserDetailsService(GetUserByUsernameUseCase getUserByUsernameUseCase) {
        this.getUserByUsernameUseCase = getUserByUsernameUseCase;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = getUserByUsernameUseCase.execute(username);
            return new UserDetailsAdapter(user);
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
