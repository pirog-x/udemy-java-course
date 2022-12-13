package src.main.models;

import java.util.ArrayList;

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
}
