package com.videostore.videostore.web.controller.auth.dto.request;

public record RegisterUserRequest(
        String name,
        String surname,
        String username,
        String email,
        String password
) {
}
