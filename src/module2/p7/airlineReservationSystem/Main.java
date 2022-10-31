public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ben", "Ukrainian", "03.2.1998", 23);
        if (p1.applyPassport()) {
            p1.setPassport(new String[]{p1.getName(), p1.getNationality(), p1.getDateOfBirth()});
        }
        System.out.println(p1);
    }
}
