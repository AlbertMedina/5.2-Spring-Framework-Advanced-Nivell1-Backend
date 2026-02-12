package com.videostore.videostore.application.usecase.movie;

import com.cloudinary.Cloudinary;
import com.videostore.videostore.application.port.in.movie.RemoveMovieUseCase;
import com.videostore.videostore.domain.exception.conflict.MovieHasActiveRentalsException;
import com.videostore.videostore.domain.exception.notfound.MovieNotFoundException;
import com.videostore.videostore.domain.model.movie.Movie;
import com.videostore.videostore.domain.model.movie.valueobject.MovieId;
import com.videostore.videostore.domain.repository.MovieRepository;
import com.videostore.videostore.domain.repository.RentalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;

@Service
public class RemoveMovieUseCaseImpl implements RemoveMovieUseCase {

    private final MovieRepository movieRepository;
    private final RentalRepository rentalRepository;
    private final Cloudinary cloudinary;

    public RemoveMovieUseCaseImpl(MovieRepository movieRepository, RentalRepository rentalRepository, Cloudinary cloudinary) {
        this.movieRepository = movieRepository;
        this.rentalRepository = rentalRepository;
        this.cloudinary = cloudinary;
    }

    @Override
    @Transactional
    public void execute(Long movieId) {
        MovieId id = new MovieId(movieId);

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(movieId));

        validateMovieRemoval(id);

        if (movie.getPosterUrl() != null) {
            try {
                String publicId = extractPublicIdFromUrl(movie.getPosterUrl().value());
                cloudinary.uploader().destroy(publicId, Map.of());
            } catch (IOException e) {
                throw new RuntimeException("Failed to delete movie poster from Cloudinary", e);
            }
        }

        movieRepository.removeMovie(id);
    }

    private void validateMovieRemoval(MovieId movieId) {
        if (rentalRepository.countRentalsByMovie(movieId) > 0) {
            throw new MovieHasActiveRentalsException("Cannot remove movie with active rentals");
        }
    }

    private String extractPublicIdFromUrl(String url) {
        int folderIndex = url.indexOf("/movies/");
        if (folderIndex < 0) {
            throw new IllegalArgumentException("Invalid Cloudinary URL: " + url);
        }
        String pathWithFile = url.substring(folderIndex + 1);
        int dotIndex = pathWithFile.lastIndexOf('.');
        return dotIndex >= 0 ? pathWithFile.substring(0, dotIndex) : pathWithFile;
    }
}