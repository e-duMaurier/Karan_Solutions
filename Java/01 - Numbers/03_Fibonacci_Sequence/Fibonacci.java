package com.example;

/*
    Project: Generate Fibonacci Sequence to nth number
    Author: Emma du Maurier
    Date: 16 April 2022
    Description: Enter a number and have the program generate the Fibonacci sequence up to that many places.

    Program Details: If the user enters 10 from the console input, then the following output will be displayed;
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34
*/

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int posOne = 0;
        int posTwo = 1;
        int f, end;

        do
        {
            System.out.println("How many numbers of the Fibonacci sequence to display?");
            System.out.println("Between 1 and 45 (inclusive)");
            end = scanner.nextInt();
            scanner.nextLine();
        }
        while ((end < 1) || (end > 45));

        // Check if the user entered '1' then display the first number of the sequence.
        if (end == 1)
        {
            System.out.println("Fibonacci Sequence:");
            System.out.println(posOne);
        }
        // Check if the user entered '2' then display the first and second numbers of the sequence.
        else if (end == 2)
        {
            System.out.println("Fibonacci Sequence:");
            System.out.println(posOne + ", " + posTwo);
        }
        // If the user entered 3 or higher, display the first two numbers of the sequence, then generate and display
        // each number after that until it reaches how many numbers the user entered.
        else
        {
            System.out.println("Fibonacci Sequence:");
            System.out.println(posOne + "\n" + posTwo);

            for (int i = 3; i <= end; i++)
            {
                f = posOne + posTwo;
                System.out.println(f);
                posOne = posTwo;
                posTwo = f;
            }
        }
    }
}
