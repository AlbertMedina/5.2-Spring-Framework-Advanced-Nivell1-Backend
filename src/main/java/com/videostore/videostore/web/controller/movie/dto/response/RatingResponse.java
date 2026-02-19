package com.videostore.videostore.web.controller.movie.dto.response;

import com.videostore.videostore.domain.common.RatingSummary;

public record RatingResponse(double average, int count) {

    public static RatingResponse from(RatingSummary summary) {
        return new RatingResponse(summary.average(), summary.count());
    }
}
