import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Remove non-alphanumeric characters and convert to lowercase
        String cleanedString = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check if the cleaned string is a palindrome
        String reversedString = new StringBuilder(cleanedString).reverse().toString();

        if (cleanedString.equals(reversedString)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }
}
