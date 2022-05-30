package com.example;
/*
 Project: Pi to the nth Digit
 Author: Emma du Maurier
 Date: 15 April 2022
 Description: Enter a number and have the program generate PI up to that many decimal places.
 Keep a limit to how far the program will go.

 Program Details: Calculations based off Machin's Formula.
 pi / 4 = 4(arctangent 1/5) - (arctangent 1/239)

 eg. Input of 4 will calculate to 4 decimal places and output 3.1416
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import static java.lang.System.*;

public class Main
{
    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    static boolean isDigit = false;
    static int dp;

    public static void main(String[] args)
    {
        dp = getInput();
        out.println(getPi(dp));
    }

    private static int getInput()
    {
        int num = 0;
        Scanner scanner = new Scanner(in);

        // Repeat the user input until a value of 1 to 1000 has been entered.
        while (!isDigit)
        {
            System.out.println("How many decimal places to calculate Pi?");
            System.out.println("Please enter a whole number between 1 and 1000, inclusive.");

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

            if ((num < 1 || num > 1000) && isDigit)
            {
                isDigit = false;
                System.out.println("You must enter a whole number between 1 and 1000, inclusive.");
                scanner = new Scanner(System.in);
            }
        }

        scanner.close();
        return num;
    }

    public static BigDecimal getPi(int digits)
    {
        int scale = digits + 5;

        BigDecimal arctan5 = arctan(5, scale);
        BigDecimal arctan239 = arctan(239, scale);
        BigDecimal pi = arctan5.multiply(FOUR).subtract(arctan239).multiply(FOUR);

        return pi.setScale(digits, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal arctan(int value, int scale)
    {
        BigDecimal result, number, term;
        BigDecimal inverse = BigDecimal.valueOf(value);
        BigDecimal inverseSq = BigDecimal.valueOf((double) value * value);

        number = BigDecimal.ONE.divide(inverse, scale, RoundingMode.HALF_EVEN);
        result = number;

        for (int i = 1; i <= dp; i++)
        {
            int x = 2 * i + 1;
            number = number.divide(inverseSq, scale, RoundingMode.HALF_EVEN);
            term = number.divide(BigDecimal.valueOf(x), scale, RoundingMode.HALF_EVEN);

            if (term.compareTo(BigDecimal.ZERO) == 0){
                return result;
            }

            if ((i % 2) != 0)
            {
                result = result.subtract(term);
            }
            else
            {
                result = result.add(term);
            }
        }
        return result;
    }
}
