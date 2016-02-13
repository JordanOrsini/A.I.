package comp472.polarizedLadder;
import java.awt.Point;
import java.util.ArrayList;

public class Player {
	
	private ArrayList<Point> playerPositions = new ArrayList<Point>();
	private int number;
	private String name;
	private boolean hasWon = false;
	private String gamePiece;
	
	public Player() {
		super();
	}
	
	public Player(String name, int number) {
		super();
	}
	public ArrayList<Point> getPlayerPositions() {
		return playerPositions;
	}
	public void addPosition(Point position)
	{
		playerPositions.add(position);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHasWon() {
		return hasWon;
	}
	public void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}
	public String getGamePiece() {
		return gamePiece;
	}
	public void setGamePiece(String gamePiece) {
		this.gamePiece = gamePiece;
	}
	
	

	

}
