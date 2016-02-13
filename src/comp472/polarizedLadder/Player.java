package comp472.polarizedLadder;
import java.util.ArrayList;

public class Player {
	
	private ArrayList<String> playerPositions = new ArrayList<String>();
	private int number;
	private String name;
	private boolean hasWon = false;
	
	//empty constructor
	public Player()
	{
	}
	
	//parametrized constructor
	public Player(String name, int number)
	{
		this.number = number;
		this.name = name;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}

	//accessor for name
	public String getName()
	{
		return this.name;
	}
	
	//accessor for player's number
	public int getNumber()
	{
		return this.number;
	}
	
	//method to keep track of player's owned positions on the board
	public void addPosition(String position)
	{
		playerPositions.add(position);
	}
	
	//checks if player has won
	public void gameOver()
	{
		if(this.hasWon == true)
		{
			System.out.println("Game Over!");
			System.out.println("Player \"" + this.name + "\" has won!");
		}
	}
	

}
