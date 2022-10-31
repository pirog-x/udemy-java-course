import java.util.Arrays;
import java.util.Random;

class Person {
    private String name;
    private String nationality;
    private String dateOfBirth;
    private String[] passport;
    private int seatNumber;

    // constructors
    public Person(String name, String nationality, String dateOfBirth, int seatNumber) {
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.seatNumber = seatNumber;
        this.passport = new String[]{name, nationality, dateOfBirth};
    }

    public Person(Person source) {
        this.name = source.getName();
        this.nationality = source.getNationality();
        this.dateOfBirth = source.getDateOfBirth();
        this.seatNumber = source.getSeatNumber();
        this.passport = Arrays.copyOf(source.getPassport(), source.getPassport().length);
    }


    // getters
    public String getName() {
        return this.name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }
    
    public String[] getPassport() {
        return Arrays.copyOf(this.passport, this.passport.length);
    }


    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setPassport(String[] passport) {
        this.passport = Arrays.copyOf(passport, passport.length);
    }


    // methods
    public boolean applyPassport(){
        return new Random().nextBoolean();
    }

    public void chooseSeat() {
        this.seatNumber = new Random().nextInt(11) + 1;
    }

    public String toString() {
        return "Name: " + this.name + "\n" + "Nationality: " +
                this.nationality + "\n" + "Date of Birth: " +
                this.dateOfBirth + "\n" + "Seat Number: " +
                this.seatNumber + "\n" + "Passport: " +
                Arrays.toString(this.passport) + "\n";
    }
}
