/*
 * Project: Decimal to binary to decimal converter
 * Author: Emma du Maurier
 * Date: 01 June 2024
 * Description: Convert a decimal number to binary or a binary number to its decimal equivalent.
*/

namespace Karan_Solutions;

internal static class Program
{
    private static void Main()
    {
        Console.WriteLine("Please enter a whole number to convert to binary:");
        string input = Console.ReadLine();
        int number = CheckInput(input);

        while (number == 0)
        {
            Console.WriteLine("Please enter a valid number:");
            input = Console.ReadLine();
            number = CheckInput(input);
        }

        string binary = ConvertToBinary(number);
        Console.WriteLine($"{input} converted to binary is {binary}");

        int dec = ConvertToDecimal(binary);
        Console.WriteLine($"{binary} converted back to decimal is {dec}");
    }

    private static int CheckInput(string input)
    {
        if (string.IsNullOrWhiteSpace(input) || !int.TryParse(input, out int number))
        {
            Console.WriteLine("Please enter a valid number.");
            return 0;
        }

        return number;
    }

    private static string ConvertToBinary(int decNumber)
    {
        int number = decNumber;
        string binary = string.Empty;

        while (number > 0)
        {
            int remainder = number % 2;
            number /= 2;
            binary = remainder.ToString() + binary;
        }

        return binary;
    }

    private static int ConvertToDecimal(string binaryNumber)
    {
        int dec = 0;
        int power = 0;

        for (int i = binaryNumber.Length - 1; i >= 0; i--)
        {
            if (binaryNumber[i] == '1')
            {
                dec += (int)Math.Pow(2, power);
            }
            power++;
        }

        return dec;
    }
}
