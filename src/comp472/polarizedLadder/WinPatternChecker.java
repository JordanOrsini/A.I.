package comp472.polarizedLadder;

import java.awt.Point;
import java.util.ArrayList;

public interface WinPatternChecker {
	
	Point patterns[][] = 
	{ 			
		//last entered point is taken to be (0,0), is then compared to other rightward staircase points
		{new Point(0,0), new Point(1,0), new Point (1,1), new Point (2,1) , new Point (2,2)},
		
		{new Point(-1,0), new Point(0,0), new Point (0,1), new Point (1,1) , new Point (1,2)},
		{new Point (-1,-1), new Point (0,-1), new Point(0,0), new Point(1,0), new Point (1,1)},
		
		{new Point (-2,-1), new Point (-1,-1), new Point (-1,0), new Point(0,0), new Point(0,1)},
		{new Point (-2,-2), new Point (-1,-2), new Point (-1,-1), new Point(0,-1), new Point(0,0)},
		
		//last entered point is taken to be (0,0), is then compared to other leftward staircase points
		{new Point (2,-2),  new Point (1,-2), new Point (1,-1), new Point(0,-1), new Point(0,0)},
		{new Point (2,-1), new Point (1,-1), new Point (1,0), new Point(0,0), new Point(0,1)},
		
		{new Point (1,-1), new Point (0,-1), new Point(0,0), new Point(-1,0), new Point (-1,1)},
		{new Point(1,0), new Point(0,0), new Point (0,1), new Point (-1,1) , new Point (-1,2)},
		
		{new Point(0,0), new Point(-1,0), new Point (-1,1), new Point (-2,1) , new Point (-2,2)},
	};
	
	public static void checkForLadder(Point currentPosition, Player players[], int playerNumber, Grid grid){
		System.out.println(players[playerNumber].getPlayerPositions());
		for (int i = 0; i < patterns.length; i++){
			ArrayList<Point> winningArray = new ArrayList<Point>();
			for (int j = 0; j < patterns[i].length; j++){
				int x = currentPosition.x + patterns[i][j].x;
				int y = currentPosition.y - patterns[i][j].y;	
				Point check = new Point(x, y);

				if(players[playerNumber].getPlayerPositions().contains(check)){
					winningArray.add(check);
					if(winningArray.size() == 5){
						if(!checkBlocked(winningArray.get(2), i, players, playerNumber, grid)){
							System.out.println("\n\nPlayer "+players[playerNumber].getName()+" WINS!");
							System.exit(0);
						}
					}
				}
			}
		}
	}
	

	public static boolean checkBlocked(Point middlePoint, int winPatternNumber, Player players[], int playerNumber, Grid grid){
		Point blockedRight, blockedLeft;
		if(winPatternNumber < 5){
			blockedRight = new Point(middlePoint.x+1, middlePoint.y+1);
			blockedLeft = new Point(middlePoint.x-1, middlePoint.y-1);
		}
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
}