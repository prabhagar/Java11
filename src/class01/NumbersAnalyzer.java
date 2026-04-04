package class01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumbersAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create a list of student marks
        List<Integer> marks = new ArrayList<>();
        
        // Ask user how many marks to enter
        System.out.print("How many students? ");
        int numStudents = scanner.nextInt();
        
        // Get marks from user
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter mark for Student " + (i + 1) + ": ");
            int mark = scanner.nextInt();
            marks.add(mark);
        }
        
        scanner.close();

        System.out.println("Student Marks: " + marks);
        System.out.println("Total students: " + marks.size());

        // Calculate sum
        int sum = 0;
        for (int mark : marks) {
            sum = sum + mark;
        }
        System.out.println("\nSum of all marks: " + sum);

        // Calculate average
        double average = (double) sum / marks.size();
        System.out.println("Average mark: " + average);

        // Find maximum using Collections.max()
        int maxMark = Collections.max(marks);
        System.out.println("Highest mark: " + maxMark);

        // Find minimum using Collections.min()
        int minMark = Collections.min(marks);
        System.out.println("Lowest mark: " + minMark);

        // Count how many marks are above average
        int aboveAverage = 0;
        for (int mark : marks) {
            if (mark > average) {
                aboveAverage++;
            }
        }
        System.out.println("Marks above average: " + aboveAverage);

        // Pass or Fail (assume 80 is passing)
        System.out.println("\nPass/Fail Status:");
        for (int i = 0; i < marks.size(); i++) {
            String status = marks.get(i) >= 80 ? "PASS" : "FAIL";
            System.out.println("Student " + (i + 1) + ": " + marks.get(i) + " - " + status);
        }
    }
}
