import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for marks out of 100
        System.out.print("Enter marks (out of 100): ");
        int marks = scanner.nextInt();

        // Use if-else statements to assign grades
        char grade;
        if (marks >= 90 && marks <= 100) {
            grade = 'A';
        } else if (marks >= 80 && marks < 90) {
            grade = 'B';
        } else if (marks >= 70 && marks < 80) {
            grade = 'C';
        } else if (marks >= 60 && marks < 70) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display the assigned grade
        System.out.println("Assigned Grade: " + grade);

        scanner.close();
    }
}
