import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t***************************************************************");
        System.out.println("\t                    WELCOME TO JAVA DRINKS!                      ");
        System.out.println("\t***************************************************************");

        Item[][] items = new Item[][] {
            { new Item("Pepsi", 1.99, 3) , new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
            { new Item("Fanta", 1.99, 2) , new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
            { new Item("Crush", 1.99, 2) , new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1) }
        };

        Machine machine = new Machine(items);
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + machine);

            int choiceRow = 0, choiceColumn = 0;
            try {
                System.out.print("Enter row: ");
                choiceRow = scan.nextInt();

                System.out.print("Enter column: ");
                choiceColumn = scan.nextInt();

                if (choiceRow >= items.length || choiceRow < 0)
                    throw new ArrayIndexOutOfBoundsException();
                if (choiceColumn >= items[choiceRow].length || choiceColumn < 0)
                    throw  new ArrayIndexOutOfBoundsException();
            } catch (InputMismatchException e) {
                System.err.println("\nWrong input\n");
                scan.nextLine();
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("\nWrong index\n");
                scan.nextLine();
                continue;
            }

            if (machine.dispense(choiceRow, choiceColumn)) {
                scan.nextLine();
                System.out.print("\nEnjoy your drink! Press 1 to purchase another: ");

                try {
                    boolean choice = scan.nextInt() == 1;
                    if (choice) continue;
                    else break;
                } catch (InputMismatchException e) {
                    System.err.println("\nWrong input\n");
                    scan.nextLine();
                }
            } else {
                scan.nextLine();
                System.out.print("\nSorry, we're out of this item. Press 1 to purchase another: ");

                try {
                    boolean choice = scan.nextInt() == 1;
                    if (choice) continue;
                    else break;
                } catch (InputMismatchException e) {
                    System.err.println("\nWrong input\n");
                    scan.nextLine();
                }
            }
       }
       scan.close();
    }
};
