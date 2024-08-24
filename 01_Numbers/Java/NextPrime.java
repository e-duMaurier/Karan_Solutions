/*
    Class: NextPrime
    
    Project: Next Prime Number
    Author: Emma du Maurier
    Date: 24 August 2024
    Description: Program will continually find and display the next prime number. When the next prime is found, user
    input is then requested. An input of Q will close the program, Enter will continue to the next line, and all other
    text is ignored.
*/

import java.util.Scanner;

public class NextPrime
{
    public static void main(String[] args)
    {
        int counter = 1;
        boolean stopped = false;

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Press 'Enter' for next Prime Number, or type 'q' to quit.");
        while (!stopped)
        {
            if (isPrime(counter))
            {
                System.out.print(counter + " ");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("q"))
                {
                    stopped = true;
                }
                else if (!input.isEmpty())
                {
                    System.out.println("Press 'Enter' for next Prime Number, or 'Q' to quit.");
                }
            }
            counter++;
        }
    }

    private static Boolean isPrime(int number)
    {
        if (number <= 1)
        {
            return false;
        }

        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}
