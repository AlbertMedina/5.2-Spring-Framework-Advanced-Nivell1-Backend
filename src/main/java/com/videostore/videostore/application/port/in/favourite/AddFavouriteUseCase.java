package com.videostore.videostore.application.port.in.favourite;

import com.videostore.videostore.application.command.favourite.AddFavouriteCommand;
import com.videostore.videostore.application.model.FavouriteDetails;

public interface AddFavouriteUseCase {
    FavouriteDetails execute(AddFavouriteCommand addFavouriteCommand);
}
