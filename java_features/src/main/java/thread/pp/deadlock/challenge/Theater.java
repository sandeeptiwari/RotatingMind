package thread.pp.deadlock.challenge;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    private final List<String> movieIds;

    public Theater() {
        this.movieIds = new ArrayList<>();
    }

    public synchronized void addMovie(String id) {
     movieIds.add(id);
    }

    public synchronized boolean isMovieAvailable(Movie movie) {
        return movieIds.contains(movie.getId());
    }
}
