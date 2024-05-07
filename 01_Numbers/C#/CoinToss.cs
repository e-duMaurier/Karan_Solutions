/*
 * Project: Coin Toss
 * Author: Emma du Maurier
 * Date: 07 May 2024
 * Description: Simulate flipping a single coin however many times the user decides. 
 * The code records the outcomes and counts the number of tails and heads.
 * This is displayed once all coin flips are completed.
*/

namespace Karan_Solutions;

internal static class CoinToss
{
    private static readonly string[] coinSide = ["Heads", "Tails" ];

    static void Main()
    {
        int tailsCount = 0, headsCount = 0;
        Random coinFlip = new Random();

        Console.WriteLine("How many times should the coin be tossed?");
        int max = GetNumberOfFlips();

        for (int i = 1; i <= max; i++)
        {
            int result = coinFlip.Next(coinSide.Length);

            Console.WriteLine(coinSide[result]);

            CountResult(result, ref tailsCount, ref headsCount);
        }

        Console.WriteLine($"The coin landed on heads {headsCount} times, and tails {tailsCount} times");
    }

    private static int GetNumberOfFlips()
    {
        int input;
        while (!int.TryParse(Console.ReadLine(), out input))
        {
            Console.WriteLine("Invalid input. Please enter a valid integer.");
        }
        return input;
    }

    private static void CountResult(int result, ref int tailsCount, ref int headsCount)
    {
        switch (result)
        {
            case 0:
                tailsCount++;
                break;
            case 1:
                headsCount++;
                break;
            default:
                Console.WriteLine("By some miracle, the coin has landed on its side!!!");
                break;
        }
    }
}