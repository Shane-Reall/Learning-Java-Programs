//Name: Shane Reall
//Program: Takes three inputs to use in the equation of (2a+c)/(b-3a) + v(c^2 - 85) & (2a+c)/(b-3a) - v(c^2 - 85)
//Year: 2022-2023 Freshman
//Software: Textpad

import java.util.Scanner;
public class EquationSolver
{
	public static void main(String[] args)
	{
		double a;
		double b;
		double c;
		Scanner scanner;
		scanner = new Scanner(System.in);
		double positiveSolution = 0;
		double negativeSolution = 0;


		System.out.print("Enter the First Value or -999 for Solution: ");
		a = scanner.nextDouble();
		if (a == -999)
		{
			System.out.println("Now Terrminating Program");
		}
		while (a != -999)
		{
			System.out.print("Enter the Second Value: ");
			b = scanner.nextDouble();
			System.out.print("Enter the Last Value: ");
			c = scanner.nextDouble();
			if (b == a * 3)
			{
				System.out.println("ERROR- Divide by Zero Error");
				System.out.print(" Re-enter the First Value or -999 for Solution: ");
			}
			else if ((c * c) - 85 <= 0)
			{
				System.out.println("ERROR- Rooting of a Negative Value Cannot Be Processed");
				System.out.print(" Re-enter the First Value or -999 for Solution: ");
			}
			else
			{
				positiveSolution = ((2*a+c)/(b-3*a))+(Math.sqrt(c * c - 85));
				negativeSolution = ((2*a+c)/(b-3*a))-(Math.sqrt(c * c - 85));
				System.out.println("Results are " + positiveSolution + " & " + negativeSolution );
				System.out.print("Enter the First Value or -999 for Solution: ");
			}
			a = scanner.nextDouble();
		}
			scanner.close();
	}
}