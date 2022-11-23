package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Item getItem(int index) {
        return new Item(items.get(index));
    }

    public void setItems(int index, Item item) {
        items.set(index, new Item(item));
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
        double tax = 13;
        double priceWithoutTax = 0;

        for (Item i : items) {
            priceWithoutTax += i.getPrice();
        }
        double taxPrice = (tax / priceWithoutTax) * 100;
        double totalPrice = priceWithoutTax + taxPrice;

        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + priceWithoutTax + "\n" +
                "\tTax: $" + tax + "\n" +
                "\tTotal: $" + totalPrice + "\n";
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Item i : items) {
            result.append(i).append("\n");
        }
        return result.toString();
    }
}
