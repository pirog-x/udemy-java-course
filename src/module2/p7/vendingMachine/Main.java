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

            System.out.print("Enter row: ");
            int choiceRow = scan.nextInt();
            System.out.print("Enter column: ");
            int choiceColumn = scan.nextInt();

            if (machine.dispense(choiceRow, choiceColumn)) {
                scan.nextLine();
                System.out.print("\nEnjoy your drink! Press 1 to purchase another: ");

                boolean choice = scan.nextInt() == 1 ? true : false;

                if (choice) continue;
                else break;

            } else {
                scan.nextLine();
                System.out.print("\nSorry, we're out of this item. Press 1 to purchase another: ");

                boolean choice = scan.nextInt() == 1 ? true : false;

                if (choice) continue;
                else break;
            }
       }
       scan.close();
    }
};
