package com.videostore.videostore.infrastructure.security;

import com.videostore.videostore.application.auth.valueobject.LoginIdentifier;
import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String loginIdentifier) throws UsernameNotFoundException {
        LoginIdentifier identifier;
        try {
            identifier = new LoginIdentifier(loginIdentifier);
        } catch (IllegalArgumentException e) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = userRepository.findByLoginIdentifier(identifier)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername().value())
                .password(user.getPassword().value())
                .roles(user.getRole().name())
                .build();
    }
}
