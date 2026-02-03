package com.videostore.videostore.application.command.user;

public record LoginUserCommand(
        String loginIdentifier,
        String password
) {
}
