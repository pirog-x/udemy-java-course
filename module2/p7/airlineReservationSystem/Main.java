public class Main {
    public static void main(String[] args) {                                  
                                                                               
        Person[] people = new Person[] {                                       
            new Person("Cleopatra", "Egypt", "69 BC", 1),
            new Person("Alexander the Great", "Macedon", "356 BC",1), 
            new Person("Julius Caesar", "Rome", "100 BC", 1),
            new Person("Spartacus", "Thrace", "111 BC", 2),
            new Person("Marcus Aurelius", "Rome", "121 AD", 2),
            new Person("Leonidas", "Greece", "540 BC", 2),
            new Person("Sun Tzu", "China", "544 BC", 2),
            new Person("Hammurabi", "Babylon", "1750 BC", 2),
        };


        Airline airline = new Airline();
        
        for (Person person : people) {
            if (person.applyPassport()) {
                person.setPassport(new String[] {person.getName(), person.getNationality(), person.getDateOfBirth()});
            }
        }
        for (Person p : people) {
            airline.createReservation(p);
        }
        
        System.out.println("****************** RESERVATIONS COMPLETE! ******************");
        System.out.println(airline);
  } 
}
