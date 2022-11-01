public class Airline {
    private Person[] seats;

    public Airline() {
        this.seats = new Person[11];
    }
    
    public Person getPerson(int index) {
        if (index < 0 || index >= this.seats.length) return null;
        return new Person(this.seats[index]);
    }

    public void setPerson(Person person) {
        this.seats[person.getSeatNumber() - 1] = new Person(person);
    }

    public void createReservation(Person person) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null) {
                break;
            } else if (i == seats.length - 1) {
                System.out.println("Sorry, " + person.getName() + ", all seats is already taken.");
                return;
            }
        }

        while (this.seats[person.getSeatNumber() - 1] != null) {
            System.out.println(person.getName() + ", seat: " + person.getSeatNumber() + " is already taken. Please choose another one.");
            person.chooseSeat();
        }

        this.seats[person.getSeatNumber() - 1] = new Person(person);
        System.out.println("Thank you " + person.getName() + " for flying with Java airlines. Your seat number is " + person.getSeatNumber() + ".");
    }

    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null) {
                 tmp.append("Seat " + (i + 1) + " is empty.\n\n");
            } else {
                tmp.append(seats[i].toString() + "\n\n");
            }
        }
        return tmp.toString();
    }
}
