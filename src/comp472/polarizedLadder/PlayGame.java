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

public class PlayGame {

	protected Player p1;
	protected Player p2;

	Scanner kb = new Scanner(System.in);
	Scanner userName = new Scanner (System.in);
	Scanner positionScanner = new Scanner (System.in);

	String[] gamePieces = {"\u25CF","\u25CB"};

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
				
					//checks if player has won after successful modification of grid
					WinPatternChecker.checkForLadder(inputPoint, players, i, gameGrid);
				}
				//this means we are an ai player and calls to minimax should go here
				else
				{
					minimax(0,players[i].getGamePiece());
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

	Point oppositePlayerMove; 
	
	//minimax function for A.I. will always return best possible move
	
	//minimax pseudocode from wikipedia
	/*function minimax(node, depth, maximizingPlayer)
	02     if depth = 0 or node is a terminal node
	03         return the heuristic value of node

	04     if maximizingPlayer
	05         bestValue := −∞
	06         for each child of node
	07             v := minimax(child, depth − 1, FALSE)
	08             bestValue := max(bestValue, v)
	09         return bestValue

	10     else    (* minimizing player *)
	11         bestValue := +∞
	12         for each child of node
	13             v := minimax(child, depth − 1, TRUE)
	14             bestValue := min(bestValue, v)
	15         return bestValue
	*/
	
	public int minimax(int depth, String playerToken) 
	{
		String oppositePlayerToken;
		Point inputPoint = gameGrid.convertInput(positionInput);
		
		//black player is max
		if (blackWins()) 
		{
			return +1;
		}
		
		//white player is min
		if (whiteWins()) 
		{
			return -1;
		}
		
		List<Point> pointsAvailable = gameGrid.getAvailablePoints();
		if (pointsAvailable.isEmpty()) 
		{
			return 0; 
		}

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int i = 0; i < pointsAvailable.size(); ++i)
		{
			Point point = pointsAvailable.get(i);  
			
			//Black player returns MAX
			if (playerToken.equals("\u25CF")) 
			{
				oppositePlayerToken = "\u25CB";
				gameGrid.setPoint(inputPoint, playerToken);
				int result = minimax(depth + 1, oppositePlayerToken);
				max = Math.max(result, max);

				if(depth == 0)
				{
					System.out.println("Score for position "+(i+1)+" = "+result);
				}
				if(result >= 0)
				{
					if(depth == 0)
					{
						oppositePlayerMove = point;
					}
				}
				if(result == 1)
				{
					gameGrid.resetPoint(inputPoint);
					break;
				} 
				if(i == pointsAvailable.size()-1 && max < 0)
				{
					if(depth == 0)
					{
						oppositePlayerMove = point;
					}
				}		
			} 
			//White player returns MIN
			else if (playerToken.equals("\u25CB"))
			{
				oppositePlayerToken = "\u25CF";
				gameGrid.setPoint(inputPoint, playerToken);
	            int currentScore = minimax(depth + 1, oppositePlayerToken);
	            min = Math.min(currentScore, min); 
	            if(min == -1){gameGrid.resetPoint(inputPoint); break;}
	        }
				gameGrid.resetPoint(inputPoint);
		}
		
		return playerToken.equals("\u25CF") ? max : min;
	}
	
	//checks to see if black player will win in the future for minimax function
	public boolean blackWins()
	{
		boolean blackHasWon = false;
		
		if (players[0].getHasWon() == true)
		{
			blackHasWon = true;
		}
		
		return blackHasWon;
	}
	
	//checks to see if white player will win in the future for minimax function
	public boolean whiteWins()
	{
		boolean whiteHasWon = false;
		
		if(players[1].getHasWon() == true)
		{
			whiteHasWon = true;
		}
		
		return whiteHasWon;
	}
}
