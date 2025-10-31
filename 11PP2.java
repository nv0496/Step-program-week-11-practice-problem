import java.util.*;

public class BrowserNavigation {
    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String current = "Home";

        while (true) {
            System.out.print("Command (VISIT/BACK/FORWARD/PRINT/EXIT): ");
            String cmd = sc.next().toUpperCase();

            switch (cmd) {
                case "VISIT":
                    String url = sc.next();
                    backStack.push(current);
                    current = url;
                    forwardStack.clear();
                    System.out.println("Visited: " + current);
                    break;

                case "BACK":
                    if (!backStack.isEmpty()) {
                        forwardStack.push(current);
                        current = backStack.pop();
                    } else {
                        System.out.println("No previous page!");
                    }
                    break;

                case "FORWARD":
                    if (!forwardStack.isEmpty()) {
                        backStack.push(current);
                        current = forwardStack.pop();
                    } else {
                        System.out.println("No forward page!");
                    }
                    break;

                case "PRINT":
                    System.out.println("Current Page: " + current);
                    break;

                case "EXIT":
                    System.out.println("Exiting browser...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid command!");
            }
        }
    }
}
\
