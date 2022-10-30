import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ben", "Ukrainian", "03.2.1998", 23);
        p1.chooseSeat();
        System.out.println(p1.toString());

        System.out.println("Name: " + p1.getName() + "\n" +
                "Nationality: " + p1.getNationality() + "\n" +
                "Date of Birth: " + p1.getDateOfBirth() + "\n" +
                "Seat Number: " + p1.getSeatNumber() + "\n" + "Passport: " +
                Arrays.toString(p1.getPassport()) + "\n");
    }
}
