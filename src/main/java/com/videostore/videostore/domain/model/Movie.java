package com.videostore.videostore.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String title;
    public int year;
    public String genre;
    public int duration;
    public String director;
    public String synopsis;

    public Movie() {
    }

    public Movie(String title, int year, String genre, int duration, String director, String synopsis) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.synopsis = synopsis;
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
}
