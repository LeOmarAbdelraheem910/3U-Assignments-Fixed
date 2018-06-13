/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 *Learning how to use the robots
 * @author abdeo8431
 */
public class RobotExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args, double d) {
       
        // create a City for the robot
        City fruitopia = new City();
        
        // put a robot in fruitopia
        RobotSE speedyboi = new RobotSE(fruitopia, 2, 3, Direction.EAST);
        
        // create a wall
        new Wall(fruitopia, 2, 5, Direction.WEST);
        
        // create a thing
        new Thing(fruitopia, 2, 4);
        
        // put the word boi on the robot
        speedyboi.setLabel("BOI");
        
        // set the colour of the robot
        speedyboi.setColor(Color.pink);
        
        // move the robot forward one space
        speedyboi.move();
        
        // move the robot n number of spaces
        // speedyboi.move(2);
        
        // turn the robot to the left
        speedyboi.turnLeft();
        
        // pick up the thing
        speedyboi.pickThing();
        
        // move the robot again
        speedyboi.move();
        
        // put the thing down
        speedyboi.putThing();
        speedyboi.move();
        
        speedyboi.examineLights();
        
        speedyboi.countThingsInBackpack();

    }
}
