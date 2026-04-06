package class01;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueLab {
    public static void main(String[] args) {
        // PriorityQueue serves smallest number first by default.
        // We use ticket numbers where lower number means higher priority.
        Queue<Integer> tickets = new PriorityQueue<>();

        tickets.offer(105);
        tickets.offer(101);
        tickets.offer(110);
        tickets.offer(103);

        System.out.println("Tickets added (not FIFO order): " + tickets);
        System.out.println("Next highest priority ticket: " + tickets.peek());

        System.out.println("\nServing by priority:");
        while (!tickets.isEmpty()) {
            System.out.println("Serving ticket: " + tickets.poll());
        }

        System.out.println("\nQueue empty? " + tickets.isEmpty());
    }
}
