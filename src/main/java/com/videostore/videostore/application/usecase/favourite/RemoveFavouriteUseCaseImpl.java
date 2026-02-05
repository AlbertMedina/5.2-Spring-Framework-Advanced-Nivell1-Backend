package com.videostore.videostore.application.usecase.favourite;

import com.videostore.videostore.application.command.favourite.RemoveFavouriteCommand;
import com.videostore.videostore.application.port.in.favourite.RemoveFavouriteUseCase;
import com.videostore.videostore.domain.exception.notfound.FavouriteNotFoundException;
import com.videostore.videostore.domain.exception.notfound.UserNotFoundException;
import com.videostore.videostore.domain.model.favourite.Favourite;
import com.videostore.videostore.domain.model.movie.valueobject.MovieId;
import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.domain.model.user.valueobject.Username;
import com.videostore.videostore.domain.repository.FavouriteRepository;
import com.videostore.videostore.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemoveFavouriteUseCaseImpl implements RemoveFavouriteUseCase {

    private final FavouriteRepository favouriteRepository;
    private final UserRepository userRepository;

    public RemoveFavouriteUseCaseImpl(FavouriteRepository favouriteRepository, UserRepository userRepository) {
        this.favouriteRepository = favouriteRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void execute(RemoveFavouriteCommand command) {
        Username username = new Username(command.username());
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username.value()));

        Favourite favourite = favouriteRepository.findByUserIdAndMovieId(user.getId(), new MovieId(command.movieId()))
                .orElseThrow(() -> new FavouriteNotFoundException("The user cannot remove a movie from favourites if it is not marked as a favourites"));

        favouriteRepository.removeFavourite(favourite.getId());
    }
}
