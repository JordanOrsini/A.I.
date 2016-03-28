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

public class Player {
	
	private ArrayList<Point> playerPositions = new ArrayList<Point>();
	private int number;
	private String name;
	private boolean hasWon = false;
	private String gamePiece;
	private boolean tieGame = false;
	private int lastMoveScore;
	
	//default constructor
	public Player() {
		super();
	}
	
	//parametrized constructor, takes player's name and number
	public Player(String name, int number) {
		super();
	}
	
	//accessor method for playerPositions
	//returns an arrayList of points representing the current player's owned positions on the gameGrid
	public ArrayList<Point> getPlayerPositions() {
		return playerPositions;
	}
	
	//method adds a point to current player's owned positions arrayList
	public void addPosition(Point position)
	{
		playerPositions.add(position);
	}
	
	public void removePosition(Point position)
	{
		playerPositions.remove(position);
	}
	
	//accessor method for number
	//returns number representing the current player
	public int getNumber() {
		return number;
	}
	
	//sets current player's number
	public void setNumber(int number) {
		this.number = number;
	}
	
	//accessor method for current player's name
	public String getName() {
		return name;
	}
	
	//sets current player's name
	public void setName(String name) {
		this.name = name;
	}
	
	//returns true if current player has won
	public boolean getHasWon() {
		return hasWon;
	}
	
	//sets that the current player has won
	public void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}
	
	//returns string representing the colour of the current player
	public String getGamePiece() {
		return gamePiece;
	}
	
	//sets colour of current player's game peice
	public void setGamePiece(String gamePiece) {
		this.gamePiece = gamePiece;
	}
	
	//sets that the game has resulted in a tie
	public void setTieGame(boolean tieGame)
	{
		this.tieGame = tieGame;
	}
	
	//returns true if the game has resulted in a tie (no more places on the game board)
	public boolean getTieGame()
	{
		return tieGame;
	}
	
	public void setLastMoveScore(int score)
	{
		lastMoveScore = score;
	}
	
	public int getLastMoveScore()
	{
		return lastMoveScore;
	}
}
