import java.util.*;

public class TextEditorUndo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command (TYPE <word>/UNDO/PRINT/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("TYPE")) {
                // Handle TYPE - push word onto stack
                String word = sc.next();
                stack.push(word);
            } 
            else if (cmd.equalsIgnoreCase("UNDO")) {
                // Handle UNDO - pop last word if available
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    System.out.println("Nothing to undo!");
                }
            } 
            else if (cmd.equalsIgnoreCase("PRINT")) {
                // Handle PRINT - display full sentence
                for (String word : stack) {
                    System.out.print(word + " ");
                }
                System.out.println();
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                // Handle EXIT - terminate program
                System.out.println("Exiting editor...");
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }
}
