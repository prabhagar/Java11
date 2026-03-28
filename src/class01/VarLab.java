package class01;

import java.util.ArrayList;

public class VarLab {
    public static void main(String[] args) {
        var names = new ArrayList<String>();
        names.add("Asha");
        names.add("Ravi");
        names.add("Mei");

        for (var name : names) {
            System.out.println(name.toUpperCase());
        }

        var totalChars = 0;
        for (var name : names) {
            totalChars += name.length();
        }

        System.out.println("Total chars: " + totalChars);
    }
}