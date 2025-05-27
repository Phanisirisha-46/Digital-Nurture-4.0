import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a non-negative integer
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();

        // Check if the number is negative
        if (number < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            // Calculate the factorial using a for loop
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            // Display the result
            System.out.println("Factorial of " + number + " is: " + factorial);
        }

        scanner.close();
    }
}
