/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Omar
 */
public class A1Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create a city for the mountain to exist in 
        City fruitopia = new City();
        
        //create the mountain for the robot to follow along the face of using walls
        new Wall(fruitopia, 3, 2, Direction.WEST);
        new Wall(fruitopia, 3, 2, Direction.NORTH);
        new Wall(fruitopia, 2, 3, Direction.WEST);
        new Wall(fruitopia, 1, 3, Direction.WEST);
        new Wall(fruitopia, 1, 3, Direction.NORTH);
        new Wall(fruitopia, 1, 3, Direction.EAST);
        new Wall(fruitopia, 2, 4, Direction.NORTH);
        new Wall(fruitopia, 2, 4, Direction.EAST);
        new Wall(fruitopia, 3, 4, Direction.EAST);
        
        //create the flag for which the robot will pick up at coordinates (3,1)
        new Thing(fruitopia, 3, 1);
        
        //create the robot that will pick up the flag and climb up and down the mountain at coordinates (3,0)
        RobotSE speedyboi = new RobotSE(fruitopia, 3, 0, Direction.EAST);
        
        //set colour of robot to black
        speedyboi.setColor(Color.black);
        
        //move robot one space to the east
        speedyboi.move();
        
        //make the robot pick up the flag
        speedyboi.pickThing();
        
        //turn the robot to the left
        speedyboi.turnLeft();
        
        //move the robot one space to the north
        speedyboi.move();
        
        //turn the robot to the right
        speedyboi.turnRight();
        
        //move the robot one space to the west
        speedyboi.move();
        
        //turn the robot to the left
        speedyboi.turnLeft();
        
        //move the robot two spaces to the north
        speedyboi.move(2);
        
        //turn the robot to the right 
        speedyboi.turnRight();
        
        //move the robot one space to the east
        speedyboi.move();
        
        //make the robot drop the flag at coordinates (0,3)
        speedyboi.putThing();
        
        //move the robot one space to the east
        speedyboi.move();
        
        //turn the robot to the right
        speedyboi.turnRight();
        
        //move the robot one space to the south
        speedyboi.move();
        
        //turn the robot to the left
        speedyboi.turnLeft();
        
        //move the robot one space to the east
        speedyboi.move();
        
        //turn the robot to the right
        speedyboi.turnRight();
        
        //move the robot two spaces to the south
        speedyboi.move(2);
        
        //turn the robot to the left
        speedyboi.turnLeft();
        
        
        
    }
    
}