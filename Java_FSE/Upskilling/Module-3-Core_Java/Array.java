import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Declare an array to store the elements
        int[] numbers = new int[n];
        int sum = 0;

        // Read the elements into the array
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i]; // Add the element to the sum
        }

        // Calculate the average
        double average = (double) sum / n;

        // Display the sum and average
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + average);

        scanner.close();
    }
}
