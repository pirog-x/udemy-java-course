class Machine {
    private Item[][] items;
    
    public Machine(Item[][] items) {
        if (items == null) return;
        this.items = new Item[items.length][];
        for (int i = 0; i < items.length; i++) {
            this.items[i] = new Item[items.length];
        }

        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }


    // getters
    public Item getItem(int row, int column) {
        if (items.length <= row || row < 0) return null;
        if (items[row].length <= column || column < 0) return null;
        
        return new Item(items[row][column]);
    }

    public double getItemsPrice(int row, int column) {
        if (items.length <= row || row < 0) return -1;
        if (items[row].length <= column || column < 0) return -1;

        return items[row][column].getPrice();
    }

    public int getItemsQuantity(int row, int column) {
        if (items.length <= row || row < 0) return -1;
        if (items[row].length <= column || column < 0) return -1;

        return items[row][column].getQuantity();
    }

    public String getItemsName(int row, int column) {
        if (items.length <= row || row < 0) return "NaN";
        if (items[row].length <= column || column < 0) return "NaN";

        return items[row][column].getName();
    }


    // setters
    public void setItem(Item item, int row, int column) {
        if (item == null) return;
        items[row][column] = new Item(items[row][column]);
    }

    public void setItemsName(String name, int row, int column) {
        this.items[row][column].setName(name);
    }

    public void setItemsPrice(double price, int row, int column) {
        this.items[row][column].setPrice(price);
    }

    public void setItemsQuantity(int quantity, int row, int column) {
        this.items[row][column].setQuantity(quantity);
    }


    // methods
    public boolean dispense(int row, int column) {
        if (items[row][column].getQuantity() <= 0) return false;
        
        items[row][column].setQuantity(items[row][column].getQuantity() - 1);
        return true;
    }
};
