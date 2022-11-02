import java.util.Arrays;

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
    public Item getItem(int column, int row) {
        return new Item(items[row][column]);
    }

    // setters
    public void setItem(Item item, int column, int row) {
        if (item == null) return;
        items[row][column] = new Item(items[row][column]);
    }
};
