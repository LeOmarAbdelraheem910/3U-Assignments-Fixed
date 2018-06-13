/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author abdeo8431
 */
public class A1Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create the city, fruitopia, to begin the program area
        City fruitopia = new City();
        
        //create eight walls in a two by two space for the robot to encircle
        new Wall(fruitopia, 1, 1, Direction.NORTH);
        new Wall(fruitopia, 1, 2, Direction.NORTH);
        new Wall(fruitopia, 1, 2, Direction.EAST);
        new Wall(fruitopia, 2, 2, Direction.EAST);
        new Wall(fruitopia, 2, 2, Direction.SOUTH);
        new Wall(fruitopia, 2, 1, Direction.SOUTH);
        new Wall(fruitopia, 2, 1, Direction.WEST);
        new Wall(fruitopia, 1, 1, Direction.WEST);
        
        //create a robot to complete the task in the first question
        RobotSE speedyboi = new RobotSE(fruitopia, 0, 2, Direction.WEST);
        
        //set colour of speedyboi to black
        speedyboi.setColor(Color.black);
        
        //move speedyboi two spaces to the west
        speedyboi.move(2);
        
        //make speedyboi turn left
        speedyboi.turnLeft();
        
        //move speedyboi two spaces to the south
        speedyboi.move(3);
        
        //make speedyboi turn left again
        speedyboi.turnLeft();
        
        //move speedyboi two spaces to the east
        speedyboi.move(3);
        
        //make speedyboi turn left again
        speedyboi.turnLeft();
        
        //move speedyboi two spaces to the north
        speedyboi.move(3);
        
        //make speedyboi turn left again
        speedyboi.turnLeft();
        
        //move speedyboi two spaces to the north
        speedyboi.move();
        
        
        
        
        
        
        
        
    }
}