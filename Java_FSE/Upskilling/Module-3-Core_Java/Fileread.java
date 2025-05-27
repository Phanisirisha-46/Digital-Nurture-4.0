import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fileread {
    public static void main(String[] args) {
        // Try-with-resources to automatically close the BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            
            // Read each line from the file and display it on the console
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
