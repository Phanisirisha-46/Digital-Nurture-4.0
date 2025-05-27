import java.util.Scanner;

public class Try {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for two integers
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        try {
            // Attempt to divide num1 by num2
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Cannot divide by zero.");
        }

        scanner.close();
    }
}
