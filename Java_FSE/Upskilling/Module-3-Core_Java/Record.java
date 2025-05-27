import java.util.*;
import java.util.stream.*;

public class Record {

    // Define a record named Person
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        // Create instances of Person record
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);
        Person person3 = new Person("Charlie", 35);
        Person person4 = new Person("David", 20);

        // Add Person instances to a List
        List<Person> people = List.of(person1, person2, person3, person4);

        // Display the list of people
        System.out.println("All People: " + people);

        // Use Stream API to filter people based on age (e.g., age greater than or equal to 30)
        List<Person> filteredPeople = people.stream()
                                            .filter(person -> person.age() >= 30)  // Filter based on age
                                            .collect(Collectors.toList());  // Collect the result into a list

        // Display the filtered result
        System.out.println("People with age >= 30: " + filteredPeople);
    }
}
