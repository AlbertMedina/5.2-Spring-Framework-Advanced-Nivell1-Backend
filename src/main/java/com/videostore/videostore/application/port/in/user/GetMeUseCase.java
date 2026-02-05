package com.videostore.videostore.application.port.in.user;

import com.videostore.videostore.domain.model.user.User;

public interface GetMeUseCase {
    User execute(String username);
}
