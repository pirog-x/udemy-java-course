package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public boolean add(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }
        if (items.contains(item)) {
            return false;
        }
        items.add(new Item(item));
        return true;
    }

    public void remove(String name) {
        if (items.isEmpty()) {
            throw new IllegalStateException("cannot remove elements from empty list");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }

        for (Item i : items) {
            if (i.getName().equals(name)) {
                items.remove(i);
                return;
            }
        }
    }

    public String checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("list is empty");
        }
        double priceWithoutTax = 0;

        for (Item i : items) {
            priceWithoutTax += i.getPrice();
        }
        double taxPrice = 0.13 * priceWithoutTax;
        double totalPrice = priceWithoutTax + taxPrice;

        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + priceWithoutTax + "\n" +
                "\tTax: $" + taxPrice + "\n" +
                "\tTotal: $" + totalPrice + "\n";
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Item i : items) {
            result.append(i).append("\n");
        }
        return result.toString();
    }

    public int size() {
        return this.items.size();
    }
}
