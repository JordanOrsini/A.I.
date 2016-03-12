package comp472.polarizedLadder;

import java.awt.Point;
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
				positionInput = positionScanner.nextLine();
				
				while(!myGrid.getAvailablePositions().contains(positionInput)){
					System.out.println("Invalid input! Please try again: (ex: 5E) ");
					positionInput = positionScanner.nextLine();
				}
						
				Point inputPoint = myGrid.removeAndConvertInput(positionInput, players[i]);
				players[i].addPosition(inputPoint);
				
				WinPattern.checkLadder(inputPoint, players, i, myGrid);
			}
		}
	}
	

}
