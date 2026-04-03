package class01;

import java.util.ArrayList;
import java.util.List;

public class ListLab {
    public static void main(String[] args) {
        List<String> tasks = new ArrayList<>();

        tasks.add("Wake up");
        tasks.add("Study Java");
        tasks.add("Practice coding");
        tasks.add(1, "Drink water");

        System.out.println("Initial list: " + tasks);
        System.out.println("Total tasks: " + tasks.size());

        System.out.println("First task: " + tasks.get(0));
        System.out.println("Second task: " + tasks.get(1));

        tasks.set(2, "Study Java List");
        System.out.println("After update: " + tasks);

        tasks.remove("Wake up");
        System.out.println("After remove by value: " + tasks);

        tasks.remove(0);
        System.out.println("After remove by index: " + tasks);

        System.out.println("Contains 'Practice coding'? " + tasks.contains("Practice coding"));
        System.out.println("Index of 'Practice coding': " + tasks.indexOf("Practice coding"));

        System.out.println("\nLoop through list:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }

        tasks.clear();
        System.out.println("\nAfter clear: " + tasks);
        System.out.println("Is list empty? " + tasks.isEmpty());
    }
}
