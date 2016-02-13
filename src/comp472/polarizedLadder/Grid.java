package comp472.polarizedLadder;
import java.util.ArrayList;

public class Grid 
{
	private ArrayList<String> availablePositions;
	final int BOARD_ROWS = 8;
	final int BOARD_COLS  = 14;
	private String[][] gameGrid;
	
	//default constructor
	public Grid()
	{

		gameGrid = new String[BOARD_ROWS][BOARD_COLS];
//		
//		for (int i = 0; i < BOARD_ROWS; i++) {
//			
//			for (int j = 0; j < BOARD_COLS; j++) {
//				
//				if ( (j == 0) && (i >= 1) )  {
//					
//					// add y axis legend
//					gameGrid[i][j] = Integer.toString(8-i);
//				
//				}
//			
//			}
//		}
		
		gameGrid[0][0] = "7";
		gameGrid[0][1] = " ";
		gameGrid[0][2] = " ";
		gameGrid[0][3] = " ";
		gameGrid[0][4] = " ";
		gameGrid[0][5] = " ";
		gameGrid[0][6] = " ";
		gameGrid[0][7] = "*";
		gameGrid[0][8] = " ";
		gameGrid[0][9] = " ";
		gameGrid[0][10] = " ";
		gameGrid[0][11] = " ";
		gameGrid[0][12] = " ";
		gameGrid[0][13] = " ";
		
		gameGrid[1][0] = "6";
		gameGrid[1][1] = " ";
		gameGrid[1][2] = " ";
		gameGrid[1][3] = " ";
		gameGrid[1][4] = " ";
		gameGrid[1][5] = " ";
		gameGrid[1][6] = "*";
		gameGrid[1][7] = "*";
		gameGrid[1][8] = "*";
		gameGrid[1][9] = " ";
		gameGrid[1][10] = " ";
		gameGrid[1][11] = " ";
		gameGrid[1][12] = " ";
		gameGrid[1][13] = " ";
		
		gameGrid[2][0] = "5";
		gameGrid[2][1] = " ";
		gameGrid[2][2] = " ";
		gameGrid[2][3] = " ";
		gameGrid[2][4] = " ";
		gameGrid[2][5] = "*";
		gameGrid[2][6] = "*";
		gameGrid[2][7] = "*";
		gameGrid[2][8] = "*";
		gameGrid[2][9] = "*";
		gameGrid[2][10] = " ";
		gameGrid[2][11] = " ";
		gameGrid[2][12] = " ";
		gameGrid[2][13] = " ";
		
		gameGrid[3][0] = "4";
		gameGrid[3][1] = " ";
		gameGrid[3][2] = " ";
		gameGrid[3][3] = " ";
		gameGrid[3][4] = "*";
		gameGrid[3][5] = "*";
		gameGrid[3][6] = "*";
		gameGrid[3][7] = "*";
		gameGrid[3][8] = "*";
		gameGrid[3][9] = "*";
		gameGrid[3][10] = "*";
		gameGrid[3][11] = " ";
		gameGrid[3][12] = " ";
		gameGrid[3][13] = " ";
		
		gameGrid[4][0] = "3";
		gameGrid[4][1] = " ";
		gameGrid[4][2] = " ";
		gameGrid[4][3] = "*";
		gameGrid[4][4] = "*";
		gameGrid[4][5] = "*";
		gameGrid[4][6] = "*";
		gameGrid[4][7] = "*";
		gameGrid[4][8] = "*";
		gameGrid[4][9] = "*";
		gameGrid[4][10] = "*";
		gameGrid[4][11] = "*";
		gameGrid[4][12] = " ";
		gameGrid[4][13] = " ";
		
		gameGrid[5][0] = "2";
		gameGrid[5][1] = " ";
		gameGrid[5][2] = "*";
		gameGrid[5][3] = "*";
		gameGrid[5][4] = "*";
		gameGrid[5][5] = "*";
		gameGrid[5][6] = "*";
		gameGrid[5][7] = "*";
		gameGrid[5][8] = "*";
		gameGrid[5][9] = "*";
		gameGrid[5][10] = "*";
		gameGrid[5][11] = "*";
		gameGrid[5][12] = "*";
		gameGrid[5][13] = " ";
		
		gameGrid[6][0] = "1";
		gameGrid[6][1] = "*";
		gameGrid[6][2] = "*";
		gameGrid[6][3] = "*";
		gameGrid[6][4] = "*";
		gameGrid[6][5] = "*";
		gameGrid[6][6] = "*";
		gameGrid[6][7] = "*";
		gameGrid[6][8] = "*";
		gameGrid[6][9] = "*";
		gameGrid[6][10] = "*";
		gameGrid[6][11] = "*";
		gameGrid[6][12] = "*";
		gameGrid[6][13] = "*";
		
		gameGrid[7][0] = " ";
		gameGrid[7][1] = "A";
		gameGrid[7][2] = "B";
		gameGrid[7][3] = "C";
		gameGrid[7][4] = "D";
		gameGrid[7][5] = "E";
		gameGrid[7][6] = "F";
		gameGrid[7][7] = "G";
		gameGrid[7][8] = "H";
		gameGrid[7][9] = "I";
		gameGrid[7][10] = "J";
		gameGrid[7][11] = "K";
		gameGrid[7][12] = "L";
		gameGrid[7][13] = "M";	
	
		availablePositions = new ArrayList<String>();
		
		availablePositions.add("1A");
		availablePositions.add("2B");
		availablePositions.add("1B");
		availablePositions.add("3C");
		availablePositions.add("2C");
		availablePositions.add("1C");
		availablePositions.add("4D");
		availablePositions.add("3D");
		availablePositions.add("2D");
		availablePositions.add("1D");
		availablePositions.add("5E");
		availablePositions.add("4E");
		availablePositions.add("3E");
		availablePositions.add("2E");
		availablePositions.add("1E");
		availablePositions.add("6F");
		availablePositions.add("5F");
		availablePositions.add("4F");
		availablePositions.add("3F");
		availablePositions.add("2F");
		availablePositions.add("1F");
		availablePositions.add("7G");
		availablePositions.add("6G");
		availablePositions.add("5G");
		availablePositions.add("4G");
		availablePositions.add("3G");
		availablePositions.add("2G");
		availablePositions.add("1G");
		availablePositions.add("6H");
		availablePositions.add("5H");
		availablePositions.add("4H");
		availablePositions.add("3H");
		availablePositions.add("2H");
		availablePositions.add("1H");
		availablePositions.add("5I");
		availablePositions.add("4I");
		availablePositions.add("3I");
		availablePositions.add("2I");
		availablePositions.add("1I");
		availablePositions.add("4J");
		availablePositions.add("3J");
		availablePositions.add("2J");
		availablePositions.add("1J");
		availablePositions.add("3K");
		availablePositions.add("2K");
		availablePositions.add("1K");
		availablePositions.add("2L");
		availablePositions.add("1L");
		availablePositions.add("1M");
	}
	
