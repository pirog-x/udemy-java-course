class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Item source) {
        this.name = source.getName();
        this.price = source.getPrice();
        this.quantity = source.getQuantity();
    }


    // setters
    public void setQuantity(int quantity) {
        if (quantity < 0) return;
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        if (price < 0) return;
        this.price = price;
    }

    public void setName(String name) {
        if (name == null) return;
        this.name = name;
    }


    // getters
    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
    
    public String getName() {
        return this.name;
    }

    
    // methods
    public String toString() {
        return "name: " + this.name + ", price: " + this.price + ", quantity: " + this.quantity;
    }
};
