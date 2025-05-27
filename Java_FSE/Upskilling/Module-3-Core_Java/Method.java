public class Method {
    
    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        // Calling each add method and displaying the results
        int result1 = add(10, 20);               // Two integers
        double result2 = add(10.5, 20.5);        // Two doubles
        int result3 = add(10, 20, 30);           // Three integers
        
        // Displaying the results
        System.out.println("Sum of two integers: " + result1);
        System.out.println("Sum of two doubles: " + result2);
        System.out.println("Sum of three integers: " + result3);
    }
}
