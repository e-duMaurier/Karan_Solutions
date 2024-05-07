/*
    Project: Prime Factorisation for user entered number
    Author: Emma du Maurier
    Date: 06 May 2024
    Description: Enter a number and find all the Prime Factors in this number

    Program Details: If the user enters 300 then the program will display The prime factors of 300 are: 2 2 3 5 5
    2 * 2 * 3 * 5 * 5 = 300
*/

namespace PrimeFactorisation
{
    internal class Program
    {
        static void Main(string[] args)
{
    Console.WriteLine("Enter a number between 3 amd 1000, to find the prime factorisation: ");
    int number = GetValidNumber();
    
    StringBuilder primeFactors = new();
    primeFactors.Append("The prime factorization of " + number + " results are: \n");

    int numberOfPrimes = 0;

    while (number % 2 == 0)
    {
        numberOfPrimes++;
        number /= 2;
        primeFactors.Append("2 ");
    }

    for (int i = 3; i <= Math.Sqrt(number); i += 2)
    {
        while (number % i == 0)
        {
            numberOfPrimes++;
            number /= i;
            primeFactors.Append(i + " ");
        }
    }

    if(numberOfPrimes == 0)
    {
        Console.WriteLine($"{number} has no prime factors");
    }
}

 private static int GetValidNumber()
{
    int number = 0;
    bool isValid = false;
    while (!isValid)
    {
        var input = Console.ReadLine();
        isValid = int.TryParse(input, out number) && number >= 3;
        if (!isValid)
        {
            Console.WriteLine("Invalid input");
            Console.WriteLine("Please enter a whole number greater than 2");
        }
        else
        {
            if (number > 1000)
            {
                Console.WriteLine("Please enter a number that is 1000 or under:");
                isValid = false;
            }
        }
    }
    return number;
}
    }
}