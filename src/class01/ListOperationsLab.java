package class01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOperationsLab {
    public static void main(String[] args) {
        // Original list of marks
        List<Integer> marks = new ArrayList<>();
        marks.add(85);
        marks.add(92);
        marks.add(78);
        marks.add(88);
        marks.add(95);
        marks.add(81);
        marks.add(92); // duplicate for demo
        marks.add(92);

        System.out.println("Original List: " + marks);
        System.out.println("");

        // ========== SORTING ==========
        List<Integer> sortedAsc = new ArrayList<>(marks);
        Collections.sort(sortedAsc);
        System.out.println("Sorted (Ascending): " + sortedAsc);

        List<Integer> sortedDesc = new ArrayList<>(marks);
        Collections.sort(sortedDesc, Collections.reverseOrder());
        System.out.println("Sorted (Descending): " + sortedDesc);
        System.out.println("");

        // ========== REVERSING ==========
        List<Integer> reversed = new ArrayList<>(marks);
        Collections.reverse(reversed);
        System.out.println("Reversed: " + reversed);
        System.out.println("");

        // ========== SEARCHING ==========
        int searchMark = 92;
        System.out.println("Search for mark " + searchMark + ":");
        System.out.println("  Index of first occurrence: " + marks.indexOf(searchMark));
        System.out.println("  Last occurrence: " + marks.lastIndexOf(searchMark));
        System.out.println("  Contains " + searchMark + "? " + marks.contains(searchMark));
        System.out.println("");

        // ========== FILTERING (Find all marks above 85) ==========
        List<Integer> aboveThreshold = new ArrayList<>();
        for (int mark : marks) {
            if (mark >= 85) {
                aboveThreshold.add(mark);
            }
        }
        System.out.println("Marks >= 85: " + aboveThreshold);
        System.out.println("");

        // ========== FILTERING (Find all marks between 80-90) ==========
        List<Integer> inRange = new ArrayList<>();
        for (int mark : marks) {
            if (mark >= 80 && mark <= 90) {
                inRange.add(mark);
            }
        }
        System.out.println("Marks between 80-90: " + inRange);
        System.out.println("");

        // ========== FILTERING (Find passing marks only) ==========
        List<Integer> passing = new ArrayList<>();
        for (int mark : marks) {
            if (mark >= 80) {
                passing.add(mark);
            }
        }
        System.out.println("Passing marks (>= 80): " + passing);
        System.out.println("Total passing: " + passing.size());
        System.out.println("");

        // ========== REMOVE DUPLICATES ==========
        List<Integer> unique = new ArrayList<>(marks);
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < unique.size(); i++) {
            if (unique.lastIndexOf(unique.get(i)) != i) {
                if (!duplicates.contains(unique.get(i))) {
                    duplicates.add(unique.get(i));
                }
            }
        }
        System.out.println("Duplicate marks found: " + duplicates);
    }
}
