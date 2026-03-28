package class01;

public class StringLab {
    public static void main(String[] args) {
        String raw = "   Java 11+ Learning   ";
        String blank = "   ";
        String multi = "alpha\nbeta\ngamma";

        System.out.println("isBlank(blank): " + blank.isBlank());
        System.out.println("strip(raw): [" + raw.strip() + "]");
        System.out.println("repeat: " + "Hi ".repeat(3));

        long lineCount = multi.lines().count();
        System.out.println("lines count: " + lineCount);
    }
}