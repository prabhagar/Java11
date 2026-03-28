package class01;

public class StudentScoreAnalyzer {
    public static void main(String[] args) {
        String input = "Asha:78, Ravi:92, Mei:88, Omar:92";

        System.out.println("Class 1 Exercise");
        System.out.println("Input: " + input);
        System.out.println();
        System.out.println("Your task:");
        System.out.println("1. Find the highest score");
        System.out.println("2. Print all names with the highest score");
        System.out.println("3. Print the average score with 2 decimal places");
        System.out.println();

        var entries = input.split(",");
        var highestScore = Integer.MIN_VALUE;
        var topStudents = new StringBuilder();
        var totalScore = 0;
        var studentCount = 0;

        for (var entry : entries) {
            var parts = entry.strip().split(":");
            var name = parts[0].strip();
            var score = Integer.parseInt(parts[1].strip());

            totalScore += score;
            studentCount++;

            if (score > highestScore) {
                highestScore = score;
                topStudents.setLength(0);
                topStudents.append(name);
            } else if (score == highestScore) {
                topStudents.append(", ").append(name);
            }
        }

        double averageScore = (double) totalScore / studentCount;

        System.out.println("Highest score: " + highestScore);
        System.out.println("Top students: " + topStudents);
        System.out.printf("Average score: %.2f%n", averageScore);
    }
}