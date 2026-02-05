package com.videostore.videostore.application.command.favourite;

public record RemoveFavouriteCommand(
        String username,
        Long movieId
) {
}
