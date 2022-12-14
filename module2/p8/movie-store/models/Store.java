package models;

import java.util.List;
import java.util.ArrayList;

public class Store {
    private final List<Movie> movies;

    public Store() {
        movies = new ArrayList<>();
    }

    public Movie getMovie(int index) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("store is empty");
        }
        return new Movie(movies.get(index));
    }

    public Movie getMovie(String name) {
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                return new Movie(m);
            }
        }
        return null;
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String name, String action) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("store is empty");
        }
        if (name.isBlank() || action.isBlank()) {
            throw new IllegalArgumentException("name/action cannot be blank/null");
        }
        if (!action.equalsIgnoreCase("rent") && !action.equalsIgnoreCase("sell") && !action.equalsIgnoreCase("return")) {
            throw new IllegalArgumentException("wrong action");
        }

        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                if (action.equalsIgnoreCase("sell")) {
                    if (!m.isAvailable()) {
                        throw new IllegalStateException("Cannot sell movie that was rented");
                    }
                    movies.remove(m);
                } else if (action.equalsIgnoreCase("rent")) {
                    if (!m.isAvailable()) {
                        throw new IllegalStateException("movie was sold");
                    }
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

    public boolean isEmpty() {
        return movies.size() == 0;
    }
}
