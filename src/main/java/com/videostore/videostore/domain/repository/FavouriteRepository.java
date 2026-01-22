package com.videostore.videostore.domain.repository;

import com.videostore.videostore.domain.model.Favourite;

import java.util.List;

public interface FavouriteRepository {
    
    List<Favourite> findByUser(Long userId);

    Favourite save(Favourite favourite);

    void deleteById(Long id);
}
