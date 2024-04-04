//Name: Shane Reall
//Program: It reads data from a file containing student information, compares the rank of each student to a user input rank, and performs various calculations on the student's grades, including calculating the grade average and standard deviation.
//Year: 2022-2023 Freshman
//Software: Textpad

import java.io.*;
import java.util.Scanner;
public class StudentCalc
{
	public static void main(String[] args) throws Exception
	{
		Scanner fileScanner;
		Scanner keyScanner;

		int numGrades;
		String fileName;
		int rankCompare;
		int numberedTracking;

		Student student;

		keyScanner = new Scanner(System.in);

		System.out.print("Enter the File Name: ");
		fileName = keyScanner.nextLine();

		fileScanner = new Scanner(new File(fileName));
		numGrades = fileScanner.nextInt();

		fileScanner.nextLine();

		System.out.println("Enter a Student Rank: ");
		rankCompare = keyScanner.nextInt();

		numberedTracking = 1;
		while (fileScanner.hasNextLine())
		{
			student = readRecord (fileScanner, numGrades, rankCompare);
			compareRecord (rankCompare, student.name, student.rank, student.gradeArray, numGrades);
			if (rankCompare == student.rank)
			{
				System.out.print(numberedTracking + ".) ");
				numberedTracking++;
				System.out.print(student.name);
				gradeAverage (rankCompare, student.name, student.rank, student.gradeArray, numGrades);
				gradeDeviation (rankCompare, student.name, student.rank, student.gradeArray, numGrades);
			}
		}
	}

	static Student readRecord (Scanner fileScanner, int numGrades, int rankCompare) throws Exception //Reads the Record and Gives Values to Name, Rank, and fills in the Array gradeArray
	{
		Scanner strScanner;
		String record;
		Student student;
		student = new Student();
		student.gradeArray = new int[numGrades];
		record = fileScanner.nextLine();

		student.name = record.substring(0,25);
		strScanner = new Scanner (record.substring(26));
		student.rank = strScanner.nextInt();

		for (int n=0; n < numGrades; n++)
		{
			student.gradeArray[n] = strScanner.nextInt();
		}

		return student;
	}

	static Student compareRecord (int rankCompare, String studentName, int studentRank, int[] studentGradeArray, int numGrades) throws Exception //Takes the Rank found in readRecord and Comapres it to a user Input from Main
	{
		Student student;
		student = new Student();

		student.name = studentName;
		student.rank = studentRank;
		student.gradeArray = new int[numGrades];

		for (int n=0; n < numGrades; n++)
		{
			student.gradeArray[n] = studentGradeArray[n];
		}

		return student;
	}

	static Student gradeAverage (int rankCompare, String studentName, int studentRank, int[] studentGradeArray, int numGrades) throws Exception  //Drops the Lowest Grade (Sort Array from Most to Least, then Remove the Last Item) then Finds the Grade Average
	{
		Student student;
		student = new Student();

		int lowest;
		int arrayPlaceHolder;
		student.name = studentName;
		student.rank = studentRank;
		student.gradeArray = new int[numGrades];
		int average;

		for (int n=0; n < numGrades; n++)
		{
			student.gradeArray[n] = studentGradeArray[n];
		}

		lowest = 101;
		arrayPlaceHolder = 0;
		for (int t=0; t < numGrades; t++)
		{
			if (student.gradeArray[t] < lowest)
			{
				lowest = student.gradeArray[t];
				arrayPlaceHolder = t;
			}
		}

		student.gradeArray[arrayPlaceHolder] = 0;

		average = 0;
		for (int i=0; i < numGrades; i++)
		{
			average = student.gradeArray[i] + average;
		}
		average = average / (numGrades - 1);

		System.out.print(average + "     ");

		return student;
	}

	static Student gradeDeviation (int rankCompare, String studentName, int studentRank, int[] studentGradeArray, int numGrades) throws Exception  //Takes grades for gradeArray and then does Math with them to find Standard Deviation
	{
		Student student;
		student = new Student();

		int average;
		int[] numbersToAverage;
		int valueHolding;
		student.name = studentName;
		student.rank = studentRank;
		student.gradeArray = new int[numGrades];

		for (int n=0; n < numGrades; n++)
		{
			student.gradeArray[n] = studentGradeArray[n];
		}

		average = 0;
		for (int t=0; t < numGrades; t++)
		{
			average = student.gradeArray[t] + average;
		}
		average = average / (numGrades);

		numbersToAverage = new int[numGrades];
		for (int i=0; i < numGrades; i++)
		{
			valueHolding = student.gradeArray[i] - average;
			valueHolding = valueHolding * valueHolding;
			numbersToAverage[i] = valueHolding;
		}

		average = 0;
		for (int t=0; t < numGrades; t++)
		{
			average = numbersToAverage[t] + average;
		}
		average = average / (numGrades);

		System.out.printf("%2.5s",Math.sqrt(average));
		System.out.println();

		return student;
	}
}

class Student
{
	int[] gradeArray;
	int rank;
	String name;
}