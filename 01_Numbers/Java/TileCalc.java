/*
    Class: TileCalc
    
    Project: Cost of tiles to cover W x L floor.
    Author: Emma du Maurier
    Date: 25 August 2024
    Description: Application will ask user to answer three inputs, the width and length of a floor, and the cost of a
     tile, separated by a space. Using a preferred 30cm x 30cm tile size, the program will then calculate the total
     cost of the tiles required to cover the area.
*/

import java.util.Scanner;

public class TileCalc
{
    public static void main(String[] args)
    {
        double floorArea;
        double totalCost;
        // Tile size in centimetres
        double tileSize = 0.3 * 0.3;

        System.out.println("Please enter floor dimensions in metres, and tile cost.");
        System.out.println("Enter each as a decimal number, separated by space, in the order of Width, Length, Cost");
        System.out.println("Eg: 12.5 9.7 3.50");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Split the string into an array, then assign each value in the array to the appropriate variable
        String[] numbers = input.split(" ");
        double floorWidth = Double.parseDouble(numbers[0]);
        double floorLength = Double.parseDouble(numbers[1]);
        double tileCost = Double.parseDouble(numbers[2]);

        floorArea = floorWidth * floorLength;
        totalCost = Math.ceil(floorArea / tileSize) * tileCost;

        String output = String.format("It will cost %.2f to cover an area of %.2f", totalCost, floorArea);
        System.out.println(output);
    }
}
