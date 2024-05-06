/*
 Project: E to the nth Digit
 Author: Emma du Maurier
 Date: 06 May 2024
 Description: Enter a number and have the program generate Euler's Number up to that many decimal places.
 eg. Input of 4 will calculate to 4 decimal places and output 2.7183, as there will be some rounding when displaying the number.
 */

namespace FindE
{
    internal class Program
    {
        static void Main(string[] args)
        {
            bool valid = false;

            Console.WriteLine("Enter the number of decimal places to calculate Euler's Number to: ");
            Console.WriteLine("Please enter a number between 2 and 15");
            while (!valid)
            {
                try
                {
                    int decimalPlaces = Convert.ToInt32(Console.ReadLine());
                    if (decimalPlaces >= 2 && decimalPlaces <= 15)
                    {
                        valid = true;
                        double euler = GetEuler();
                        Console.WriteLine(euler.ToString($"F{decimalPlaces}").Substring(0, decimalPlaces + 2));
                    }
                    else
                    {
                        Console.WriteLine("Please enter a number between 2 and 15");
                    }
                }
                catch (FormatException)
                {
                    Console.WriteLine("Please enter a valid number between 2 and 15");
                }
            }
        }

        private static double GetEuler()
        {
            double euler = 0;

            for (int i = 0; i < 50; i++)
            {
                euler += 1 / Factorial(i);
            }

            return euler;
        }

        private static double Factorial(int n)
        {
            if (n <= 1)
            {
                return 1;
            }
            else
            {
                return n * Factorial(n - 1);
            }
        }
    }
}