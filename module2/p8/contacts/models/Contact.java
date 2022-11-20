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


    // constructors
    public Contact(String name, String number, String birthday) throws ParseException, IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("name cannot be blank/null");
        else if (number.isBlank()) throw new IllegalArgumentException("number cannot be blank");
        else if (number.length() < 5) throw new IllegalArgumentException("number length cannot be lesser than 5");
        
        this.name = name;
        this.number = number;
        this.birthday = birthday;
        this.age = toAge(birthday);
    }

    public Contact(Contact source) throws ParseException, IllegalArgumentException {
        this(source.getName(), source.getNumber(), source.getBirthday());
    }

    // getters
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getNumber() {
        return number;
    }


    // setters
    private void setAge(int age) {
        if (age < 0 || age > 130) throw new IllegalArgumentException();
        this.age = age;
    }
    public void setName(String name) {
        if (name.isBlank()) throw new IllegalArgumentException("name cannot be blanck/null");
        this.name = name;
    }
    public void setBirthday(String birthday) throws ParseException {
        if (birthday.isBlank()) throw new IllegalArgumentException("birthday cannot be blanck/null");
        this.birthday = birthday;

        setAge(toAge(birthday));
    }
    public void setNumber(String number) throws IllegalArgumentException {
        if (number.isBlank()) throw new IllegalArgumentException("number cannot be blank/null");
        this.number = number;
    }


    // methods
    public int toAge(String birthday) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthday).getTime();
        return (int)(TimeUnit.MILLISECONDS.toDays(diff) / 365);
    }

    public String toString() {
        return "Name: " + name + "\n" + "Phone number: " + number + "\n" + "Birth Date: " + birthday + "\n" + "Age: " + age + " year old\n";
    }
}
