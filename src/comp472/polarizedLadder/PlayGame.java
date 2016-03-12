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
		
		infoInitializer();
		
		System.out.println("Game start!");
		System.out.println();
		
		myGrid.printGrid();
		
		gameStart();
	}
	
	private void infoInitializer(){
		for(int i = 0; i < players.length; i++){
			if(players[i].getClass().equals(HumanPlayer.class))
				humanInfo(players[i], i);
			else
				compInfo(players[i], i);
			
			players[i].setGamePiece(gamePieces[i]);
		}
	}
	
	private void humanInfo(Player player, int i){
		System.out.print("Please enter name for player " + (i+1) +": ");
		player.setName(userName.nextLine());
		player.setNumber(i);
		if(i==0){player.setGamePiece("\u25CF");}
		else if(i==1){player.setGamePiece("\u25CB");}
		
		System.out.println("\nHuman Player "+player.getName()+" created: "+player.getGamePiece()+"\n");
	}
	
	private void compInfo(Player player, int i){
		
		player.setName("AI");
		player.setNumber(i);
		System.out.println("\nAI Player created...\n");
	}
	
	private void gameStart(){
		while(!gameOver){
			for (int i = 0; i< 2; i++){
				System.out.println("Player \"" + players[i].getName() + "\",");
				System.out.println("Please input a position to take on the board: (ex: 3D) ");
				positionInput = positionScanner.nextLine();
				
				while(!myGrid.getAvailablePositions().contains(positionInput)){
					System.out.println("Invalid input! Please try again: (ex: 5E) ");
					positionInput = positionScanner.nextLine();
				}
						
				Point inputPoint = myGrid.convertInput(positionInput, players[i]);
				players[i].addPosition(inputPoint);
				
				WinPattern.checkLadder(inputPoint, players[i]);
			}
		}
	}
	

}
