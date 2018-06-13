/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizes;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author abdeo8431
 */
public class Quiz1_CommandingRobots {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create a city for the staircase to exist
        City fruitopia = new City();
        
        //create the staircase using walls
        new Wall(fruitopia, 4, 2, Direction.WEST);
        new Wall(fruitopia, 4, 2, Direction.NORTH);
        new Wall(fruitopia, 3, 3, Direction.WEST);
        new Wall(fruitopia, 3, 3, Direction.NORTH);
        new Wall(fruitopia, 2, 4, Direction.WEST);
        new Wall(fruitopia, 2, 4, Direction.NORTH);
        new Wall(fruitopia, 2, 5, Direction.NORTH);
        new Wall(fruitopia, 2, 5, Direction.EAST);
        new Wall(fruitopia, 3, 6, Direction.NORTH);
        new Wall(fruitopia, 3, 6, Direction.EAST);
        new Wall(fruitopia, 4, 7, Direction.NORTH);
        new Wall(fruitopia, 4, 7, Direction.EAST);
        
        //create the lights on the left side of the staircase
        new Thing(fruitopia, 4, 1);
        new Thing(fruitopia, 3, 2);
        new Thing(fruitopia, 2, 3);
        new Thing(fruitopia, 1, 4);
        
        //create a robot named speedyboi, who will move the lights to the right side of the staircase
        RobotSE speedyboi = new RobotSE(fruitopia, 4, 0, Direction.EAST);
        
        //get speedyboi to the edge of the staircase on the left side
        speedyboi.move();
        //Climb the staircase on the left side
        while(speedyboi.getAvenue()<4){
        //remove the lights from the left side of the staircase
            if(speedyboi.canPickThing()){
                speedyboi.pickThing();
            }
        //maneuver over the staircase
            if(speedyboi.frontIsClear()){
                speedyboi.move();
                speedyboi.turnRight();
                speedyboi.move();
            }else if(!speedyboi.frontIsClear()){
                speedyboi.turnLeft();     
        }
        } 
        //reposition speedyboi to climb down the right side of the mountain
        speedyboi.pickThing();
        speedyboi.move();
        
        while(speedyboi.getAvenue()<=7){
        if(speedyboi.frontIsClear()){
                speedyboi.putThing();
                speedyboi.move();
                speedyboi.turnRight();
                speedyboi.move();
            }else if(!speedyboi.frontIsClear()){
                speedyboi.turnLeft();     
        }
            if(speedyboi.canPickThing()){
                speedyboi.pickThing();
            }           
}
        speedyboi.putThing();
        speedyboi.turnLeft();
            speedyboi.move();
}
}
