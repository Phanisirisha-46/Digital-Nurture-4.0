import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Print multiplication table using a for loop
        System.out.println("Multiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        scanner.close();
    }
}
