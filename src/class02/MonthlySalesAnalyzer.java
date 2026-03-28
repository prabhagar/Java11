package class02;

public class MonthlySalesAnalyzer {
    public static void main(String[] args) {
        int[] monthlySales = {1200, 980, 1450, 1100, 1450, 890};

        System.out.println("Class 2 Exercise");
        System.out.println("Topic: Arrays + Methods");
        System.out.println();

        printSales(monthlySales);

        int highestSales = findHighestSales(monthlySales);
        double averageSales = calculateAverageSales(monthlySales);
        int monthsAboveAverage = countMonthsAboveAverage(monthlySales, averageSales);

        System.out.println();
        System.out.println("Highest sales: " + highestSales);
        System.out.println("Best months: " + findBestMonths(monthlySales, highestSales));
        System.out.printf("Average sales: %.2f%n", averageSales);
        System.out.println("Months above average: " + monthsAboveAverage);
    }

    static void printSales(int[] sales) {
        System.out.println("Monthly sales data:");

        for (int index = 0; index < sales.length; index++) {
            System.out.println("Month " + (index + 1) + ": " + sales[index]);
        }
    }

    static int findHighestSales(int[] sales) {
        // TODO:
        // Return the highest value in the array.
        int highest = sales[0];
        for (int i = 1; i < sales.length; i++) {
            if (sales[i] > highest) {
                highest = sales[i];
            }
        }
        return highest;
    }

    static String findBestMonths(int[] sales, int highestSales) {
        // TODO:
        // Return the month numbers that match highestSales.
        // Example: if month 3 and month 5 have the same top value,
        // return "3, 5".
        StringBuilder bestMonths = new StringBuilder();
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] == highestSales) {
                if (bestMonths.length() > 0) {
                    bestMonths.append(", ");
                }
                bestMonths.append(i + 1);
            }
        }
        return bestMonths.toString();
    }

    static double calculateAverageSales(int[] sales) {
        // TODO:
        // Add all values and return the average as double.
            int total = 0;
            for (int sale : sales) {
                total += sale;
            }
            return (double) total / sales.length;
    }

    static int countMonthsAboveAverage(int[] sales, double averageSales) {
        // TODO:
        // Count how many months have sales strictly greater than averageSales.
        int count = 0;
        for (int sale : sales) {
            if (sale > averageSales) {
                count++;
            }
        }
        return count;
    }
}