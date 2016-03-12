package comp472.polarizedLadder;

import java.awt.Point;
import java.util.ArrayList;

public interface WinPattern {
	
	Point winPatterns[][] = { 			
		{new Point(0,0), new Point(1,0), new Point (1,1), new Point (2,1) , new Point (2,2)},
		{new Point(-1,0), new Point(0,0), new Point (0,1), new Point (1,1) , new Point (1,2)},
		{new Point (-1,-1), new Point (0,-1), new Point(0,0), new Point(1,0), new Point (1,1)},
		{new Point (-2,-1), new Point (-1,-1), new Point (-1,0), new Point(0,0), new Point(0,1)},
		{new Point (-2,-2), new Point (-1,-2), new Point (-1,-1), new Point(0,-1), new Point(0,0)},
		{new Point(0,0), new Point(-1,0), new Point (-1,1), new Point (-2,1) , new Point (-2,2)},
		{new Point(1,0), new Point(0,0), new Point (0,1), new Point (-1,1) , new Point (-1,2)},
		{new Point (1,-1), new Point (0,-1), new Point(0,0), new Point(-1,0), new Point (-1,1)},
		{new Point (2,-1), new Point (1,-1), new Point (1,0), new Point(0,0), new Point(0,1)},
		{new Point (2,-2),  new Point (1,-2), new Point (1,-1), new Point(0,-1), new Point(0,0)},
	};
	
	public static void checkLadder(Point currentPosition, Player player){
		System.out.println(player.getPlayerPositions());
		for (int i = 0; i < winPatterns.length; i++){
			int ladderPoints = 0;
			for (int j = 0; j < winPatterns[i].length; j++){
				int x = currentPosition.x - winPatterns[i][j].x;
				int y = currentPosition.y + winPatterns[i][j].y;	
				Point check = new Point(x, y);

				
				if(player.getPlayerPositions().contains(check)){
					ladderPoints += ladderPoints;
					if(ladderPoints == 5){
						System.out.println(player.getName()+" WINS");
						System.exit(0);
					}
				}
			}
		}
	}
//	public static void checkLadderNew(Player player){
//		System.out.println(player.getPlayerPositions());
//		ArrayList<Point> ownedPositions = player.getPlayerPositions();
//		for (int i = 0; i < winPatterns.length; i++){
//			int ladderPoints = 0;
//			for (int j = 0; j < winPatterns[i].length; j++){
//				int positionNumber = ownedPositions.size();
//				int x = ownedPositions.get().x + winPatterns[i][j].x;
//				int y = ownedPositions.get().y + winPatterns[i][j].y;
//				Point check = new Point(x, y);
//				
//				if(player.getPlayerPositions().contains(check)){
//					ladderPoints += 1;
//					if(ladderPoints == 5){
//						System.out.println(player.getName()+" WINS");
//						System.exit(0);
//					}
//				}
//			}
//		}
//	}

}
