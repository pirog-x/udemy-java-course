package src.main.models;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public String toString() {
        String temp = "";
        for (Movie movie : this.movies) {
            temp += movie.toString();
            temp += "\n\n";
        }
        return temp;
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }

    public void sellMovie(String name) {
        movies.removeIf(m -> m.getName().equals(name));
    }

    public void rentMovie(String name) {
        movies.get(getMovieIndex(name)).setAvailable(false);
    }

    public int getMovieIndex(String name) {
        return IntStream.range(0, movies.size())
                .filter((i) -> movies.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1000);
    }

    public void returnMovie(String name) {
        movies.get(getMovieIndex(name)).setAvailable(true);
    }
}
