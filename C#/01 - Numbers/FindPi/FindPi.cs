/*
 Project: Pi to the nth Digit
 Author: Emma du Maurier
 Date: 03 May 2024
 Description: Enter a number and have the program generate PI up to that many decimal places.
 Keep a limit to how far the program will go.

 Program Details: Calculations based off Machin's Formula.
 pi / 4 = 4(arctangent 1/5) - (arctangent 1/239)

 eg. Input of 4 will calculate to 4 decimal places and output 3.1416
 */

namespace FindPi
{
	class Program
	{
		static void Main(string[] args)
		{
			bool valid = false;

			Console.WriteLine("Enter the number of decimal places to calculate Pi to: ");
			Console.WriteLine("Please enter a number between 2 and 15");
			while (!valid)
			{
				try
				{
					int decimalPlaces = Convert.ToInt32(Console.ReadLine());
					if (decimalPlaces >= 2 && decimalPlaces <= 15)
					{
						valid = true;
						Console.WriteLine($"Pi to {decimalPlaces} decimal places is: {MachinPi(decimalPlaces)}");
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
		static string MachinPi(int decimalPlaces)
		{
			double arcTan5 = Math.Atan(1.0 / 5);
			double arcTan239 = Math.Atan(1.0 / 239);
			double pi = 4 * (4 * arcTan5 - arcTan239);
			return pi.ToString($"F{decimalPlaces}").Substring(0, decimalPlaces + 2);
		}
	}
}
