package com.videostore.videostore.domain.repository;

import com.videostore.videostore.domain.model.favourite.Favourite;
import com.videostore.videostore.domain.model.movie.Movie;
import com.videostore.videostore.domain.model.user.User;

import java.util.List;

public interface FavouriteRepository {

    List<Favourite> findByUser(Long userId);

    boolean exists(User user, Movie movie);

    Favourite save(Favourite favourite);

    void deleteById(Long id);
}
