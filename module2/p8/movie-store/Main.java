import models.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final Store store = new Store();
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        try {
            loadMovies("movies.txt");
            System.out.println("MOVIES LOADED\n\n");
            System.out.println(store);
            manageMovies();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Process Complete");
        }
    }


    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);
        boolean isWork = true;

        while (isWork) {
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return\n\td) exit");
            char choice = scan.next().charAt(0);
            scan.nextLine();

            switch (choice) {
                // purchase
                case 'a' -> {
                    cleanScreen();
                    if (store.isEmpty()) {
                        System.out.println("Store is empty\n\n");
                        continue;
                    }
                    System.out.println("--PURCHASE--");
                    System.out.println("Enter the film name");
                    String filmName = scan.nextLine();

                    if (store.getMovie(filmName) == null) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                        continue;
                    }
                    if (filmName.isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                        continue;
                    }
                    if (!store.getMovie(filmName).isAvailable()) {
                        System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                        continue;
                    }
                    store.action(filmName, "sell");
                }

                // rent
                case 'b' -> {
                    cleanScreen();
                    if (store.isEmpty()) {
                        System.out.println("Store is empty\n\n");
                        continue;
                    }
                    System.out.println("--RENT--");
                    System.out.println("Enter the film name");
                    String filmName = scan.nextLine();
                    if (filmName.isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                        continue;
                    }
                    store.action(filmName, "rent");
                }

                // return
                case 'c' -> {
                    cleanScreen();
                    if (store.isEmpty()) {
                        System.out.println("Store is empty\n\n");
                        continue;
                    }
                    System.out.println("--RETURN--");
                    System.out.println("Enter the film name");
                    String filmName = scan.nextLine();
                    if (filmName.isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                        continue;
                    }
                    store.action(filmName, "return");
                }

                case 'd' -> isWork = false;

                default -> System.out.println("wrong action");
            }
        }
        scan.close();
    }

    private static void cleanScreen() {
        System.out.print("\033[H\033[2J");
    }

    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);

        while (scanFile.hasNextLine()) {
            String[] words = scanFile.nextLine().split("--");
            store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));
        }
        scanFile.close();
    }
}
