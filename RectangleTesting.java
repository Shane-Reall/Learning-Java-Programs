//Name: Shane Reall
//Program: Takes in user inputs to find the width, length, area, and perimeter of the rectangle. It also allows the user to input a test point to check if it falls within the bounds of the rectangle or not.
//Year: 2022-2023 Freshman
//Software: Textpad

import java.util.Scanner;
public class RectangleTesting
{
	public static void main(String[] args)
	{
		double testPointX;
		double testPointY;
		Scanner		scanner;
		scanner = new Scanner(System.in);
		Rectangle cordinates;

		cordinates = Rectangle.getPointsFromUser(scanner);

		if (!(cordinates.ulx > cordinates.lrx || cordinates.uly < cordinates.lry))
		{
			cordinates.displayPoints();
			cordinates.calculateWidth();
			cordinates.calculateLength();
			cordinates.calculateArea();
			cordinates.calculatePerimeter();

			System.out.println("Enter a Point to be Tested by Inserting both the X an Y Numbers Seperated by a Space:");
			testPointX = scanner.nextDouble();
			testPointY = scanner.nextDouble();
			if (testPointX <= cordinates.lrx && testPointX >= cordinates.ulx && testPointY >= cordinates.lry && testPointY <= cordinates.uly)
			{
				System.out.println("True");
			}
			else
			{
				System.out.println("False");
			}

		}
		else if (cordinates.ulx > cordinates.lrx)
		{
			System.out.println("Error: The Upper-Left X Should NEVER be Higher than the Lower-Right X! NOW TERMINATING PROGRAM");
		}
		else
		{
			System.out.println("Error: The Lower-Right Y Should NEVER be Higher than the Upper-Left Y! NOW TERMINATING PROGRAM");
		}

	}
}

class Rectangle
{
	double ulx;
	double uly;
	double lrx;
	double lry;

	static Rectangle getPointsFromUser(Scanner scanner)
	{
		Rectangle	rect;
		rect = new Rectangle();

		System.out.println("Insert the Upper-Left Point by Inserting only the X and Y Numbers and Seperating them with a Space:");
		rect.ulx = scanner.nextDouble();
		rect.uly = scanner.nextDouble();

		System.out.println("Insert the Lower-Right Point by Inserting only the X and Y Numbers and Seperating them with a Space:");
		rect.lrx = scanner.nextDouble();
		rect.lry = scanner.nextDouble();

		return rect;
	}

	void displayPoints()
	{
		System.out.println("(" + ulx + "," + uly + ") (" + lrx + "," + lry + "}");
	}

	void calculateWidth()
	{
		System.out.println("Width: " + (lrx - ulx));
	}

	void calculateLength()
	{
		System.out.println("Length: " + (uly - lry));
	}

	void calculateArea()
	{
		System.out.println("Area: " + (lrx - ulx) * (uly - lry));
	}

	void calculatePerimeter()
	{
		System.out.println("Perimeter: " + ((lrx - ulx) + (uly - lry) + (lrx - ulx) + (uly - lry)));
	}
}