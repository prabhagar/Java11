package class01;

import java.util.HashSet;
import java.util.Set;

public class SetLab {
    public static void main(String[] args) {
        Set<String> students = new HashSet<>();

        students.add("Asha");
        students.add("Ravi");
        students.add("Asha");
        students.add("Mina");

        System.out.println("Set values: " + students);
        System.out.println("Total unique students: " + students.size());
        System.out.println("Contains Ravi? " + students.contains("Ravi"));

        students.remove("Ravi");
        System.out.println("After removing Ravi: " + students);

        System.out.println("\nLoop through set:");
        for (String student : students) {
            System.out.println("- " + student);
        }
    }
}