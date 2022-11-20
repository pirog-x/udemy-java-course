import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import models.*;

public class Main {
    static ContactManager manager = new ContactManager();
    public static void main(String[] args) {
        try {
            loadContacts("contacts.txt");
            manageContacts();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Process complete.");
        }    
        
        System.out.println("\n\n" + manager);
    }

    public static void cleanScreen() {
        System.out.println("\033[H\033[2J");
    }
    

    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        boolean isWork = true;


        while (isWork) {
            System.out.println("Enter choice: \na - add \nb - remove a contact \nc - exit:");
            char choice = scan.next().charAt(0);
            scan.nextLine();

            switch (choice) {
                case 'a' -> {
                    cleanScreen();
                    System.out.println("--ADD MODE--");
                    System.out.println("Enter contact name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter contact number: ");
                    String number = scan.next();
                    System.out.println("Enter contact birthday (MM/dd/yyyy): ");
                    String birthday = scan.next();
                    if (name.isBlank() || number.isBlank()) {
                        System.out.println("\nThe input you provided is not valid. Registration failed.");
                        continue;
                    }
                    if (number.length() < 5) {
                        System.out.println("\nPhone number cannot be lesser than 5. Registration failed.");
                        continue;
                    }
                    try {
                        manager.addContact(new Contact(name, number, birthday));
                    } catch (ParseException e) {
                        System.out.println("\nWrong data: " + birthday + ". Registration failed.");
                    } finally {
                        cleanScreen();
                        System.out.println("UPDATED CONTACTS\n\n" + manager);
                    }
                }

                case 'b' -> {
                    cleanScreen();
                    if (manager.isEmpty()) {
                        System.out.println("You cannot delete from empty list. Registration failed.");
                        continue;
                    }
                    System.out.println("--REMOVE MODE--");
                    System.out.println("Enter contact name: ");
                    manager.remove(scan.nextLine());
                    System.out.println("\n\nUPDATED CONTACTS\n\n" + manager);
                }

                case 'c' -> {
                    cleanScreen();
                    isWork = false;
                }

                default -> System.out.println("Wrong choice");
            }
        }
        scan.close();
    }



    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);
        while (scanFile.hasNextLine()) {
            try {
                manager.addContact(new Contact(scanFile.next(), scanFile.next(), scanFile.next()));
            } catch (ParseException e) {
                scanFile.nextLine();
                System.out.println(e.getMessage()); 
            }
        }
        System.out.println("CONTACTS LOADED\n\n");
        scanFile.close();
    }
}
