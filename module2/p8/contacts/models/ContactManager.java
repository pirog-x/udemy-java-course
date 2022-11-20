package models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private final List<Contact> contacts;

    // constructors
    public ContactManager() {
        this.contacts = new ArrayList<>();
    }


    // methods
    public void addContact(Contact c) throws ParseException {
        contacts.add(new Contact(c));
    }

    public void remove(String name) throws IllegalStateException {
        if (contacts.isEmpty()) throw new IllegalStateException("cannot remove from empty list");

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
            }
        }
    }

    public String toString() {
        StringBuilder tmp = new StringBuilder();

        for (Contact c : contacts) {
            tmp.append(c).append("\n\n");
        }
        return tmp.toString();
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
    }
}
