import java.io.*;
import java.util.Scanner;
public class Enumerated_Types
{
	public static void main(String[] args)
	{
		Scanner 	keyScanner;
		String insertedLevel;
		String playerName;
		boolean validLevel = false;
		Player player1 = new Player();

		keyScanner = new Scanner(System.in);

		player1.levelOptions();
		System.out.println("Enter Player Name: ");
		playerName = keyScanner.nextLine();
		player1.setName(playerName);

		while (validLevel == false){
			System.out.println("Enter Current Level: ");
			insertedLevel = keyScanner.nextLine().toUpperCase(); //Converts the First Player's level to Upper Case
			try {
				Player.Levels level = Player.Levels.valueOf(insertedLevel); //Converts the String of the inputed level to a Level Type so it can be passed
				player1.setLevel(level); //Sets the First Player's Level
				validLevel = true;
			} catch(IllegalArgumentException ex) {
				System.out.println("That is not a Valid Level, Try Again");
			}
			System.out.println("");
		}

		System.out.println(player1.toArray() + "\n");

		System.out.println(player1.getLevel() + ": ");
		player1.levelInformation(); //Prints the Player information to the Console
		player1.remainingLevels();
		System.out.println("\n" + "\n");

		Player player2 = new Player();

		player2.levelOptions();
		System.out.println("Enter Next Player Name: ");
		playerName = keyScanner.nextLine();
		player2.setName(playerName);
		validLevel = false;

		while (validLevel == false){
			System.out.println("Enter Current Level: ");
			insertedLevel = keyScanner.nextLine().toUpperCase(); //Converts the Second Player's level to Upper Case
			try {
				Player.Levels level2 = Player.Levels.valueOf(insertedLevel); //Converts the String of the inputed level to a Level Type so it can be passed
				player2.setLevel(level2); //Sets the Second Player's Level
				validLevel = true;
			} catch(IllegalArgumentException ex) {
				System.out.println("That is not a Valid Level, Try Again");
			}
			System.out.println("");
		}

		System.out.println(player2.toArray() + "\n");

		System.out.println(player2.getLevel() + ": ");
		player2.levelInformation(); //Prints the Player information to the Console
		player2.remainingLevels();
		System.out.println("\n");


		System.out.println(player1.playerCompare(player2) + "\n"); //Checks to see if the Players are the same Level
	}
}