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
import java.util.ArrayList;

public interface WinPatternChecker {
	
	//represents general patterns that consist of a win
	//these patterns will be added to player's owned positions to check if a winning pattern is present
	//the (0,0) point represents the most current point the player has claimed
	//as such we need a (0,0) in each of the 5 points required for a right ladder win
	//or a left ladder win, resulting in 10 win patterns.
	Point patterns[][] = 
	{ 			
		//(0,0) as first point in right and left ladder respectfully
		{new Point(0,0), new Point(1,0), new Point (1,1), new Point (2,1) , new Point (2,2)}, //0
		{new Point(0,0), new Point(-1,0), new Point (-1,1), new Point (-2,1) , new Point (-2,2)}, //1
		
		//(0,0) as second point in right and left ladder respectfully
		{new Point(-1,0), new Point(0,0), new Point (0,1), new Point (1,1) , new Point (1,2)}, //2
		{new Point(1,0), new Point(0,0), new Point (0,1), new Point (-1,1) , new Point (-1,2)}, //3

		//(0,0) as middle point in right and left ladder respectfully
		{new Point (-1,-1), new Point (0,-1), new Point(0,0), new Point(1,0), new Point (1,1)}, //4
		{new Point (1,-1), new Point (0,-1), new Point(0,0), new Point(-1,0), new Point (-1,1)}, //5
	
		//(0,0) as fourth point in right and left ladder respectfully
		{new Point (-2,-1), new Point (-1,-1), new Point (-1,0), new Point(0,0), new Point(0,1)}, //6
		{new Point (2,-1), new Point (1,-1), new Point (1,0), new Point(0,0), new Point(0,1)}, //7

		//(0,0) as fifth point in right and left ladder respectfully
		{new Point (-2,-2), new Point (-1,-2), new Point (-1,-1), new Point(0,-1), new Point(0,0)}, //8
		{new Point (2,-2),  new Point (1,-2), new Point (1,-1), new Point(0,-1), new Point(0,0)}, //9
		
		//RIGHT LADDER PATTERN INDEXES (0, 2, 4, 6, 8)
		//LEFT LADDER PATTERN INDEXES (1, 3, 5, 7, 9)
		
	};
	
	//method checks for a winning pattern by cross referencing player's owned positions
	//with patterns[][] 2D array. will add values in patterns[][] to player's owned points
	//in order for the win pattern to be detected across the whole gameGrid
	public static void checkForLadder(Point currentPosition, Player players[], int playerNumber, Grid grid)
	{
		
		for (int i = 0; i < patterns.length; i++)
		{
			ArrayList<Point> winningArray = new ArrayList<Point>();
			for (int j = 0; j < patterns[i].length; j++)
			{
				int x = currentPosition.x + patterns[i][j].x;
				int y = currentPosition.y - patterns[i][j].y;	
				Point check = new Point(x, y);

				if(players[playerNumber].getPlayerPositions().contains(check))
				{
					winningArray.add(check);
					if(winningArray.size() == 5)
					{
						//checks to see if a win has occurred by having two points of the ladder touching the base of the grid
						if(polarizedAtBase(winningArray, grid.getBasePositions()))
						{
							//added for minimax
							players[playerNumber].setHasWon(true);
						}
						//makes sure the winning pattern is not blocked by the other player before declaring a winner
						else if(!checkBlocked(winningArray.get(2), i, players, playerNumber, grid))
						{	
							//added for minimax
							players[playerNumber].setHasWon(true);
						}
					}
				}
			}
		}
	}
	
	//method makes sure winning pattern is not blocked by other player by checking points
	//diagonal to the middle point of the winning ladder
	public static boolean checkBlocked(Point middlePoint, int winPatternNumber, Player players[], int playerNumber, Grid grid){
		Point blockedRight, blockedLeft;
		
		//if winning pattern is one of the rightward ladders
		if((winPatternNumber % 2) == 0){
			blockedRight = new Point(middlePoint.x+1, middlePoint.y+1);
			blockedLeft = new Point(middlePoint.x-1, middlePoint.y-1);
		}
		//if the winning pattern is one of the leftward ladders
		else{
			blockedRight = new Point(middlePoint.x+1, middlePoint.y-1);
			blockedLeft = new Point(middlePoint.x-1, middlePoint.y+1);
		}
		String oppositePlayerPiece = players[(playerNumber+1)%2].getGamePiece();
		String left = grid.getGameGrid()[blockedLeft.y][blockedLeft.x];
		String right = grid.getGameGrid()[blockedRight.y][blockedRight.x];
		if(left.equalsIgnoreCase(oppositePlayerPiece) && right.equals(oppositePlayerPiece)){return true;}
		else return false;

	}
	
	//method that checks if the winning ladder is polarized at the base
	//a ladder polarized at the base disregards opponent pieces that may be blocking it
	public static boolean polarizedAtBase(ArrayList<Point> winningArray, ArrayList<Point> basePositions)
	{
		int matches = 0;
		
		//will check how many points in the winning array are base points
		for(int i = 0; i < winningArray.size(); i++)
		{
			//if a position is found to be a base position, increment number of matches
			if (basePositions.contains(winningArray.get(i)))
			{
				matches++;
			}
		}
		
		//if two matches are found (indicating a polarized ladder at the base) a win is awarded to the player
		if(matches == 2)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}