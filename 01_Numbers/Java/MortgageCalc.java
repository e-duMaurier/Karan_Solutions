/*
    Class: MortgageCalc
    
    Project: Mortgage Calculator
    Author: Emma du Maurier
    Date: 25 August 2024
    Description: Calculate the monthly payments of a fixed term mortgage over given Nth terms at a given interest rate,
    and how long it will take the user to pay back the loan.

    This uses a standard method for calculating mortgage repayments:
    r = annual interest rate (APRC) / 12 (Months)
    p = princial (starting balance)
    n = total payments, eg 25 year mortgage = 25 * 12 = 300

    The formula for this is:
    payment = p * r(1 + r)^n / (1 + r)^n - 1

    TODO add an option for users to select the compounding interval (Monthly, Weekly, Daily, Continually).
*/

import java.util.Scanner;

public class MortgageCalc
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter mortgage amount: ");
        double mortgageAmount = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter interest rate: ");
        double interestRate = Double.parseDouble(scanner.nextLine());

        System.out.print("Select Compound Interval: (Y)ear, (M)onthly, (D)aily: ");
        char compoundInterval = scanner.next().charAt(0);
        // This is required as scanner.next() doesn't consume a newline character.
        // Causes an empty string in the next scanner.nextline()
        scanner.nextLine();

        int compoundValue;
        switch(Character.toUpperCase(compoundInterval))
        {
            case 'Y':
                compoundValue = 1;
                break;
            case 'M':
                compoundValue = 12;
                break;
            case 'D':
                compoundValue = 360;
                break;
            default:
                compoundValue = 12;
                break;
        }

        System.out.print("Enter mortgage term in years: ");
        int mortgageTerm = Integer.parseInt(scanner.nextLine());

        double compoundInterest = (interestRate / compoundValue) / 100.0;
        int totalPayments = mortgageTerm * 12;

        String output = String.format("Monthly interest rate: %.5f", compoundInterest);
        System.out.println(output);
        output = String.format("Total payments: %2s", totalPayments);
        System.out.println(output);

        double compoundedInterestFactor = roundDecimalPlaces(Math.pow(compoundInterest + 1.0, totalPayments), 5);

        double monthlyPayments = mortgageAmount * roundDecimalPlaces(
                (compoundInterest * compoundedInterestFactor) / (compoundedInterestFactor - 1.0), 5);

        output = String.format("Monthly payments:  %.2f", monthlyPayments);
        System.out.println(output);

        scanner.close();
    }

    // Method to round a given double number to a specified number of places, calculating a scaling factor by
    // raising 10 to the power of places
    private static double roundDecimalPlaces(double value, int places)
    {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
