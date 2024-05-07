package com.example;

/*
    Project: Prime Factorisation for user entered number
    Author: Emma du Maurier
    Date: 16 April 2022
    Description: Enter a number and find all the Prime Factors in this number

    Program Details: If the user enters 300 then the program will display The prime factors of 300 are: 2 2 3 5 5
    2 * 2 * 3 * 5 * 5 = 300
*/

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int number, primes;
        StringBuilder primeFactors = new StringBuilder();

        do
        {
            System.out.println("Enter a number to find all the Prime Factors of");
            System.out.println("Between 1 and 1000 (inclusive)");
            number = scanner.nextInt();
            scanner.nextLine();
        }
        while ((number < 2) || (number > 1000));

        primes = 0;
        primeFactors.append("The prime factors of ").append(number).append(" are: ");

        // Get all occurrences of 2 being the prime factor
        while (number % 2 == 0)
        {
            primeFactors.append(2).append(" ");
            number /= 2;
            primes++;
        }

        // Skip all the even numbers and only process when i is an odd number
        for (int i = 3; i <= Math.sqrt(number); i += 2)
        {
            // Check number can be divided by i with no remainder
            while (number % i == 0)
            {
                primeFactors.append(i).append(" ");
                number /= i;
                primes++;
            }
        }

        if (primes == 0)
        {
            System.out.println("There are no prime factors in this number");
        }
        else
        {
            System.out.println("There are " + primes + " prime factors in this number");
            System.out.println(primeFactors);
        }
    }
}
