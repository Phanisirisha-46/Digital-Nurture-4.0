import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Use StringBuilder to reverse the string
        StringBuilder reversedString = new StringBuilder(input);
        reversedString.reverse();

        // Display the reversed string
        System.out.println("Reversed string: " + reversedString.toString());

        scanner.close();
    }
}
