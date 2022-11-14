package models;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Contact {
    private String name;
    private String number;
    private String birthday;
    private int age;

    public Contact(String name, String number, String birthday) throws ParseException{
        this.name = name;
        this.number = number;
        this.birthday = birthday;
        
        // figure out age
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthday).getTime();
        this.age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
    }

}
