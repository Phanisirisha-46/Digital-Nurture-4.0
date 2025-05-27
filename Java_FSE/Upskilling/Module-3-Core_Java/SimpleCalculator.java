import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt user to enter two numbers
            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            // Ask user to choose an operation
            System.out.print("Choose an operation (+, -, *, /): ");
            char operation = scanner.nextLine().charAt(0);

            double result;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error: Division by zero.");
                    }
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values.");
        }

        scanner.close();
    }
}
