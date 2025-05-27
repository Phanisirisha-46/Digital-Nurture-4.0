import java.util.Scanner;

public class Fibonacci {

    // Recursive method to calculate the nth Fibonacci number
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Recursive step
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a positive integer n
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        // Calculate the nth Fibonacci number
        int result = fibonacci(n);

        // Display the result
        System.out.println("Fibonacci number at position " + n + " is: " + result);

        scanner.close();
    }
}
