package com.videostore.videostore.application.command.user;

public record LoginUserCommand(
        String usernameOrEmail,
        String password
) {
}
