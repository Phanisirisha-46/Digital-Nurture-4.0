public class Pattern {

    // Method to determine the type of the object and respond accordingly
    public static void checkObjectType(Object obj) {
        // Using switch expression with pattern matching
        switch (obj) {
            case Integer i -> System.out.println("It's an Integer with value: " + i);
            case String s -> System.out.println("It's a String with value: " + s);
            case Double d -> System.out.println("It's a Double with value: " + d);
            case null -> System.out.println("The object is null");
            default -> System.out.println("Unknown type: " + obj.getClass().getName());
        }
    }

    public static void main(String[] args) {
        // Test the method with different object types
        checkObjectType(42);         // Integer
        checkObjectType("Hello");    // String
        checkObjectType(3.14);       // Double
        checkObjectType(null);       // Null
        checkObjectType(10.5f);      // Unknown type (float)
    }
}
