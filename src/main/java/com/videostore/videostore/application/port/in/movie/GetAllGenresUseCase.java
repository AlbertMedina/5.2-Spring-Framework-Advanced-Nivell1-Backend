package com.videostore.videostore.application.port.in.movie;

import java.util.List;

public interface GetAllGenresUseCase {
    List<String> execute();
}
