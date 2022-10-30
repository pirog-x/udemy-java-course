class Person {
    private String name;
    private String nationality;
    private String dateOfBirth;
    private String[] passport;
    private int seatNumber;

    // constructors
    public Person(String name, String nationality, String dateOfBirth, String[] passport, int seatNumber) {
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.passport = passport;
        this.seatNumber = seatNumber;
    }

    public Person(Person another) {
        this(another.getName(), another.getNationality(), another.getDateOfBirth(), another.getPassport(), another.getSeatNumber());
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

    public String[] getPassport() {
        return this.passport;
    }

    public int getSeatNumber() {
        return this.seatNumber;
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

    public void setPassport(String[] passport) {
        this.passport = passport;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }


    // methods
    public void applyPassport(){}

    public void chooseSeat(){}
}
