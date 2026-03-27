public class StudentScoreAnalyzerV2 {
    public static void main(String[] args) {
        String input = "Asha:78, Ravi:92, Mei:abc, :91, Omar:92, Diya-84, Kabir: 87";

        System.out.println("Class 1 Exercise V2");
        System.out.println("Input: " + input);
        System.out.println();
        System.out.println("Your task:");
        System.out.println("1. Process each student entry safely");
        System.out.println("2. Skip invalid entries and print why they were skipped");
        System.out.println("3. Print valid highest score");
        System.out.println("4. Print valid top students");
        System.out.println("5. Print valid average score with 2 decimal places");
        System.out.println();

        System.out.println("Rules:");
        System.out.println("- A valid entry must contain exactly one colon");
        System.out.println("- Name must not be blank");
        System.out.println("- Score must be a valid integer");
        System.out.println();

        var entries = input.split(",");
        var highestScore = Integer.MIN_VALUE;
        var topStudents = new StringBuilder();
        var totalScore = 0;
        var studentCount = 0;

        for (var entry : entries) {
            var trimmedEntry = entry.strip();
            if (!trimmedEntry.contains(":")) {
                System.out.println("Skipping invalid entry (missing colon): " + trimmedEntry);
                continue;
            }
            var parts = trimmedEntry.split(":");
            var name = parts[0].strip();
            if (name.isBlank()) {
                System.out.println("Skipping invalid entry (blank name): " + trimmedEntry);
                continue;
            }
            var scorePart = parts[1].strip();
            int score;
            try {
                score = Integer.parseInt(scorePart);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid entry (invalid score): " + trimmedEntry);
                continue;
            }

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
        // 6. If no valid students exist, print:
        //    No valid student data found.
        // 7. Otherwise print the final result.

        if (studentCount > 0) {
            System.out.println("Highest score: " + highestScore);
            System.out.println("Top students: " + topStudents);
            double averageScore = (double) totalScore / studentCount;
            System.out.printf("Average score: %.2f%n", averageScore);
        } else {
            System.out.println("No valid student data found.");
        }
    }
}