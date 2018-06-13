/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.RobotSE;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author abdeo8431
 */
public class A1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create a city for two robots to manuver in\
        City fruitopia = new City();
        
        //create a set of walls in an "L" shape in between the robots
        new Wall(fruitopia, 0, 1, Direction.WEST);
        new Wall(fruitopia, 1, 1, Direction.WEST);
        new Wall(fruitopia, 1, 1, Direction.SOUTH);
        
        //create the first robot named speedyboi at coordinates (0,0)
        RobotSE speedyboi = new RobotSE(fruitopia, 0, 0, Direction.SOUTH);
        
        //change the colour of speedyboi to green
        speedyboi.setColor(Color.green);
        //create the second robot named speedygurl at corrdinates (0,1)
        RobotSE speedygurl = new RobotSE(fruitopia, 0, 1, Direction.SOUTH);
        
        //change the colour of tinker to pink
        speedygurl.setColor(Color.pink);
        
        //move speedyboi one space to the south
        speedyboi.move();
        
        //move speedygurl one space to the south
        speedygurl.move();
        
        //turn speedygurl to the left
        speedygurl.turnLeft();
        
        //move speedygurl one space to the east
        speedygurl.move();
        
        //move speedyboi one more space to the south
        speedyboi.move();
        
        //turn speedyboi to the left
        speedyboi.turnLeft();
        
        //turn speedygurl to the right
        speedygurl.turnRight();
        
        //move speedygurl one space to the south
        speedygurl.move();
        
        //turn speedygurl to the right
        speedygurl.turnRight();
        
        //move speedyboi one space to the east
        speedyboi.move();
        
        //move speedygurl one space to the west
        speedygurl.move();
        
        
        
        
        
        
    }
}