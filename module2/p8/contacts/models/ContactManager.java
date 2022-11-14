package models;

import java.text.ParseException;
import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    // constructors
    public ContactManager() {
        this.contacts = new ArrayList<Contact>();
    }


    // getters
    public Contact getContact(int index) throws ParseException{
        return new Contact(contacts.get(index));
    }
    
    // setters
    public void setContact(int index, Contact c) throws ParseException {
        contacts.set(index, new Contact(c));
    }

    // methods
    public void addContact(Contact c) throws ParseException {
        contacts.add(new Contact(c));
    }

    public void remove(String name) throws IllegalStateException {
        if (contacts.isEmpty()) throw new IllegalStateException("cannot remove from empty list");
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                contacts.remove(c);
            }
        }
    }

    public String toString() {
        StringBuilder tmp = new StringBuilder();

        for (Contact c : contacts) {
            tmp.append(c + "\n\n");
        }
        return tmp.toString();
    }
}
