package comp472.polarizedLadder;

import java.util.Scanner;

public class PlayGame {
	
	protected Player p1;
	protected Player p2;
	Scanner kb = new Scanner(System.in);
	Scanner userName = new Scanner (System.in);
	
	public PlayGame(Player[] players) {
		for(int i = 0; i < players.length; i++){
			if(players[i].getClass().equals(HumanPlayer.class))
				humanInfo(players[i], i+1);
			else
				compInfo(players[i], i+1);
		}
		System.out.println("Game start!");
		System.out.println();
	}
	
	private void humanInfo(Player player, int i){
		System.out.print("Please enter name for player " +i+": ");
		player.setName(userName.nextLine());
		System.out.println();
		System.out.println("Human Player "+player.getName()+" created...");
		System.out.println();
	}
	
	private void compInfo(Player player, int i){
		
		player.setName("Computer");
		System.out.println();
		System.out.println("AI Player "+player.getName()+" created...");
		System.out.println();
		
	}
	

}
