package comp472.polarizedLadder;

public class Player 
{
	private String name;
	private boolean hasWon = false;
	
	//parametrized constructor
	public Player(String name)
	{
		this.name = name;
	}
	
	//accessor for name
	public String getName()
	{
		return this.name;
	}
	
	//method to keep track of player's owned positions on the board
	public void addPosition(int x, int y)
	{
		
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
