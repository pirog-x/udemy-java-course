package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.models.Movie;
import src.main.models.Store;

import static org.junit.jupiter.api.Assertions.*;


public class StoreTest {
    private Store store;

    @BeforeEach
    public void setup() {
        store = new Store();
        store.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        store.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
    }

    @Test
    public void movieAdded() {
        assertTrue(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void sellMovieTest() {
        store.sellMovie("The Godfather");
        assertFalse(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void rentMovieTest() {
        String name = "The Godfather";
        store.rentMovie(name);
        assertFalse(store.getMovie(1).isAvailable());
    }

    @Test
    public void returnMovieTest() {
        String name = "The Godfather";
        store.rentMovie(name);
        store.returnMovie(name);
        assertTrue(store.getMovie(1).isAvailable());
    }

    @Test
    public void movieNotInStock() {
        String name = "The Godfather";
        store.rentMovie(name);
        Assertions.assertThrows(IllegalStateException.class, () -> store.sellMovie(name));
    }
}
