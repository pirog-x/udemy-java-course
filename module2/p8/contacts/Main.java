import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.Cleaner.Cleanable;
import java.text.ParseException;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

import models.*;

public class Main {
    static ContactManager manager = new ContactManager();
    public static void main(String[] args) {
        try {
            manageContacts();
            loadContacts("contacts.txt");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
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
    
    /**
     * Name: manageContacts
     *
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to 
     *         a) add 
     *         b) remove a contact
     *         c) exit.
     *   •        case a: ask for the name, phone number and birthDate.
     *   •        case b: ask who they'd like to remove.
     *   •        case c: break the loop.
     *   • 3. close Scanner.
     */

    public static void manageContacts() throws ParseException {
        Scanner scan = new Scanner(System.in);
        boolean isWork = true;


        while (isWork) {
            System.out.println("Enter choice: \na - add \nb - revome a contact \nc - exit:");
            char choice = scan.next().charAt(0);
            scan.nextLine();

            switch (choice) {
                case 'a':
                cleanScreen();
                System.out.println("--ADD MODE--");
                System.out.println("Enter contact name: ");
                String name = scan.nextLine();
                System.out.println("Enter contact number: ");
                String number = scan.next();
                System.out.println("Enter contact birthday (MM/dd/yyyy): ");
                String birthday = scan.next();

                manager.addContact(new Contact(name, number, birthday));
                break;

                case 'b':
                cleanScreen();
                System.out.println("--REMOVE MODE--");
                System.out.println("Enter contact name: ");
                String removeName = scan.nextLine();
                manager.remove(removeName);
      
                break;

                case 'c':
                cleanScreen();
                isWork = false;
                break;

                default:
                System.out.println("Wrong choice");
                break;
            }
        }
    }



    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);
        while (scanFile.hasNextLine()) {
            try {
                manager.addContact(new Contact(scanFile.next(), scanFile.next(), scanFile.next()));
                System.out.println("CONTACTS LOADED\n\n");
            } catch (ParseException e) {
                scanFile.nextLine();
                System.out.println(e.getMessage()); 
            }
        }
        scanFile.close();
    }
}
