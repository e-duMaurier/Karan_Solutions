package com.example;

/*
    Project: Euler's Number (e) to the nth Digit
    Author: Emma du Maurier
    Date: 16 April 2022
    Description: Coding exercise to find an approximation to the value of e to the nth digit.
    Depending on the scale, the last few digits may not show searched results due to the rounding mode.
    User selects an integer value, and an approximation of e is calculated to n decimal places.

    Program Details: Input of 5 will calculate to 5 decimal places and output 2.71828
*/

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import static java.lang.System.in;

public class Main
{
    static boolean isDigit = false;

    public static void main(String[] args)
    {
        int decimalPlaces = getInput();
        System.out.println("Euler's number to " + decimalPlaces + " decimal places:");
        System.out.println(euler(decimalPlaces));
    }

    private static BigDecimal euler(int scale)
    {
        BigDecimal e = BigDecimal.ONE;

        // Add ,one divided by the factorial for each value of i, to the value of e
        for (int i = 1; i <= 20; i++)
        {
            BigDecimal temp = gatFactorial(i);
            e = e.add(BigDecimal.ONE.divide(temp, scale, RoundingMode.HALF_EVEN));
        }

        return e;
    }

    private static BigDecimal gatFactorial(int fact)
    {
        BigDecimal factorial = BigDecimal.ONE;

        // Get the factorial of i for each value of i
        // eg i = 3, factorial 3! is 1 x 2 x 3 x 4
        for (int i = 1; i <= fact; i++)
        {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }

        return factorial;
    }

    private static int getInput()
    {
        int num = 0;
        Scanner scanner = new Scanner(in);

        // Repeat the user input until a value of 5 to 100 has been entered.
        while (!isDigit)
        {
            System.out.println("How many decimal places to calculate Pi?");
            System.out.println("Please enter a whole number between 5 and 100, inclusive.");

            try
            {
                num = scanner.nextInt();
                isDigit = true;
            }
            catch (Exception e)
            {
                System.out.println("Input must be a digit.");
                scanner = new Scanner(System.in);
            }

            if ((num < 5 || num > 100) && isDigit)
            {
                isDigit = false;
                System.out.println("You must enter a whole number between 5 and 100, inclusive.");
                scanner = new Scanner(System.in);
            }
        }

        scanner.close();
        return num;
    }
}
