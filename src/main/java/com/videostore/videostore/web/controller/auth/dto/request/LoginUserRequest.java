package com.videostore.videostore.web.controller.auth.dto.request;

public record LoginUserRequest(
        String loginIdentifier,
        String password
) {
}
