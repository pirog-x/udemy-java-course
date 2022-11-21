package models;

import java.util.List;
import java.util.ArrayList;

public class Store {
    private final List<Movie> movies;

    public Store() {
        movies = new ArrayList<>();
    }

    public Movie getMovie(int index) {
        return new Movie(movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String name, String action) {
        if (name.isBlank() || action.isBlank()) {
            throw new IllegalArgumentException("name/action cannot be blank/null");
        }

        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                if (action.equalsIgnoreCase("sell")) {
                    movies.remove(m);
                } else if (action.equalsIgnoreCase("rent")) {
                    m.setAvailable(false);
                } else if (action.equalsIgnoreCase("return")) {
                    m.setAvailable(true);
                }
                break;
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Movie m : movies) {
            result.append(m.toString()).append("\n\n");
        }
        return result.toString();
    }
}
