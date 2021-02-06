package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author <a href="mailto:bagus.seno39@gmail.com>seno</a>
 * Created on 06/02/21
 * Project GeekSeatTest
 */
public class GeekSeatUtils {

    NumberFormat formatter = new DecimalFormat("#0.00");
    public static Scanner sc = new Scanner(System.in);

    /* Input Total Years */
    public static Integer inputValue() {
        return sc.nextInt();
    }

    private static void testInputValue() {
        System.out.println("Value : " + inputValue());
    }

    /* Char For Number */
    public static String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char) (i + 'A' - 1)) : null;
    }

    private static void testGetCharForNumber(){
        System.out.println("Char : " + getCharForNumber(5));
    }

    /* Calculate Person Killed */
    public static int getYear(int yearOfDeath, int ageOfDeath) {
        return yearOfDeath - ageOfDeath;
    }

    private static void testCalculateYear() {
        System.out.println("Number of people killed on year : " + getYear(10, 5));
    }

    /* Calculate Average Person Killed */
    public static double calculateAveragePersonKilled(double totalPersonKilled, double totalCases) {
        return totalPersonKilled / totalCases;
    }

    private static void testCaculateAveragePersonKilled() {
        System.out.println("Average is : " + calculateAveragePersonKilled(7, 2));
    }

    /* Formatting Double */
    public static String formatingDouble(double value){
        NumberFormat formatter = new DecimalFormat("#0.0");
        return formatter.format(value);
    }

}
