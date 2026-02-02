package com.videostore.videostore.web.controller.favourite;

import com.videostore.videostore.application.command.favourite.AddFavouriteCommand;
import com.videostore.videostore.application.command.favourite.RemoveFavouriteCommand;
import com.videostore.videostore.application.port.in.favourite.AddFavouriteUseCase;
import com.videostore.videostore.application.port.in.favourite.RemoveFavouriteUseCase;
import com.videostore.videostore.application.usecase.favourite.GetFavouritesByUserUseCaseImpl;
import com.videostore.videostore.domain.model.favourite.Favourite;
import com.videostore.videostore.web.controller.favourite.dto.request.AddFavouriteRequest;
import com.videostore.videostore.web.controller.favourite.dto.response.FavouriteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavouriteController {

    private final AddFavouriteUseCase addFavouriteUseCase;
    private final RemoveFavouriteUseCase removeFavouriteUseCase;
    private final GetFavouritesByUserUseCaseImpl getFavouritesByUserUseCase;

    public FavouriteController(AddFavouriteUseCase addFavouriteUseCase, RemoveFavouriteUseCase removeFavouriteUseCase, GetFavouritesByUserUseCaseImpl getFavouritesByUserUseCase) {
        this.addFavouriteUseCase = addFavouriteUseCase;
        this.removeFavouriteUseCase = removeFavouriteUseCase;
        this.getFavouritesByUserUseCase = getFavouritesByUserUseCase;
    }

    @PostMapping("/favourites")
    public ResponseEntity<FavouriteResponse> addFavourite(@RequestBody AddFavouriteRequest request) {
        AddFavouriteCommand command = new AddFavouriteCommand(request.userId(), request.movieId());
        Favourite favourite = addFavouriteUseCase.execute(command);

        FavouriteResponse response = FavouriteResponse.fromDomain(favourite);
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/favourites/{userId}/{movieId}")
    public ResponseEntity<Void> removeFavourite(@PathVariable Long userId, @PathVariable Long movieId) {
        RemoveFavouriteCommand command = new RemoveFavouriteCommand(userId, movieId);
        removeFavouriteUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}/favourites")
    public ResponseEntity<List<FavouriteResponse>> getFavouritesByUser(@PathVariable Long userId) {
        List<FavouriteResponse> response = getFavouritesByUserUseCase.execute(userId)
                .stream().map(FavouriteResponse::fromDomain).toList();

        return ResponseEntity.ok(response);
    }
}
