import models.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        try {
            loadItems("products.txt");
            manageItems();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Name: manageItems
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. Creates an infinite loop:     
     *   •        The user can choose to a) add or b) remove c) checkout.
     *   •          case a: asks for the aisle and item number. Then, adds item to cart.
     *   •          case b: asks for the name. Then, removes item from cart.
     *   •          case c: prints the receipt and closes Scanner.
     *   •        Prints the updated shopping cart.
     */

    private static void cleanScreen() {
        System.out.println("\033[H\033[2J");
    }

    public static void manageItems() {
        Scanner scan = new Scanner(System.in);
        boolean isWork = true;
        char choice;

        while (isWork) {

            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);

            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            choice = scan.next().charAt(0);
            scan.nextLine();

            switch (choice) {
                case 'a' -> {
                    cleanScreen();
                    System.out.println("--ADD--");
                    System.out.print("Enter the aisle 1 - 7: ");
                    if (!scan.hasNextInt()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    int row = scan.nextInt();
                    scan.nextLine();
                    row--;
                    if (row < 0 || row >= store.getRowSize()) {
                        System.out.println("Wrong aisle bound");
                        pressAnyKeyToContinue();
                        continue;
                    }

                    System.out.print("Enter item number 1 - 3: ");
                    if (!scan.hasNextInt()) {
                        System.out.println("Wrong input");
                        pressAnyKeyToContinue();
                        continue;
                    }
                    int column = scan.nextInt();
                    scan.nextLine();
                    column--;
                    if (column < 0 || column >= store.getColumnSize()) {
                        System.out.println("Wrong items bound");
                        pressAnyKeyToContinue();
                        continue;
                    }

                    System.out.println(store.getItem(row, column) + (cart.add(store.getItem(row, column)) ? "was added to your shopping cart." : "is already in your shopping cart."));
                    System.out.println("\n\nSHOPPING CART\n\n" + cart);
                    pressAnyKeyToContinue();
                }

                case 'b' -> {
                    cleanScreen();
                    if (cart.size() == 0) {
                        System.out.println("Cart is empty\n");
                        pressAnyKeyToContinue();
                        continue;
                    }
                    System.out.println("--REMOVE--");
                    System.out.print("Enter the name of item: ");
                    String name = scan.nextLine();
                    cart.remove(name);

                    System.out.println("\n\nSHOPPING CART\n\n" + cart);
                    pressAnyKeyToContinue();
                }

                case 'c' -> {
                    cleanScreen();
                    if (cart.size() == 0) {
                        System.out.println("Cart is empty\n");
                        continue;
                    }

                    System.out.println(cart.checkout());
                    scan.close();
                    isWork = false;
                }

                default -> System.out.println("\nWrong choice\n");
            }
        }
    }

    private static void pressAnyKeyToContinue() {
        try {
            System.out.print("Press any key to continue...");
            System.in.read();
        } catch (Exception e) {}
    }

    public static void loadItems(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);
        int row = 0;
        int column = 0;

        while (scanFile.hasNextLine()) {
            String[] tmp = scanFile.nextLine().split(";");
            for (String s : tmp) {
                String[] itemTmp = s.split("=");
                store.setItem(row, column++, new Item(itemTmp[0], Double.parseDouble(itemTmp[1])));
            }
            row++;
            column = 0;
        }
        scanFile.close();
    }
}
