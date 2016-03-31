/*
 * Jordan Orsini
 * ID: 26471196
 * 
 * Zachary Bergeron
 * ID: 26593925
 * 
 */
package comp472.polarizedLadder;

import java.awt.Point;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class PlayGame {

	protected Player p1;
	protected Player p2;

	Scanner kb = new Scanner(System.in);
	Scanner userName = new Scanner (System.in);
	Scanner positionScanner = new Scanner (System.in);

	String[] gamePieces = {"\u25CF","\u25CB"};
	
	String choice;

	String positionInput;

	Player[] players;

	Grid gameGrid = new Grid();

	public PlayGame(Player[] players) {
		this.players = players;

		for(int i = 0; i < players.length; i++){
			infoInitializer(players[i], i);
		}		

		System.out.println("Game start!");
		System.out.println();

		gameGrid.printGrid();

		gameStart();
	}

	private void infoInitializer(Player player, int i){
		if(player.getClass().equals(HumanPlayer.class)){
			System.out.print("Please enter name for player " + (i+1) +": ");
			player.setName(userName.nextLine());
		}
		else{
			player.setName("AI");
		}
		player.setNumber(i);
		player.setGamePiece(gamePieces[i]);
		System.out.println("\nPlayer "+player.getName()+" created: "+player.getGamePiece()+"\n");
	}

	List<PointScore> rootScores;
	
	private void gameStart()
	{
		//game loop
		while(true)
		{
			//alternates between player's contained in players[] array
			//will as current player to input a position he would like to claim
			for (int i = 0; i< 2; i++)
			{
				System.out.println("Player " + players[i].getName() + "'s turn: "+players[i].getGamePiece());
					
				//depending on if the player is a human or ai
				if (players[i].getClass().equals(HumanPlayer.class))
				{
					System.out.println("Please input a position to take on the board: (ex: 3D) ");
				
					positionInput = positionScanner.nextLine();
					Point inputPoint = gameGrid.convertInput(positionInput);
				
					//makes sure the position entered by current player is contained in the availablePoints array
					//if the input was invalid will ask the user for another input
					while(!gameGrid.getAvailablePoints().contains(inputPoint))
					{
						System.out.println("Invalid input! Please try again: (ex: 5E) ");
						positionInput = positionScanner.nextLine();
						inputPoint = gameGrid.convertInput(positionInput);
					}
				
					//if the point is valid. modify the grid with the player's colour
					//and the positions point value to player's owned positions array
					gameGrid.setPoint(inputPoint, players[i].getGamePiece());
					players[i].addPosition(inputPoint);
					
					gameGrid.printGrid();
				
					//checks if player has won after successful modification of grid
					WinPatternChecker.checkForLadder(inputPoint, players, i, gameGrid);
				}
				//this means we are an ai player and calls to minimax should go here
				else
				{
					rootScores = new ArrayList<>();
					
					minimax(0, i);
					
					players[0].setHasWon(false);
					players[0].setTieGame(false);
					players[1].setHasWon(false);
					players[1].setTieGame(false);
					
					for(PointScore pas : rootScores)
					{
						System.out.println("Points: " + pas.point + " Score: " + pas.score);
					}
					
					if(i == 0)
					{
						choice = "maximum";
					}
					else
					{
						choice = "minimum";
					}
					
					Point oppositePlayerMove = getComputerMove(choice);
					
					System.out.println("\nA.I. move: " + oppositePlayerMove);
					System.out.println("A.I. move: " + gameGrid.reverseConvertInput(oppositePlayerMove) + "\n");
					
					gameGrid.setPoint(oppositePlayerMove, players[i].getGamePiece());
					players[i].addPosition(oppositePlayerMove);
					
					gameGrid.printGrid();
					
					WinPatternChecker.checkForLadder(oppositePlayerMove, players, i, gameGrid);
				}
				
				//if there are no more available positions to take and no one has won yet, declare the game a tie game
				if(gameGrid.getAvailablePoints().size()==0)
				{
					//sets in order for game to end
					players[i].setTieGame(true);
				}
				//will check to see if the player's move has resulted in a win or a tie game
				if (players[i].getHasWon() == true)
				{
					System.out.print("Player \""+players[i].getName()+"\" WINS!");
					System.exit(0);
				}
				else if (players[i].getTieGame() == true)
				{
					System.out.print("NO MORE AVAILABLE POSITIONS, TIE GAME!");
					System.exit(0);
				}
			}
		}
	}
	
	int myScore = 0;
	ArrayList<Integer> scores = new ArrayList<>();
	int maxDepth = 3;
	
	private int minimax(int depth, int playerNumber)
	{	
		ArrayList<Point> availablePlaces = gameGrid.getAvailablePoints();
		
		if(availablePlaces.isEmpty() == true)
		{
			return 0;
		}
		
		for(int i = 0; i < availablePlaces.size(); ++i)
		{
			Point point = availablePlaces.get(i);
		
			if(playerNumber == 0)
			{
				gameGrid.setPoint(point, players[0].getGamePiece());
				players[0].addPosition(point);
				WinPatternChecker.checkForLadder(point, players, 0, gameGrid);
				
				if(depth == 0)
				{	
					if(players[0].getLastMoveScore() == 5)
					{
						myScore = myScore + 10000000;
						rootScores.add(new PointScore(myScore, point));
						return 0;
					}
					else
					{
						players[1].addPosition(point);
						WinPatternChecker.checkForLadder(point, players, 1, gameGrid);
						
						if (players[1].getLastMoveScore() == 5)
						{
							myScore = myScore + 1000000;
							rootScores.add(new PointScore(myScore, point));
							return 0;
						}
						else
						{
							players[1].removePosition(point);
						}
					}
				}
				
				if(players[0].getLastMoveScore() == 5)
				{
					myScore = myScore + 65536;
				}
				else if(players[0].getLastMoveScore() == 4)
				{
					myScore = myScore + 256;
				}
				else if(players[0].getLastMoveScore() == 3)
				{
					myScore = myScore + 16;
				}
				else if(players[0].getLastMoveScore() == 2)
				{
					myScore = myScore + 4;
				}
				else if(players[0].getLastMoveScore() == 1)
				{
					myScore = myScore + 2;
				}
				
				if (depth == maxDepth)
				{
					gameGrid.resetPoint(i, point);
					players[0].removePosition(point);
					players[1].removePosition(point);		
					return 0;
				}
				
				minimax(depth + 1, 1);
				
				if(depth == 0)
				{
					rootScores.add(new PointScore(myScore, point));
					myScore = 0;
				}
				
			}
			else if(playerNumber == 1)
			{	
				gameGrid.setPoint(point, players[1].getGamePiece());
				players[1].addPosition(point);
				WinPatternChecker.checkForLadder(point, players, 1, gameGrid);
				
				if(depth == 0)
				{	
					if(players[1].getLastMoveScore() == 5)
					{
						myScore = myScore - 10000000;
						rootScores.add(new PointScore(myScore, point));
						return 0;
					}
					else
					{
						players[0].addPosition(point);
						WinPatternChecker.checkForLadder(point, players, 0, gameGrid);
						
						if (players[0].getLastMoveScore() == 5)
						{
							myScore = myScore - 1000000;
							rootScores.add(new PointScore(myScore, point));
							return 0;
						}
						else
						{
							players[0].removePosition(point);
						}
					}
				}
				
				if(players[1].getLastMoveScore() == 5)
				{
					myScore = myScore - 65536;
				}
				else if(players[1].getLastMoveScore() == 4)
				{
					myScore = myScore - 256;
				}
				else if(players[1].getLastMoveScore() == 3)
				{
					myScore = myScore - 16;
				}
				else if(players[1].getLastMoveScore() == 2)
				{
					myScore = myScore - 4;
				}
				else if(players[1].getLastMoveScore() == 1)
				{
					myScore = myScore - 2;
				}
				
				if (depth == maxDepth)
				{
					gameGrid.resetPoint(i, point);
					players[0].removePosition(point);
					players[1].removePosition(point);		
					return 0;
				}
				
				minimax(depth + 1, 0);
				
				if(depth == 0)
				{
					rootScores.add(new PointScore(myScore, point));
					myScore = 0;
				}
			}
			
			gameGrid.resetPoint(i, point);
			players[0].removePosition(point);
			players[1].removePosition(point);		
		}
		
		return 0;
	}
	
	public Point getComputerMove(String choice) 
	{
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int selectedMove = -1;
        
        if(choice.equals("maximum"))
        {	
        	for (int i = 0; i < rootScores.size(); ++i) 
        	{ 
        		if (maximum < rootScores.get(i).score)
        		{
        			maximum = rootScores.get(i).score;
        			selectedMove = i;
        		}
        	}
        }
        else
        {
        	for (int j = 0; j < rootScores.size(); ++j)
        	{
        		if(minimum > rootScores.get(j).score)
        		{
        			minimum = rootScores.get(j).score;
        			selectedMove = j;
        		}
        	}
        }

        return rootScores.get(selectedMove).point;
    }
}
	