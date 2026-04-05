package class01;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueLab {
    public static void main(String[] args) {
        // Queue example: token system at a bank counter (FIFO)
        Queue<String> customers = new ArrayDeque<>();

        // Add customers to queue
        customers.offer("Asha");
        customers.offer("Ravi");
        customers.offer("Mina");
        customers.offer("John");

        System.out.println("Initial queue: " + customers);
        System.out.println("Total waiting: " + customers.size());

        // Check who is next without removing
        System.out.println("Next customer (peek): " + customers.peek());

        // Serve customers one by one (removes from front)
        System.out.println("\nServing customers:");
        while (!customers.isEmpty()) {
            String served = customers.poll();
            System.out.println("Served: " + served + " | Remaining queue: " + customers);
        }

        System.out.println("\nQueue empty? " + customers.isEmpty());

        // Difference between offer/add and poll/remove on empty queue
        System.out.println("Poll on empty queue returns: " + customers.poll());
    }
}
