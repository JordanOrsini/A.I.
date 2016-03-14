/*
 * Jordan Orsini
 * ID: 26471196
 * 
 * Zachary Bergeron
 * ID: 26593925
 * 
 * We certify that this submission is the original work of members of the group and meets the Falculty's Expectations of Originality.
 * March 14th, 2016
 */
package comp472.polarizedLadder;

import java.util.Scanner;
public class Driver{
	
	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		Player[] players = new Player[2];
		
		int gameMode;
		
		System.out.println("Welcome to our COMP 472 project!");
		System.out.println("--------Polarized Ladder--------");
		System.out.println("--------------------------------\n");
		System.out.println("Please select a game mode:");
		System.out.println("1: Human vs. Human");
		System.out.println("2: Human vs. A.I.");
		System.out.println("3: A.I. vs. Human");
		System.out.println("4: Exit\n");
		System.out.print("Selection: ");
		
		gameMode = kb.nextInt();
		
		//input validation for game mode selection
		while(gameMode != 1 && gameMode != 2 && gameMode != 3 && gameMode != 4)
		{
			System.out.print("\nInvalid game mode selection, please try again: ");
			gameMode = kb.nextInt();
		}
		
		System.out.println();
		
		//switch statement on user input for game mode
		switch(gameMode)
		{
			//human vs human game mode
			case 1:
			{
				System.out.println("You have selected Human vs. Human!\n");
				players[0] = new HumanPlayer();
				players[1] = new HumanPlayer();
				break;
			}
			
			//human vs a.i. game mode where human plays first
			case 2:
			{
				System.out.println("You have selected Human vs. A.I.!\n");
				players[0] = new HumanPlayer();
				players[1] = new AIPlayer();
				break;
			}
			
			//a.i. vs human game mode where a.i. plays first
			case 3:
			{
				System.out.println("You have selected A.I. vs. Human!\n");
				players[0] = new AIPlayer();
				players[1] = new HumanPlayer();
				break;
			}
			
			//quits out of java application
			case 4:
			{
				System.out.println("Thanks for playing Polarized Ladder!");
				System.exit(0);
			}
			default:
			{
				System.out.println("Error in game mode selection!\n");
				break;
			}
		}
		new PlayGame(players);
		kb.close();
		
	}
}
