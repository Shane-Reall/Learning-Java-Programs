//Name: Shane Reall
//Program: Takes the current time as well as the amout of time you wish to wait. It then calculates the time that it would be after the requested time had past.
//Year: 2022-2023 Freshman
//Software: Textpad

import java.util.Scanner;
public class TimeCalc
{
	public static void main(String[] args)
	{
		//Variables
		StartInputVariables	siv;
		DelayInputVariables	div;
		FinalTimeVariables	ftv;
		int	startHourMain;
		int	startMinuteMain;
		String	startAmPmMain;
		int	delayHourMain;
		int	delayMinuteMain;
		int	finalHourMain;
		int	finalMinuteMain;
		String	finalAmPmMain;
		Scanner scanner;
		scanner = new Scanner(System.in);

		System.out.print("Enter the Start-Hour: ");
		startHourMain = scanner.nextInt();

		while (startHourMain != -999)
		{

			//Start Time Inputs
			siv = StartInput(scanner, startHourMain);
			startHourMain = siv.startHour;
			startMinuteMain = siv.startMinute;
			startAmPmMain = siv.startAmPm;
			System.out.println(startHourMain + ":" + startMinuteMain + " " + startAmPmMain);

			//Delay Time Inputs
			div = DelayInput(scanner);
			delayHourMain = div.delayHour;
			delayMinuteMain = div.delayMinute;

			//Calculate
			ftv = Calculation(delayHourMain, delayMinuteMain, startHourMain, startMinuteMain, startAmPmMain);
			finalHourMain = ftv.finalHour;
			finalMinuteMain = ftv.finalMinute;
			finalAmPmMain = ftv.finalAmPm;
			//Returns Answer

			Answer (finalHourMain, finalMinuteMain, finalAmPmMain);

			//Restart Loop
			System.out.print("Enter the Start-Hour: ");
			startHourMain = scanner.nextInt();
		}
	}

	static StartInputVariables StartInput (Scanner scanner, int startingHour)
	{
		StartInputVariables startVariable;
		startVariable = new StartInputVariables();
		startVariable.startHour = startingHour;
		System.out.print("Enter the Start-Minute: ");
					startVariable.startMinute = scanner.nextInt();
					System.out.print("Enter AM or PM: ");
					scanner.nextLine();
					startVariable.startAmPm = scanner.nextLine();
					startVariable.startAmPm = startVariable.startAmPm.toUpperCase();
				 while (startVariable.startHour > 12)
						{
							System.out.print("ERROR- Any hour Above 12 is not Valid, Reenter the Start-Time: ");
							startVariable.startHour = scanner.nextInt();
							System.out.print("Enter the Start-Minute: ");
							startVariable.startMinute = scanner.nextInt();
							System.out.print("Enter AM or PM: ");
							scanner.nextLine();
							startVariable.startAmPm = scanner.nextLine();
							startVariable.startAmPm = startVariable.startAmPm.toUpperCase();
				}
				while (startVariable.startMinute > 59)
						{
							System.out.print("ERROR- Any minute Above 60 is not Valid, Reenter the Start-Time: ");
							startVariable.startHour = scanner.nextInt();
							System.out.print("Enter the Start-Minute: ");
							startVariable.startMinute = scanner.nextInt();
							System.out.print("Enter AM or PM: ");
							scanner.nextLine();
							startVariable.startAmPm = scanner.nextLine();
							startVariable.startAmPm = startVariable.startAmPm.toUpperCase();
				}
				while (startVariable.startAmPm.equals("AM") == false && startVariable.startAmPm.equals("PM") == false)
						{
							System.out.print("ERROR- Any letters besides AM & PM are not Valid, Reenter the Start-Time: ");
							startVariable.startHour = scanner.nextInt();
							System.out.print("Enter the Start-Minute: ");
							startVariable.startMinute = scanner.nextInt();
							System.out.print("Enter AM or PM: ");
							scanner.nextLine();
							startVariable.startAmPm = scanner.nextLine();
							startVariable.startAmPm = startVariable.startAmPm.toUpperCase();
		}
		return startVariable;
	}

	static DelayInputVariables DelayInput (Scanner scanner)
	{
		DelayInputVariables delayVariable;
		delayVariable = new DelayInputVariables();
		System.out.print("Enter the Delay-Hour: ");
		delayVariable.delayHour = scanner.nextInt();
		System.out.print("Enter the Delay-Minute: ");
		delayVariable.delayMinute = scanner.nextInt();
		System.out.println(delayVariable.delayHour + " Hr(s) " + delayVariable.delayMinute + " Min(s)");
		return delayVariable;
	}

	static FinalTimeVariables Calculation (int HourAddOn, int MinuteAddOn, int BeginHour, int BeginMinute, String amPmEquals)
	{
		FinalTimeVariables finalVariable;
		finalVariable = new FinalTimeVariables();
		//Add Finals and Delay
			finalVariable.finalHour = BeginHour + HourAddOn;
			finalVariable.finalMinute = BeginMinute + MinuteAddOn;
			finalVariable.finalAmPm = amPmEquals;

		//Calculate End Times
			if (finalVariable.finalAmPm.equals("AM"))
			{
				finalVariable.amPmTracker = 2;
			}
			else
			{
				finalVariable.amPmTracker = 3;
			}

			while (finalVariable.finalMinute >= 60)
			{
				finalVariable.finalHour++;
				finalVariable.finalMinute = finalVariable.finalMinute - 60;
			}

			while (finalVariable.finalHour > 12)
			{
				finalVariable.finalHour = finalVariable.finalHour - 12;
				finalVariable.amPmTracker = finalVariable.amPmTracker + 2;
			}

			if (finalVariable.amPmTracker % 2 == 1)
			{
				finalVariable.finalAmPm = "AM";
			}
			else
			{
				finalVariable.finalAmPm = "PM";
			}
			return finalVariable;
	}

	static void Answer (int Hour, int Minute, String AmPm)
	{
		if (Minute < 10)
		{
			System.out.println(Hour + ":0" + Minute + " " + AmPm);
		}
		else
		{
			System.out.println(Hour + ":" + Minute + " " + AmPm);
		}
	}
}

class StartInputVariables
{
	int startHour;
	int startMinute;
	String startAmPm;
}

class DelayInputVariables
{
	int delayHour;
	int delayMinute;
}

class FinalTimeVariables
{
	int finalHour;
	int finalMinute;
	String finalAmPm;
	int amPmTracker = 0;
}