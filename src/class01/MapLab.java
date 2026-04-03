package class01;

import java.util.HashMap;
import java.util.Map;

public class MapLab {
    public static void main(String[] args) {
        Map<String, Integer> marks = new HashMap<>();

        marks.put("Math", 90);
        marks.put("Science", 85);
        marks.put("English", 88);

        System.out.println("All marks: " + marks);
        System.out.println("Math mark: " + marks.get("Math"));

        marks.put("Science", 92);
        System.out.println("After updating Science: " + marks);

        System.out.println("Contains key 'English'? " + marks.containsKey("English"));
        System.out.println("Contains value 92? " + marks.containsValue(92));

        marks.remove("English");
        System.out.println("After removing English: " + marks);

        System.out.println("\nLoop through map:");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}