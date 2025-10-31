import java.util.*;

public class CustomerServiceCounter {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ARRIVE <name>/SERVE/STATUS/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ARRIVE")) {
                // Handle ARRIVE - add customer to queue
                String name = sc.next();
                queue.add(name);
                System.out.println(name + " has arrived and is waiting in line.");
            } 
            else if (cmd.equalsIgnoreCase("SERVE")) {
                // Handle SERVE - remove from queue
                if (!queue.isEmpty()) {
                    String served = queue.poll();
                    System.out.println("Serving " + served);
                } else {
                    System.out.println("No customers to serve!");
                }
            } 
            else if (cmd.equalsIgnoreCase("STATUS")) {
                // Handle STATUS - display waiting list
                if (queue.isEmpty()) {
                    System.out.println("No one is waiting.");
                } else {
                    System.out.println("Waiting: " + queue);
                }
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                // Handle EXIT - break loop
                System.out.println("Closing service counter...");
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }
}
