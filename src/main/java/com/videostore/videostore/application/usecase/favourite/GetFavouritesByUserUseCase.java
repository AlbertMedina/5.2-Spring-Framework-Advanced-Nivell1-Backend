package com.videostore.videostore.application.usecase.favourite;

import com.videostore.videostore.domain.model.favourite.Favourite;
import com.videostore.videostore.domain.repository.FavouriteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetFavouritesByUserUseCase {

    private final FavouriteRepository favouriteRepository;

    public GetFavouritesByUserUseCase(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @Transactional(readOnly = true)
    public List<Favourite> execute(Long userId) {
        return favouriteRepository.findAllByUser(userId);
    }
}