	void convertInput(String desiredPosition, Player play)
	{
		int valueX = 0;
		int valueY = 0;
		
		availablePositions.remove("desiredPosition");
		play.addPosition(desiredPosition);
		
		switch(desiredPosition.charAt(0))
		{
			case '1':
			{
				valueX = 6;
				break;
			}
			case '2':
			{
				valueX = 5;
				break;
			}
			case '3':
			{
				valueX = 4;
				break;
			}
			case '4':
			{
				valueX = 3;
				break;
			}
			case '5':
			{
				valueX = 2;
				break;
			}
			case '6':
			{
				valueX = 1;
				break;
			}
			case '7':
			{
				valueX = 0;
				break;
			}
		}
		
		switch(desiredPosition.charAt(1))
		{
			case 'A':
			{
				valueY = 1;
				break;
			}
			case 'B':
			{
				valueY = 2;
				break;
			}
			case 'C':
			{
				valueY = 3;
				break;
			}
			case 'D':
			{
				valueY = 4;
				break;
			}
			case 'E':
			{
				valueY = 5;
				break;
			}
			case 'F':
			{
				valueY = 6;
				break;
			}
			case 'G':
			{
				valueY = 7;
				break;
			}
			case 'H':
			{
				valueY = 8;
				break;
			}
			case 'I':
			{
				valueY = 9;
				break;
			}
			case 'J':
			{
				valueY = 10;
				break;
			}
			case 'K':
			{
				valueY = 11;
				break;
			}
			case 'L':
			{
				valueY = 12;
				break;
			}
			case 'M':
			{
				valueY = 13;
				break;
			}
		}
		
		modifyGrid(valueX, valueY, play);
	}
	
	void modifyGrid(int x, int y, Player play)
	{
		if(play.getNumber() == 0)
		{
			gameGrid[x][y] = "\u25CF";
		}
		else
		{
			gameGrid[x][y] = "\u25CB";
		}
		printGrid();
	}
	
	//prints the current state of the game grid to console
	void printGrid()
	{
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<14; j++)
			{
				System.out.print(gameGrid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	ArrayList<String> getAvailablePositions()
	{
		return this.availablePositions;
	}
}
