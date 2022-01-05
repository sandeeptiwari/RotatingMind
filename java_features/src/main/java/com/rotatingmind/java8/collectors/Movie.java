package com.rotatingmind.java8.collectors;

import java.util.HashSet;
import java.util.Set;

public class Movie {
    private String title;
    private Integer releaseYear;

    private Set<Actor> actors = new HashSet<>();

    public Movie(String title, Integer releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public Set<Actor> getActors() {
        return actors;
    }
}
