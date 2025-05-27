import java.util.HashMap;
import java.util.Scanner;

public class Map {
    public static void main(String[] args) {
        // Create a HashMap with Integer keys (student IDs) and String values (names)
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Allow the user to add entries
        System.out.println("Enter student ID and name. Type 'done' to stop.");

        while (true) {
            System.out.print("Enter student ID: ");
            String idInput = scanner.nextLine();

            // Check if the user wants to stop entering IDs
            if (idInput.equalsIgnoreCase("done")) {
                break;
            }

            try {
                // Convert the ID to an Integer and prompt for the name
                int studentID = Integer.parseInt(idInput);

                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine();

                // Add the entry to the HashMap
                studentMap.put(studentID, studentName);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input for student ID. Please enter a valid number.");
            }
        }

        // Retrieve and display a name based on an entered ID
        while (true) {
            System.out.print("Enter a student ID to retrieve the name (or 'done' to exit): ");
            String idToRetrieve = scanner.nextLine();

            if (idToRetrieve.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int studentID = Integer.parseInt(idToRetrieve);

                // Check if the ID exists in the map
                if (studentMap.containsKey(studentID)) {
                    System.out.println("Student Name: " + studentMap.get(studentID));
                } else {
                    System.out.println("No student found with ID " + studentID);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input for student ID. Please enter a valid number.");
            }
        }

        scanner.close();
    }
}
