import java.util.*;

class Patient {
    String name;
    int priority;

    Patient(String n, int p) {
        name = n;
        priority = p;
    }

    @Override
    public String toString() {
        return name + "(Priority: " + priority + ")";
    }
}

public class EmergencyRoom {
    public static void main(String[] args) {
        // Comparator ensures higher priority (larger number) is treated first
        PriorityQueue<Patient> pq = new PriorityQueue<>(Comparator.comparingInt(p -> -p.priority));
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ARRIVE <name> <priority>/TREAT/STATUS/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ARRIVE")) {
                // Handle ARRIVE - add patient to queue
                String name = sc.next();
                int priority = sc.nextInt();
                pq.add(new Patient(name, priority));
                System.out.println(name + " (Priority " + priority + ") has arrived.");
            } 
            else if (cmd.equalsIgnoreCase("TREAT")) {
                // Handle TREAT - poll highest priority patient
                if (!pq.isEmpty()) {
                    Patient treated = pq.poll();
                    System.out.println("Treating " + treated.name + " (Priority " + treated.priority + ")");
                } else {
                    System.out.println("No patients to treat!");
                }
            } 
            else if (cmd.equalsIgnoreCase("STATUS")) {
                // Handle STATUS - print remaining patients
                if (pq.isEmpty()) {
                    System.out.println("No patients waiting.");
                } else {
                    System.out.println("Waiting patients: " + pq);
                }
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                // Handle EXIT - break loop
                System.out.println("Emergency Room closed.");
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }
}
