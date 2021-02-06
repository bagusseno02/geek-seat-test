import java.text.DecimalFormat;
import java.text.NumberFormat;

import static utils.GeekSeatUtils.*;

/**
 * @author <a href="mailto:bagus.seno39@gmail.com>seno</a>
 * Created on 06/02/21
 * Project GeekSeatTest
 */
public class GeekSeatTestApplication {

    public static Integer[] totalCasesPerYears, ageOfDeath, yearOfDeath, resultYear;

    public static String[] suffixes = {"st", "nd", "rd", "th", "th", "th", "th", "th", "th",
                    "th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
                    "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
                    "th", "st" };

    public static void main(String[] args) {
        setRules();
        System.out.println(formatingDouble(averagePersonKilled()));
    }

    /* Rule to decide the number of villagers she should kill each year */
    private static void setRules() {
        System.out.println("\n========================================== RULES ==========================================");
        System.out.println("Set Rules : ");

        int n = inputValue();
        totalCasesPerYears = new Integer[n + 1];
        int totalVillages = 1;

        for (int i = 1; i <= n; i++) {

            int x = 0;
            int y = 1;
            int z = 0;

            System.out.print("On the " + i + suffixes[i - 1] + " year she kills " + y);

            for (int j = 1; j < i; j++) {
                z = x + y;
                System.out.print("+" + z);
                x = y;
                y = z;
            }

            totalVillages += z;
            totalCasesPerYears[i] = totalVillages;

            if (i == 1) {
                System.out.println(" Villagers");
            } else {
                System.out.println(" = " + totalVillages + " Villagers");
            }

        }

    }

    /* Solution */
    private static double averagePersonKilled() {

        System.out.println("\n======================================= TOTAL PERSON =======================================");
        System.out.println("Set Total Person : ");
        int totalPerson = inputValue();

        ageOfDeath = new Integer[totalPerson + 1];
        yearOfDeath = new Integer[totalPerson + 1];
        resultYear = new Integer[totalPerson + 1];

        for (int i = 1; i <= totalPerson; i++) {

            System.out.println("Age of death = ");
            ageOfDeath[i] = inputValue();

            /* Checking Negative Value */
            if (ageOfDeath[i] <= 0)
                return -1;

            System.out.println("Year of death = ");
            yearOfDeath[i] = inputValue();

            /* Checking Negative Value */
            if (getYear(yearOfDeath[i], ageOfDeath[i]) <= 0)
                return -1;

            resultYear[i] = getYear(yearOfDeath[i], ageOfDeath[i]);

        }

        System.out.println("\n========================================== RESULT ==========================================");
        int totalCases = 0;
        double average;
        for (int j = 1; j <= totalPerson; j++) {
            System.out.println("Person " + getCharForNumber(j) + " born on Year = " + yearOfDeath[j] + " - " + ageOfDeath[j] + " = " + resultYear[j] + ", number of people killed on year " + resultYear[j] + " is " + totalCasesPerYears[resultYear[j]]);
            totalCases += totalCasesPerYears[resultYear[j]];
        }

        average = calculateAveragePersonKilled(totalCases, totalPerson);
        System.out.println("So the average = " + formatingDouble(average));

        return average;
    }

    private static void testAveragePersonKilled() {
        averagePersonKilled();
    }

}
