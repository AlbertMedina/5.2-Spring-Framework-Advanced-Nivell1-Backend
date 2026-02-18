package com.videostore.videostore.web.controller.movie.dto.response;

import com.videostore.videostore.domain.common.PagedResult;
import com.videostore.videostore.domain.model.movie.Movie;

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
    public static PagedMovieResponse from(PagedResult<Movie> result) {
        return new PagedMovieResponse(
                result.getContent().stream()
                        .map(MovieResponse::fromDomain)
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