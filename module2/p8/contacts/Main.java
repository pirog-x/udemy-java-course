import java.text.ParseException;
import models.*;

public class Main {
    public static void main(String[] args) {
        try {
            Contact contact1 = new Contact("John", "123", "09/15/2002");
            Contact contact2 = new Contact("Sam", "456", "09/06/2005");
            Contact contact3 = new Contact(contact1);

            contact1.setName("null");
            System.out.println(contact1);
            System.out.println(contact2);
            System.out.println(contact3);

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Process complete.");
        }
        
    }

    /**
     * Name: manageContacts
     *
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) add b) remove a contact c) exit.
     *   •        case a: ask for the name, phone number and birthDate.
     *   •        case b: ask who they'd like to remove.
     *   •        case c: break the loop.
     *   • 3. close Scanner.
     */



    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads contacts from <fileName>;
     *   • 2. From the manager object, it adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     */

}
