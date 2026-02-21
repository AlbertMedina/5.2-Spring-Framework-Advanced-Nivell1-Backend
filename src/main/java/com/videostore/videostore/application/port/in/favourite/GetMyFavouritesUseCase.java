package com.videostore.videostore.application.port.in.favourite;

import com.videostore.videostore.application.model.FavouriteDetails;

import java.util.List;

public interface GetMyFavouritesUseCase {
    List<FavouriteDetails> execute(String username);
}
