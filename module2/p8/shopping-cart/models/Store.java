package models;

public class Store {
    private final Item[][] items;

    public Store() {
        this.items = new Item[7][3];
    }

    public Item getItem(int row, int column) {
        return new Item(items[row][column]);
    }

    public void setItem(int row, int column, Item item) {
        this.items[row][column] = new Item(item);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < items.length; i++) {
            switch (i) {
                case 0 -> result.append("\tDRINKS:        ");
                case 1 -> result.append("\tCEREAL:        ");
                case 2 -> result.append("\tDAIRY:         ");
                case 3 -> result.append("\tDELI:          ");
                case 4 -> result.append("\tGREENS:        ");
                case 5 -> result.append("\tCLOTHING:      ");
                case 6 -> result.append("\tELECTRONICS:   ");
            }
            for (int j = 0; j < items[i].length; j++) {
                result.append(items[i][j]).append("\t");
            }
            result.append("\n\n");
        }
        result.append("\t************************************************************************\n");

        return result.toString();
    }
}
