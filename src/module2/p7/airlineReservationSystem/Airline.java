public class Airline {
    private Person[] seats;

    public Airline() {
        this.seats = new Person[11];
    }
    
    public Person getePerson(int index) {
        return new Person(this.seats[index]);
    }

    public void setPerson(Person person) {
        this.seats[person.getSeatNumber() - 1] = new Person(person);
    }

    public void createReservation() {
        System.out.println("");
    }
}
