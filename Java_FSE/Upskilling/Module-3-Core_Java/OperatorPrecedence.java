public class OperatorPrecedence {
    public static void main(String[] args) {
        // Expression with multiple operators
        int result1 = 10 + 5 * 2;       // Expected: 10 + (5 * 2) = 20
        int result2 = (10 + 5) * 2;     // Expected: (10 + 5) * 2 = 30
        int result3 = 100 / 10 + 5 * 2; // Expected: (100 / 10) + (5 * 2) = 10 + 10 = 20
        int result4 = 100 / (10 + 5) * 2; // Expected: (100 / 15) * 2 = 6 * 2 = 12

        // Displaying the results
        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
        System.out.println("100 / 10 + 5 * 2 = " + result3);
        System.out.println("100 / (10 + 5) * 2 = " + result4);
    }
}

/*explaination:

The order of evaluation of arithmetic operations in Java follows the BODMAS (Brackets, Orders, Division and Multiplication, Addition and Subtraction) rule.

In this example, the operators have the following precedence:

+, - have the same precedence, so they are evaluated from left to right

*, /, % have higher precedence than +, -

Operators with equal precedence are evaluated left to right

Use parentheses () to override default precedence*/