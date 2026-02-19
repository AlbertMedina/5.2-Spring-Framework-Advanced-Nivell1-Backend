package com.videostore.videostore.web.controller.movie.dto.response;

import com.videostore.videostore.application.model.MovieDetails;
import com.videostore.videostore.domain.common.PagedResult;

import java.util.List;

public record PagedMovieResponse(
        List<MovieResponse> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean hasNext,
        boolean hasPrevious
) {
    public static PagedMovieResponse from(PagedResult<MovieDetails> result) {
        return new PagedMovieResponse(
                result.getContent().stream()
                        .map(MovieResponse::from)
                        .toList(),
                result.getPage(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.hasNext(),
                result.hasPrevious()
        );
    }
}
