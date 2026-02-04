package com.videostore.videostore.web.controller.user.dto.response;

import com.videostore.videostore.domain.model.user.Role;
import com.videostore.videostore.domain.model.user.User;

public record UserResponse(
        Long id,
        String name,
        String surname,
        String username,
        String email,
        Role role
) {
    public static UserResponse fromDomain(User user) {
        return new UserResponse(
                user.getId().value(),
                user.getName().value(),
                user.getSurname().value(),
                user.getUsername().value(),
                user.getEmail().value(),
                user.getRole()
        );
    }
}