package com.videostore.videostore.web.controller.user.dto.request;

import jakarta.validation.constraints.*;

public record LoginUserRequest(
        @NotNull @NotBlank String loginIdentifier,
        @NotNull @NotBlank String password
) {
}
