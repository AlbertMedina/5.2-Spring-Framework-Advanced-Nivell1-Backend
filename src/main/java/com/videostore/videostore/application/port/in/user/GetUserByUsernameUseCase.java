package com.videostore.videostore.application.port.in.user;

import com.videostore.videostore.domain.model.user.User;

public interface GetUserByUsernameUseCase {
    User execute(String username);
}
