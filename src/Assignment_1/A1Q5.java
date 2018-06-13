/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author abdeo8431
 */
public class A1Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create the city in which the supermarket and home will exist
        City fruitopia = new City();
        
        //create the first robot's home, speedyboi, in an approximate "9" shape
        new Wall(fruitopia, 2, 3, Direction.WEST);
        new Wall(fruitopia, 2, 3, Direction.NORTH);
        new Wall(fruitopia, 2, 3, Direction.EAST);
        new Wall(fruitopia, 3, 3, Direction.EAST);
        new Wall(fruitopia, 3, 3, Direction.SOUTH);
        
        //create the expensive items that have fallen onto the ground at the following coordinates:
        
        //expensive item at (0,0)
        new Thing(fruitopia, 0, 0);
        
        //expensive item at (1,0)
        new Thing(fruitopia, 1, 0);
        
        //expensive item at (1,1)
        new Thing(fruitopia, 1, 1);
        
        //expensive item at (1,2)
        new Thing(fruitopia, 1, 2);
        
        //expensive item at (2,2)
        new Thing(fruitopia, 2, 2);
        
        //create the first robot, speedyboi, in its home at coordinates (3,3)
        RobotSE speedyboi = new RobotSE(fruitopia, 3, 3, Direction.EAST);
        
        //change the colour of speedyboi to green
        speedyboi.setColor(Color.green);
        
        //set the label of speedyboi to "P"
        speedyboi.setLabel("P");
        
        //create the second robot, speedygurl, at coordinates (0,1)
        RobotSE speedygurl = new RobotSE(fruitopia, 0, 1, Direction.WEST);
        
        //change the colour of tinker bell to pink
        speedygurl.setColor(Color.pink);
        
        //set the label of speedygurl to "T"
        speedygurl.setLabel("T");
        
        //make speedyboi do a full 180 degree spin 
        speedyboi.turnAround();
        
        //move speedygurl one space to the west
        speedygurl.move();
        
        //move speedyboi one space to the west
        speedyboi.move();
        
        //turn speedyboi to the right
        speedyboi.turnRight();
        
        //move speedyboi one space to the north
        speedyboi.move();
        
        //make speedygurl pick up the expensive item at (0,0)
        speedygurl.pickThing();
        
        //make speedyboi pick up the expensive item at (2,2)
        speedyboi.pickThing();
        
        //turn speedygurl to the left
        speedygurl.turnLeft();
        
        //move speedygurl one space to the south
        speedygurl.move();
        
        //move speedyboi one space to the north
        speedyboi.move();
        
        //make speedyboi pick up the expensive item at (1,2)
        speedyboi.pickThing();
        
        //make speedygurl pick up the expensive item at (1,0)
        speedygurl.pickThing();
        
        //turn speedygurl to the left
        speedygurl.turnLeft();
        
        //turn speedyboi to the left
        speedyboi.turnLeft();
        
        //move speedygurl one space to the east
        speedygurl.move();
        
        //make speedygurl pick up the thing at (1,1)
        speedygurl.pickThing();
        
        //move speedyboi one space to the west
        speedyboi.move();
        
        
        
        
        
        

        
        
    }
}