import java.util.*;

public class ExpressionValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String exp = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        boolean isBalanced = true;

        // Traverse through each character of the expression
        for (char ch : exp.toCharArray()) {

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Handle closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty — unmatched closing bracket
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char top = stack.pop();

                // Check if popped bracket matches the closing one
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    isBalanced = false;
                    break;
                }
            }
        }

        // If stack is not empty, then there are unmatched opening brackets
        if (!stack.isEmpty()) {
            isBalanced = false;
        }

        // Final output
        if (isBalanced)
            System.out.println("Expression is Balanced");
        else
            System.out.println("Expression is Not Balanced");

        sc.close();
    }
}
