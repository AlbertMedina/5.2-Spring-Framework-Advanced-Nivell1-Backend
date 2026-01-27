package com.videostore.videostore.application.command.user;

public record RegisterUserCommand(
        String name,
        String surname,
        String username,
        String email,
        String password
) {
}
