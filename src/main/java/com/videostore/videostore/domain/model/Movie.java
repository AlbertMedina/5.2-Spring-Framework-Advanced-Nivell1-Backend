package com.videostore.videostore.domain.model;

public class Movie {

    private final Long id;
    private final String title;
    private final int year;
    private final String genre;
    private final int duration;
    private final String director;
    private final String synopsis;
    private final int numberOfCopies;

    public Movie(Long id, String title, int year, String genre, int duration, String director, String synopsis, int numberOfCopies) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.synopsis = synopsis;
        this.numberOfCopies = numberOfCopies;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }
}
