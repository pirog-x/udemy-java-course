package src.main.models;

import java.text.DecimalFormat;
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

    public double getTax(double subtotal) {
        final double tax = 0.13;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(subtotal * tax));
    }

    public double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

    public String checkout() {
        if (items.isEmpty()) throw new IllegalStateException("Cart is empty");
        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + getSubtotal() + "\n" +
                "\tTax: $" + getTax(getSubtotal()) + "\n" +
                "\tTotal: $" + getTotal(getSubtotal(), getTax(getSubtotal())) + "\n";
    }

    public void clear() {
        if (items.isEmpty()) return;
        items.clear();
    }
}
