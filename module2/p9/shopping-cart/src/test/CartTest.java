package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.models.Cart;
import src.main.models.Item;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    Cart cart;

    @BeforeEach
    public void setup() {
        cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }

    @Test
    public void itemAddedTest() {
        assertTrue(cart.contains(new Item("Pepsi", 1.99)));
        assertTrue(cart.contains(new Item("Crush", 1.99)));
    }

    @Test
    public void skipsDuplicate() {
        assertFalse(cart.add(new Item("Pepsi", 1.99)));
        assertTrue(cart.add(new Item("Karakum", 1.89)));
    }

    @Test
    public void removedItemTest() {
        cart.remove("Crush");
        assertFalse(cart.contains(new Item("Crush", 1.99)));
    }

    @Test
    public void subtotalIsValid() {
        double subtotal = 1.99 * 2;
        assertEquals(subtotal, cart.getSubtotal());
    }
}
