import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a string
        System.out.print("Enter a string to write to the file: ");
        String userInput = scanner.nextLine();

        // Write the string to output.txt file
        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            fileWriter.write(userInput); // Write the string to the file
            System.out.println("Data has been written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        scanner.close();
    }
}
