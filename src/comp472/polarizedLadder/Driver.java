package comp472.polarizedLadder;

import java.util.Scanner;
public class Driver{
	
	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		Player[] players = new Player[2];
		
		int gameMode;
		
		System.out.println("Welcome to our COMP 472 project!");
		System.out.println("--------------------------------\n");
		System.out.println("Please select a game mode:");
		System.out.println("1: Human vs. Human");
		System.out.println("2: Human vs. A.I.\n");
		System.out.print("Selection: ");
		
		gameMode = kb.nextInt();
		
		//input validation for game mode selection
		while(gameMode != 1 && gameMode != 2)
		{
			System.out.print("\nInvalid game mode selection, please try again: ");
			gameMode = kb.nextInt();
		}
		
		System.out.println();
		
		//switch statement on user input for game mode
		switch(gameMode)
		{
			case 1:
			{
				System.out.println("You have selected Human vs. Human!\n");
				players[0] = new HumanPlayer();
				players[1] = new HumanPlayer();
				break;
			}
			case 2:
			{
				System.out.println("You have selected Human vs. A.I.!\n");
				players[0] = new HumanPlayer();
				players[1] = new AIPlayer();
				break;
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
