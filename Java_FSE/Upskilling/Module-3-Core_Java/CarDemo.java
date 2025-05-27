// Define the Car class
class Car {
    // Attributes of the class
    String make;
    String model;
    int year;

    // Constructor to initialize the Car object
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Car Year: " + year);
    }
}

public class CarDemo {
    public static void main(String[] args) {
        // Create objects of the Car class
        Car car1 = new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Honda", "Civic", 2021);

        // Call the method to display car details
        car1.displayDetails();
        System.out.println();  // Adding a line break between car details
        car2.displayDetails();
    }
}
