package comp472.polarizedLadder;

import java.awt.Point;
import java.util.ArrayList;

public interface WinPatternChecker {
	
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
							System.out.println("\n\nPlayer \""+players[playerNumber].getName()+"\" WINS!");
							System.exit(0);
						}
					}
				}
			}
		}
	}
	

	public static boolean checkBlocked(Point middlePoint, int winPatternNumber, Player players[], int playerNumber, Grid grid){
		Point blockedRight, blockedLeft;
		if((winPatternNumber % 2) == 0){
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