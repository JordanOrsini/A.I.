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

public class Grid 
{
	private ArrayList<Point> availablePoints;
	private ArrayList<Point> basePositions;
	final int GRID_ROWS = 8;
	final int GRID_COLUMNS  = 15;
	private String[][] gameGrid;
	
	//default constructor
	//initializes grid 2d array
	//initializes arrayList of available points
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

		//array containing all points a player can take on the grid
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
		
		//arrayList containing all of the grid's base points
		basePositions = new ArrayList<Point>();
				
		basePositions.add(new Point(1,6));
		basePositions.add(new Point(2,6));
		basePositions.add(new Point(3,6));
		basePositions.add(new Point(4,6));
		basePositions.add(new Point(5,6));
		basePositions.add(new Point(6,6));
		basePositions.add(new Point(7,6));
		basePositions.add(new Point(8,6));
		basePositions.add(new Point(9,6));
		basePositions.add(new Point(10,6));
		basePositions.add(new Point(11,6));
		basePositions.add(new Point(12,6));
		basePositions.add(new Point(13,6));
	}


	//method converts the user inputed string value and converts it to a point representing an index on the 2D
	//array representing the game grid
	public Point convertInput(String desiredPosition)
	{
		int valueX = 0;
		int valueY = 0;
		
		//if string is less than 2 characters in length return an invalid value
		if(desiredPosition.length() < 2)
		{
			valueX = -1;
			valueY = -1;
			return new Point(valueX, valueY);
		}
		//if string is at least 2 characters in length, convert the input to x and y values and return a point
		else
		{
			//switch on first user inputed character to get Y value of point
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
		
			//switch on second character of user input to get X value of point
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
		
			//returns point
			return new Point(valueX, valueY);
		}
	}
	
	public String reverseConvertInput(Point point)
	{
		String output = "";
		
		if(point.x == 1 && point.y == 6)
		{
			output = "1A";
		}	
		else if(point.x == 2 && point.y == 6)
		{
			output = "1B";
		}
		else if(point.x == 3 && point.y == 6)
		{
			output = "1C";
		}
		else if(point.x == 4 && point.y == 6)
		{
			output = "1D";
		}
		else if(point.x == 5 && point.y == 6)
		{
			output = "1E";
		}
		else if(point.x == 6 && point.y == 6)
		{
			output = "1F";
		}
		else if(point.x == 7 && point.y == 6)
		{
			output = "1G";
		}
		else if(point.x == 8 && point.y == 6)
		{
			output = "1H";
		}
		else if(point.x == 9 && point.y == 6)
		{
			output = "1I";
		}
		else if(point.x == 10 && point.y == 6)
		{
			output = "1J";
		}
		else if(point.x == 11 && point.y == 6)
		{
			output = "1K";
		}
		else if(point.x == 12 && point.y == 6)
		{
			output = "1L";
		}
		else if(point.x == 13 && point.y == 6)
		{
			output = "1M";
		}
		else if(point.x == 2 && point.y == 5)
		{
			output = "2B";
		}
		else if(point.x == 3 && point.y == 5)
		{
			output = "2C";
		}
		else if(point.x == 4 && point.y == 5)
		{
			output = "2D";
		}
		else if(point.x == 5 && point.y == 5)
		{
			output = "2E";
		}
		else if(point.x == 6 && point.y == 5)
		{
			output = "2F";
		}
		else if(point.x == 7 && point.y == 5)
		{
			output = "2G";
		}
		else if(point.x == 8 && point.y == 5)
		{
			output = "2H";
		}
		else if(point.x == 9 && point.y == 5)
		{
			output = "2I";
		}
		else if(point.x == 10 && point.y == 5)
		{
			output = "2J";
		}
		else if(point.x == 11 && point.y == 5)
		{
			output = "2K";
		}
		else if(point.x == 12 && point.y == 5)
		{
			output = "2L";
		}
		else if(point.x == 3 && point.y == 4)
		{
			output = "3C";
		}
		else if(point.x == 4 && point.y == 4)
		{
			output = "3D";
		}
		else if(point.x == 5 && point.y == 4)
		{
			output = "3E";
		}
		else if(point.x == 6 && point.y == 4)
		{
			output = "3F";
		}
		else if(point.x == 7 && point.y == 4)
		{
			output = "3G";
		}
		else if(point.x == 8 && point.y == 4)
		{
			output = "3H";
		}
		else if(point.x == 9 && point.y == 4)
		{
			output = "3I";
		}
		else if(point.x == 10 && point.y == 4)
		{
			output = "3J";
		}
		else if(point.x == 11 && point.y == 4)
		{
			output = "3K";
		}
		else if(point.x == 4 && point.y == 3)
		{
			output = "4D";
		}
		else if(point.x == 5 && point.y == 3)
		{
			output = "4E";
		}
		else if(point.x == 6 && point.y == 3)
		{
			output = "4F";
		}
		else if(point.x == 7 && point.y == 3)
		{
			output = "4G";
		}
		else if(point.x == 8 && point.y == 3)
		{
			output = "4H";
		}
		else if(point.x == 9 && point.y == 3)
		{
			output = "4I";
		}
		else if(point.x == 10 && point.y == 3)
		{
			output = "4J";
		}
		else if(point.x == 5 && point.y == 2)
		{
			output = "5E";
		}
		else if(point.x == 6 && point.y == 2)
		{
			output = "5F";
		}
		else if(point.x == 7 && point.y == 2)
		{
			output = "5G";
		}
		else if(point.x == 8 && point.y == 2)
		{
			output = "5H";
		}
		else if(point.x == 9 && point.y == 2)
		{
			output = "5I";
		}
		else if(point.x == 6 && point.y == 1)
		{
			output = "6F";
		}
		else if(point.x == 7 && point.y == 1)
		{
			output = "6G";
		}
		else if(point.x == 8 && point.y == 1)
		{
			output = "6H";
		}
		else if(point.x == 7 && point.y == 0)
		{
			output = "7G";
		}
		
		return output;
	}
	
	//method takes a point and the player's color and modifies the string in the gameGrid's indexes corresponding
	//to the point's coordinates and replaces it with the player's token color
	//will also print the grid
	public void modifyGrid(Point point, String playerToken)
	{
		gameGrid[point.y][point.x] = playerToken;
	//	printGrid();
	}
	
	//prints the current state of the game grid to console
	public void printGrid()
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
	
	//accessor method for availablePoints
	//returns arrayList of points representing all valid positions on the game grid not occupied by any player
	public ArrayList<Point> getAvailablePoints()
	{
		return this.availablePoints;
	}
	
	//accessor method for gameGrid
	//returns 2D array representing the gameGrid
	public String[][] getGameGrid() {
		return gameGrid;
	}
	
	//method takes a point and player color and will add the corresponding position on the grid to the player
	public void setPoint(Point point, String playerToken)
	{
		modifyGrid(point, playerToken);
		availablePoints.remove(point);	
	}
	
	//removes possession of a point. will reset game grid value to default "*" at the given point
	public void resetPoint (int index, Point point)
	{
		modifyGrid(point, "*");
		availablePoints.add(index, point);
		
		//reset if a player wins
		//reset tie game
		//remove position from player
	}
	
	//accessor method for basePositions
	//returns arrayList of points representing the base of the game grid
	public ArrayList<Point> getBasePositions()
	{
		return this.basePositions;
	}
}
