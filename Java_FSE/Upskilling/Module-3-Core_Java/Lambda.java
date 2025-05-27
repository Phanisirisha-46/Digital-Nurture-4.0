import java.util.*;

public class Lambda {
    public static void main(String[] args) {
        // Create a List of strings
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Eve");

        // Sort the list using Collections.sort() and a lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        // Display the sorted list
        System.out.println("Sorted List: " + names);
    }
}
