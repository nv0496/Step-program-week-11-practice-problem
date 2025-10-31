import java.util.*;

public class PrintQueueSystem {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ADD <doc>/PRINT/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ADD")) {
                // Handle ADD - enqueue document
                String document = sc.next();
                printQueue.add(document);
                System.out.println("Added " + document + " to print queue.");
            } 
            else if (cmd.equalsIgnoreCase("PRINT")) {
                // Handle PRINT - dequeue and show printed document
                if (!printQueue.isEmpty()) {
                    String currentDoc = printQueue.poll();
                    System.out.println("Printing " + currentDoc);
                } else {
                    System.out.println("No jobs left!");
                }
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                // Handle EXIT - break loop
                System.out.println("Exiting print queue system...");
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }
}
