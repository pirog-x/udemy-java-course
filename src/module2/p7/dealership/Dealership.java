import java.util.Scanner;

public class Dealership {
    private Car[] cars;

    public Dealership(Car[] cars) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        }
    }

    public void setCar(Car car, int index) {
        this.cars[index] = new Car(car);
    }

    public Car getCar(int index) {
        return new Car(this.cars[index]);
    }

    public void sell(int index) {
        this.cars[index].drive();
        this.cars[index] = null;
    }

     public int search(String make, int budget) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < this.cars.length; i++) {
            if (this.cars[i] == null) {
                continue;
            } else if (this.cars[i].getMake().equals(make) && this.cars[i].getPrice() <= budget) {
                 System.out.println("\nWe found one in spot " + i + "\n" + this.cars[i].toString() + "\nAre you interested ?");
                 String tmp = scanner.next();
                 if (tmp.equalsIgnoreCase("yes")) {
                    scanner.close();
                    return i;
                 }
            }
        }
        scanner.close();
        System.out.println("Sorry, we couldn't find any cars.");
        return 404;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "Parking Spot: " + i + "\n";
            if (this.cars[i] == null) {
                temp += "Empty\n";
            } else {
                temp += this.cars[i].toString() + "\n";
            }
        }
        return temp;
    }


}