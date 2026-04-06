package class01;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackLab {
    public static void main(String[] args) {
        // Stack uses LIFO: Last In, First Out.
        // Real-life example: browser back history.
        Deque<String> pages = new ArrayDeque<>();

        pages.push("Home");
        pages.push("Products");
        pages.push("Product Details");

        System.out.println("Current stack: " + pages);
        System.out.println("Current page (top): " + pages.peek());

        System.out.println("\nPress back button:");
        while (!pages.isEmpty()) {
            System.out.println("Going back from: " + pages.pop());
        }

        System.out.println("\nStack empty? " + pages.isEmpty());
    }
}
