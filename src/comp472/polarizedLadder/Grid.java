package comp472.polarizedLadder;
import java.awt.Point;
import java.util.ArrayList;

public class Grid 
{
	private ArrayList<Point> availablePoints;
	final int GRID_ROWS = 8;
	final int GRID_COLUMNS  = 15;
	private String[][] gameGrid;
	
	//default constructor
	public Grid()
	{
		gameGrid = new String[GRID_ROWS][GRID_COLUMNS];
		
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
		gameGrid[0][14] = "7";
		
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
		gameGrid[1][14] = "6";
		
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
		gameGrid[2][14] = "5";

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
		gameGrid[3][14] = "4";

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
		gameGrid[4][14] = "3";

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
		gameGrid[5][14] = "2";

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
		gameGrid[6][14] = "1";

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
		gameGrid[7][14] = " ";

	
		availablePoints = new ArrayList<Point>();
		
		availablePoints.add(new Point(1,6));
		availablePoints.add(new Point(2,5));
		availablePoints.add(new Point(2,6));
		availablePoints.add(new Point(3,4));
		availablePoints.add(new Point(3,5));
		availablePoints.add(new Point(3,6));
		availablePoints.add(new Point(4,3));
		availablePoints.add(new Point(4,4));
		availablePoints.add(new Point(4,5));
		availablePoints.add(new Point(4,6));
		availablePoints.add(new Point(5,2));
		availablePoints.add(new Point(5,3));
		availablePoints.add(new Point(5,4));
		availablePoints.add(new Point(5,5));
		availablePoints.add(new Point(5,6));
		availablePoints.add(new Point(6,1));
		availablePoints.add(new Point(6,2));
		availablePoints.add(new Point(6,3));
		availablePoints.add(new Point(6,4));
		availablePoints.add(new Point(6,5));
		availablePoints.add(new Point(6,6));
		availablePoints.add(new Point(7,0));
		availablePoints.add(new Point(7,1));
		availablePoints.add(new Point(7,2));
		availablePoints.add(new Point(7,3));
		availablePoints.add(new Point(7,4));
		availablePoints.add(new Point(7,5));
		availablePoints.add(new Point(7,6));
		availablePoints.add(new Point(8,1));
		availablePoints.add(new Point(8,2));
		availablePoints.add(new Point(8,3));
		availablePoints.add(new Point(8,4));
		availablePoints.add(new Point(8,5));
		availablePoints.add(new Point(8,6));
		availablePoints.add(new Point(9,2));
		availablePoints.add(new Point(9,3));
		availablePoints.add(new Point(9,4));
		availablePoints.add(new Point(9,5));
		availablePoints.add(new Point(9,6));
		availablePoints.add(new Point(10,3));
		availablePoints.add(new Point(10,4));
		availablePoints.add(new Point(10,5));
		availablePoints.add(new Point(10,6));
		availablePoints.add(new Point(11,4));
		availablePoints.add(new Point(11,5));
		availablePoints.add(new Point(11,6));
		availablePoints.add(new Point(12,5));
		availablePoints.add(new Point(12,6));
		availablePoints.add(new Point(13,6));
	}


	public Point convertInput(String desiredPosition)
	{
		int valueX = 0;
		int valueY = 0;
		
		//availablePositions.remove(desiredPosition);
		
		switch(desiredPosition.charAt(0))
		{
			case '1':
			{
				valueY = 6;
				break;
			}
			case '2':
			{
				valueY = 5;
				break;
			}
			case '3':
			{
				valueY = 4;
				break;
			}
			case '4':
			{
				valueY = 3;
				break;
			}
			case '5':
			{
				valueY = 2;
				break;
			}
			case '6':
			{
				valueY = 1;
				break;
			}
			case '7':
			{
				valueY = 0;
				break;
			}
		}
		
		switch(desiredPosition.charAt(1))
		{
			case 'A':
			{
				valueX = 1;
				break;
			}
			case 'B':
			{
				valueX = 2;
				break;
			}
			case 'C':
			{
				valueX = 3;
				break;
			}
			case 'D':
			{
				valueX = 4;
				break;
			}
			case 'E':
			{
				valueX = 5;
				break;
			}
			case 'F':
			{
				valueX = 6;
				break;
			}
			case 'G':
			{
				valueX = 7;
				break;
			}
			case 'H':
			{
				valueX = 8;
				break;
			}
			case 'I':
			{
				valueX = 9;
				break;
			}
			case 'J':
			{
				valueX = 10;
				break;
			}
			case 'K':
			{
				valueX = 11;
				break;
			}
			case 'L':
			{
				valueX = 12;
				break;
			}
			case 'M':
			{
				valueX = 13;
				break;
			}
		}
		 
		return new Point(valueX, valueY);
	}
	
	void modifyGrid(Point point, String playerToken)
	{
		gameGrid[point.y][point.x] = playerToken;
		printGrid();
	}
	
	//prints the current state of the game grid to console
	void printGrid()
	{
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<15; j++)
			{
				System.out.print(gameGrid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public ArrayList<Point> getAvailablePoints()
	{
		return this.availablePoints;
	}
	
	public String[][] getGameGrid() {
		return gameGrid;
	}
	
	public void setPoint(Point point, String playerToken)
	{
		modifyGrid(point, playerToken);
		availablePoints.remove(point);	
	}
	
	public void resetPoint (Point point)
	{
		modifyGrid(point, "*");
		availablePoints.add(point);
	}
}
