package com.videostore.videostore.domain.repository;

import com.videostore.videostore.domain.model.movie.Movie;
import com.videostore.videostore.domain.model.movie.MovieSortBy;
import com.videostore.videostore.domain.model.movie.valueobject.MovieId;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    Optional<Movie> findById(MovieId id);

    boolean existsById(MovieId id);

    List<Movie> findAll(int page, int size, String genre, boolean onlyAvailable, String title, MovieSortBy sortBy, boolean ascending);

    Movie addMovie(Movie movie);

    Movie updateMovie(Movie movie);

    void removeMovie(MovieId movieId);
}
