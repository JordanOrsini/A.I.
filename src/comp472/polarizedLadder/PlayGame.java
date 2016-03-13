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

	Grid myGrid = new Grid();

	Boolean gameOver = false;

	public PlayGame(Player[] players) {
		this.players = players;

		for(int i = 0; i < players.length; i++){
			infoInitializer(players[i], i);
		}		

		System.out.println("Game start!");
		System.out.println();

		myGrid.printGrid();

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

	private void gameStart(){
		while(!gameOver){
			for (int i = 0; i< 2; i++){
				System.out.println("Player " + players[i].getName() + "'s turn: "+players[i].getGamePiece());
				System.out.println("Please input a position to take on the board: (ex: 3D) ");
				Point inputPoint = myGrid.convertInput(positionScanner.nextLine());
				
				while(!myGrid.getAvailablePoints().contains(inputPoint)){
					System.out.println("Invalid input! Please try again: (ex: 5E) ");
					inputPoint = myGrid.convertInput(positionScanner.nextLine());
				}
				
				myGrid.setPoint(inputPoint, players[i].getGamePiece());
				players[i].addPosition(inputPoint);
				
				WinPattern.checkLadder(inputPoint, players, i, myGrid);
				if(myGrid.getAvailablePoints().size()==0){
					System.out.println("NO MORE AVAILABLE POSITIONS, TIE GAME!");
					System.exit(0);
				}
			}
		}
	}

	public int returnMin(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i) < min) {
				min = list.get(i);
				index = i;
			}
		}
		return list.get(index);
	}

	public int returnMax(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i) > max) {
				max = list.get(i);
				index = i;
			}
		}
		return list.get(index);
	}

	Point computersMove; 
	public int minimax(int depth, String playerToken) {
		String oppositePlayerToken;
		Point inputPoint = myGrid.convertInput(positionInput);
		
//		if (blackWins() return +1;
//		if (whiteWins() return -1;

		List<Point> pointsAvailable = myGrid.getAvailablePoints();
		if (pointsAvailable.isEmpty()) return 0; 

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int i = 0; i < pointsAvailable.size(); ++i) {
			Point point = pointsAvailable.get(i);  
			//Black player returns MAX
			if (playerToken.equals("\u25CF")) {
				oppositePlayerToken = "\u25CB";
				myGrid.setPoint(inputPoint, playerToken);
				int currentScore = minimax(depth + 1, oppositePlayerToken);
				max = Math.max(currentScore, max);

				if(depth == 0){
					System.out.println("Score for position "+(i+1)+" = "+currentScore);
				}
				if(currentScore >= 0){
					if(depth == 0){
						computersMove = point;
					}
				}
				if(currentScore == 1){
					myGrid.resetPoint(inputPoint);
					break;
				} 
				if(i == pointsAvailable.size()-1 && max < 0){
					if(depth == 0){
						computersMove = point;
					}
				}

			//White player returns MIN
			} else if (playerToken.equals("\u25CB")) {
				oppositePlayerToken = "\u25CF";
				myGrid.setPoint(inputPoint, playerToken);
	            int currentScore = minimax(depth + 1, oppositePlayerToken);
	            min = Math.min(currentScore, min); 
	            if(min == -1){myGrid.resetPoint(inputPoint); break;}
	        }
				myGrid.resetPoint(inputPoint);
		}
		return playerToken.equals("\u25CF") ? max : min;
	}
}
