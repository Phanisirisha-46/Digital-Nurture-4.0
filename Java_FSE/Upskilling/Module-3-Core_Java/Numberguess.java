import java.util.Scanner;
import java.util.Random;

public class Numberguess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int targetNumber = random.nextInt(100) + 1;

        int guess = 0;
        int attempts = 0;

        // Loop until the user guesses the correct number
        while (guess != targetNumber) {
            // Prompt the user to guess the number
            System.out.print("Guess the number (between 1 and 100): ");
            guess = scanner.nextInt();
            attempts++;

            // Provide feedback on the guess
            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        }

        scanner.close();
    }
}
