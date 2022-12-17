package src.main.models;

import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Item item : this.items) {
            temp.append(item.toString());
            temp.append("\n");
        }
        return temp.toString();
    }

    public boolean add(Item item) {
        if (items.contains(item)) return false;
        items.add(item);
        return true;
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }

    public void remove(String name) {
        if (items.isEmpty()) throw new IllegalStateException("Cannot remove from empty Cart");
        items.removeIf((e) -> e.getName().equals(name));
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}
