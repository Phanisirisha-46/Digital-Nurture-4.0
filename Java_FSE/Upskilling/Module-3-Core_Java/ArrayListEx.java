import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
    public static void main(String[] args) {
        // Create an ArrayList to store student names
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter student names
        System.out.println("Enter student names. Type 'done' to stop.");

        while (true) {
            System.out.print("Enter a name: ");
            String name = scanner.nextLine();

            // Check if the user wants to stop entering names
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            // Add the name to the ArrayList
            studentNames.add(name);
        }

        // Display all the names entered
        System.out.println("\nList of student names:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
