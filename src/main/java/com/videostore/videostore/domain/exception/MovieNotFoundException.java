package com.videostore.videostore.domain.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("Movie " + id + " not found");
    }
}
