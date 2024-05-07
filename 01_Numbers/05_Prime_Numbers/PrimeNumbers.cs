/*
 * Project: Prime Numbers
 * Author: Emma du Maurier
 * Date: 07 May 2024
 * Description: The program will generate prime numbers when the enter key is pressed.
 * The user can stop the program by pressing the 'q' key.
*/

namespace PrimeNumbers;

internal class Program
{
    private static int counter = 1;

    static void Main(string[] args)
    {
        Console.WriteLine("Press 'Enter' to get the next Prime Number");
        Console.WriteLine("Press 'q' to quit the program");

        // Get the first Prime Number, so that the user can see the first number.
        // The user can then press 'Enter' to get the next Prime Number.
        GetNextPrimeNumber();

        while (true)
        {
            GetKeyPress();
        }
    }

    private static void GetNextPrimeNumber()
    {
        if(!IsPrime(counter))
        {
            counter++;
            GetNextPrimeNumber();
        }
        else
        {
            Console.WriteLine(counter);
            counter++;
        }
    }
    
    private static void GetKeyPress()
    {
        var key = Console.ReadKey().KeyChar;

        if (key.ToString().ToLower() == "q")
        {
            // Call an exit code to end the application.
            Environment.Exit(0);
        }
        else if (key == (13)) // 13 represents the Enter key
        {
            GetNextPrimeNumber();
        }
    }
    
    static bool IsPrime(int number)
    {
        // Check if the number is less than or equal to 1. Also check of the number is divisible by 2 or 3.
        // check if the number is divisible by 2 or 3. If it is, return false.
        // If any of these conditions are true, the number is not prime, so return false.

        // If none of the above conditions are false, or if the number is 2 or 3, return true.

        if (number <= 1)
        {
            return false;
        }

        if (number == 2 || number == 3)
        {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0)
        {
            return false;
        }

        int divisor = 5;
        int increment = 2;

        while (divisor * divisor <= number)
        {
            if (number % divisor == 0)
            {
                return false;
            }

            divisor += increment;
            increment = 6 - increment;
        }

        return true;
    }
}
