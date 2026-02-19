package com.videostore.videostore.application.port.in.review;

import com.videostore.videostore.application.command.review.AddReviewCommand;
import com.videostore.videostore.application.model.ReviewDetails;

public interface AddReviewUseCase {
    ReviewDetails execute(AddReviewCommand command);
}
