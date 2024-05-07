/*
 * Project: Mortgage Calculator
 * Author: Emma du Maurier
 * Date: 07 May 2024
 * Description: Calculate the monthly payments of a fixed term mortgage
 * over given Nth terms at a given interest rate, and how long it will
 * take the user to pay back the loan.
 * 
 * For added complexity, add an option for users to select the 
 * compounding interval (Monthly, Weekly, Daily, Continually).

*/

namespace MortgageCalculator;

internal class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Enter the mortgage amount: ");
        decimal loanAmount = Convert.ToDecimal(Console.ReadLine());

        Console.WriteLine("Enter the interest rate: ");
        double annualInterestRate = Convert.ToDouble(Console.ReadLine());

        Console.WriteLine("Enter a letter for the Compound Interval:");
        Console.WriteLine("(Y)early, (M)onthly, (D)aily, (C)ontinual");
        char compoundInterval = Console.ReadKey().KeyChar;

        int compoundValue;
        switch (compoundInterval)
        {
            case 'Y':
                compoundValue = 1;
                break;
            case 'D':
                compoundValue = 360;
                break;
            // TODO - Implement formula for continual compound.
            case 'C':
                compoundValue = 1;
                break;
            default:
                compoundValue = 12;
                break;
        }

        Console.WriteLine("\n Enter the mortgage term, in years: ");
        int mortgageTermInYears = Convert.ToInt16(Console.ReadLine());

        double compoundInterest = (annualInterestRate / compoundValue) / 100.0;
        int totalPayments = mortgageTermInYears * 12;

        Console.WriteLine($"Monthly Interest Rate: {compoundInterest}");
        Console.WriteLine($"Total Payments : {totalPayments}");

        double temp1 = Math.Round(Math.Pow(compoundInterest + 1.0, totalPayments), 5);
        Console.WriteLine(temp1);

        decimal monthlyPayment = loanAmount * (decimal)Math.Round((compoundInterest * temp1) / (temp1 - 1.0), 5);
        Console.WriteLine(Math.Round(monthlyPayment, 2));
    }
}

