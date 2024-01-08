package thread.pp.deadlock.challenge;

import java.util.List;

public class Movie {
    private final String id;
    private final List<Theater> theaters;

    public Movie(String id, List<Theater> theaters) {
        this.id = id;
        this.theaters = theaters;
    }

    public synchronized void addTheatre(Theater theater) {
        theaters.add(theater);
        theater.addMovie(id); // alien method -> nested synchronization
    }

    public synchronized String getId() {
        return id;
    }
}
