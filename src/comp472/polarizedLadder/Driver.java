package comp472.polarizedLadder;

import java.util.Scanner;
public class Driver
{
	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		Scanner userName = new Scanner (System.in);
		Scanner positionScanner = new Scanner (System.in);
		
		String positionInput;
		PlayGame game;
		Player[] players = new Player[2];
		
		int gameMode;
		
		System.out.println("Welcome to our COMP 472 project!");
		System.out.println("--------------------------------");
		System.out.println();
		
		System.out.println("Please select a game mode:");
		System.out.println("1: Human vs. Human");
		System.out.println("2: Human vs. A.I.");
		System.out.println();
		
		System.out.print("Selection: ");
		
		gameMode = kb.nextInt();
		
		//input validation for game mode selection
		while(gameMode != 1 && gameMode != 2)
		{
			System.out.println();
			System.out.print("Invalid game mode selection, please try again: ");
			gameMode = kb.nextInt();
		}
		
		System.out.println();
		
		//switch statement on user input for game mode
		
		switch(gameMode)
		{
			case 1:
			{
				System.out.println("You have selected Human vs. Human!");
				System.out.println();
				players[0] = new HumanPlayer();
				players[1] = new HumanPlayer();
				break;
			}
			case 2:
			{
				System.out.println("You have selected Human vs. A.I.!");
				System.out.println();
				players[0] = new HumanPlayer();
				players[1] = new AIPlayer();
				break;
			}
			default:
			{
				System.out.println("Error in game mode selection!");
				System.out.println();
				break;
			}
		}
		game = new PlayGame(players);
		
		//initializes game grid
		Grid myGrid = new Grid();
		
		//prints grid
		myGrid.printGrid();
		
		//game loop
		while(true)
		{
			for (int i = 0; i< 2; i++)
			{
				players[i].gameOver();
				System.out.println("Player \"" + players[i].getName() + "\",");
				System.out.println("Please input a position to take on the board: (ex: 3D) ");
				positionInput = positionScanner.nextLine();
				
				while(positionInput.length() != 2)
				{
					System.out.println("Invalid input! Please try again: (ex: 5E) ");
					positionInput = positionScanner.nextLine();
				}
				
//				myGrid.convertInput(positionInput, players[i]);
			}
		}
	}
}
