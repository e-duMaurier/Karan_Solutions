/*
    Class: ReturnedChange
    
    Project: Change Return Program
    Author: Emma du Maurier
    Date: 27 August 2024
    Description: The user enters a cost, then an amount of money given. The program will figure out the change
    and the number of quarters, dimes, nickels and pennies needed for the change.
*/

import java.util.Scanner;

public class ReturnedChange
{

    private static final double QUARTER = 0.25;
    private static final double DIME = 0.10;
    private static final double NICKEL = 0.05;
    private static final double PENNY = 0.01;
    private static final double DOLLAR = 1.0;

    public static void main(String[] args)
    {

        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        int dollars = 0;

        double cost, change;
        int paid;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter value of cost, using dollars and cents: ");
        cost = scanner.nextDouble();

        System.out.println("Please enter how much money given, using full dollars: ");
        paid = scanner.nextInt();

        change = (double)paid - cost;
        System.out.println("Change given is: " + change);

        while (change >= DOLLAR)
        {
            dollars++;
            change-= DOLLAR;
        }

        System.out.println("Dollars = " + dollars);

        while (change > 0.0)
        {
            if (change >= QUARTER)
            {
                quarters++;
                change -= QUARTER;
            }
            if (change >= DIME)
            {
                dimes++;
                change -= DIME;
            }
            if (change >= NICKEL)
            {
                nickels++;
                change -= NICKEL;
            }
            else
            {
                pennies++;
                change -= PENNY;
            }
        }

        System.out.println("Quarters = " + quarters);
        System.out.println("Dimes = " + dimes);
        System.out.println("Nickels = " + nickels);
        System.out.println("Pennies = " + pennies);
    }
}
