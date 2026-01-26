package com.videostore.videostore.domain.model.movie;

public class Movie {

    private String title;
    private int year;
    private String genre;
    private int duration;
    private String director;
    private String synopsis;
    private final int numberOfCopies;

    public Movie(String title, int year, String genre, int duration, String director, String synopsis, int numberOfCopies) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.synopsis = synopsis;
        this.numberOfCopies = numberOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public static Movie create(String title, int year, String genre, int duration, String director, String synopsis, int numberOfCopies) {
        return new Movie(title, year, genre, duration, director, synopsis, numberOfCopies);
    }
}
