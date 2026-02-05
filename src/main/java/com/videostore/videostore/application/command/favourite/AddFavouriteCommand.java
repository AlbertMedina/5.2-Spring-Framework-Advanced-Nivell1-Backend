package com.videostore.videostore.application.command.favourite;

public record AddFavouriteCommand(
        String username,
        Long movieId
) {
}
