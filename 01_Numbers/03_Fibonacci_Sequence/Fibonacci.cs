/*
 * Project: Generate Fibonacci Sequence to nth number
 * Author: Emma du Maurier
 * Date: 06 May 2024
 * Description: Enter a number and have the program generate the Fibonacci sequence up to that many places.
 * 
 * Program Details: If the user enters 10 from the console input, then the following output will be displayed;
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
*/

namespace Fibonacci
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter a number from 1 to 45 to generate the Fibonacci sequence up to that many places: ");
            int number = GetValidNumber();
            GenerateFibonacciSequence(number);
        }

        private static int GetValidNumber()
        {
            int number = 0;
            bool isValid = false;
            while (!isValid)
            {
                string input = Console.ReadLine();
                isValid = int.TryParse(input, out number) && number > 0;
                if (!isValid)
                {
                    Console.WriteLine("Invalid input. Please enter a positive integer: ");
                }
                else
                {
                    if (number > 45)
                    {
                        Console.WriteLine("Please enter a number that is 45 or under:");
                        isValid = false;
                    }
                }
            }
            return number;
        }

        private static void GenerateFibonacciSequence(int number)
        {
            int prevOne = 1, prevTwo = 0, fib;
            for (int i = 0; i < number; i++)
            {
                fib = prevOne + prevTwo;
                Console.WriteLine(fib);
                prevTwo = prevOne;
                prevOne = fib;
            }
        }
    }
}