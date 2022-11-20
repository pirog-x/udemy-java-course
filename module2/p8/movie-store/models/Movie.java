package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;
        this.rentalPrice = format.equals("Blue-Ray") ? 1.99 : 0.99;
    }

    public Movie(Movie m) {
        this.name = m.name;
        this.format = m.format;
        this.rating = m.rating;
        this.sellingPrice = m.sellingPrice;
        this.rentalPrice = m.rentalPrice;
        this.isAvailable = m.isAvailable;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }


    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setFormat(String format) {
        this.format = format;
        setSellingPrice(format.equals("Blue-Ray") ? 4.25 : 2.25);
        setRentalPrice(format.equals("Blue-Ray") ? 1.99 : 0.99);
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private void setSellingPrice(double price) {
        this.sellingPrice = price;
    }

    private void setRentalPrice(double price) {
        this.rentalPrice = price;
    }


    // methods
    public String toString() {
        return "\t Name: " + name + "\n" +
                "\t Format: " + format + "\n" +
                "\t Rating: " + rating + "\n" +
                "\t Selling Price: " + sellingPrice + "\n" +
                "\t Rental Price: " + rentalPrice + "\n" +
                "\t Availability: " + (isAvailable ? "in-stock" : "rented") + "\n";
    }
}
