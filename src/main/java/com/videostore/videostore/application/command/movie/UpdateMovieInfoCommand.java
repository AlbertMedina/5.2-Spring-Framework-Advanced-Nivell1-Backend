package com.videostore.videostore.application.command.movie;

public class UpdateMovieInfoCommand {

    private final String title;
    private final int year;
    private final String genre;
    private final int duration;
    private final String director;
    private final String synopsis;

    public UpdateMovieInfoCommand(String title, int year, String genre, int duration, String director, String synopsis) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.synopsis = synopsis;
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
}
