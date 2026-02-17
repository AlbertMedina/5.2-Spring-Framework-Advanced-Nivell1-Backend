package com.videostore.videostore.application.usecase.movie;

import com.videostore.videostore.application.port.in.movie.GetAllGenresUseCase;
import com.videostore.videostore.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetAllGenresUseCaseImpl implements GetAllGenresUseCase {

    private final MovieRepository movieRepository;

    public GetAllGenresUseCaseImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> execute() {
        return movieRepository.findAllGenres();
    }
}
