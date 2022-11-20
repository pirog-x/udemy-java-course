import models.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        Movie m1 = new Movie("Top gun", "DVD", 5);
        Movie m2 = new Movie(m1);
        System.out.println("m1.getRentalPrice() = " + m1.getRentalPrice());
        System.out.println("m2.getRentalPrice() = " + m2.getRentalPrice());
        m1.setFormat("Blue-Ray");
        m1.setAvailable(false);
        System.out.println("m1.getRentalPrice() = " + m1.getRentalPrice());
        System.out.println("m2.getRentalPrice() = " + m2.getRentalPrice());
        System.out.println("\n\n" + m1 + "\n\n" + m2);
    }

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */


    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */

}
