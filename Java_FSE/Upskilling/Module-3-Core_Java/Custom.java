import java.util.Scanner;

// Define a custom exception InvalidAgeException
class InvalidAgeException extends Exception {
    // Constructor for InvalidAgeException
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Custom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            // Throw InvalidAgeException if age is less than 18
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or older.");
            } else {
                System.out.println("You are eligible.");
            }
        } catch (InvalidAgeException e) {
            // Catch the custom exception and display the message
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
