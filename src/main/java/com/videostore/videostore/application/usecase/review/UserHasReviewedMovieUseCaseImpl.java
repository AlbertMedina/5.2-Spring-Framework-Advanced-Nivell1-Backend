package com.videostore.videostore.application.usecase.review;

import com.videostore.videostore.application.port.in.review.UserHasReviewedMovieUseCase;
import com.videostore.videostore.domain.exception.notfound.UserNotFoundException;
import com.videostore.videostore.domain.model.movie.valueobject.MovieId;
import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.domain.model.user.valueobject.Username;
import com.videostore.videostore.domain.repository.ReviewRepository;
import com.videostore.videostore.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserHasReviewedMovieUseCaseImpl implements UserHasReviewedMovieUseCase {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public UserHasReviewedMovieUseCaseImpl(ReviewRepository reviewRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public boolean execute(String username, Long movieId) {
        Username usernameVO = new Username(username);
        User user = userRepository.findByUsername(usernameVO)
                .orElseThrow(() -> new UserNotFoundException(username));

        return reviewRepository.existsByUserIdAndMovieId(user.getId(), new MovieId(movieId));
    }
}
