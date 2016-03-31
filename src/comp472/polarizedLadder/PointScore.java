package comp472.polarizedLadder;

import java.awt.Point;

public class PointScore 
{
    Point point;
    int score;
    
    //parametrized constructor, takes an integer representing the score and a point representing a position on the grid as inputs
    PointScore (int score, Point point)
    {
    	this.point = point;
        this.score = score;
    }
}
