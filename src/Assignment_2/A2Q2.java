/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.IPredicate;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author Omar
 */
public class A2Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create a city for the hurdle race to exist
        City fruitopia = new City();

        //create the the hurdle race for which the robot will speed through
        //create the base of the racing track
        new Wall(fruitopia, 2, 0, Direction.SOUTH);
        new Wall(fruitopia, 2, 1, Direction.SOUTH);
        new Wall(fruitopia, 2, 2, Direction.SOUTH);
        new Wall(fruitopia, 2, 3, Direction.SOUTH);
        new Wall(fruitopia, 2, 4, Direction.SOUTH);
        new Wall(fruitopia, 2, 5, Direction.SOUTH);
        new Wall(fruitopia, 2, 6, Direction.SOUTH);
        new Wall(fruitopia, 2, 7, Direction.SOUTH);
        new Wall(fruitopia, 2, 8, Direction.SOUTH);
        new Wall(fruitopia, 2, 9, Direction.SOUTH);
        new Wall(fruitopia, 2, 10, Direction.SOUTH);
        new Wall(fruitopia, 2, 11, Direction.SOUTH);
        new Wall(fruitopia, 2, 12, Direction.SOUTH);
        new Wall(fruitopia, 2, 13, Direction.SOUTH);
        new Wall(fruitopia, 2, 14, Direction.SOUTH);

        //create the hurdles for the race
        new Wall(fruitopia, 2, 1, Direction.EAST);
        new Wall(fruitopia, 2, 3, Direction.EAST);
        new Wall(fruitopia, 2, 6, Direction.EAST);
        new Wall(fruitopia, 2, 8, Direction.EAST);
        new Wall(fruitopia, 2, 10, Direction.EAST);
        new Wall(fruitopia, 2, 11, Direction.EAST);

        //create a thing as a marker for the finish line/the end of the race
        new Thing(fruitopia, 2, 14);

        //create a robot named speedyboi that will complete the race.
        RobotSE speedyboi = new RobotSE(fruitopia, 2, 0, Direction.EAST);

        //set the colour of speedyboi to black
        speedyboi.setColor(Color.black);

        //as long as speedyboi has not reached the finish line, execute the command
        while (!speedyboi.canPickThing()) {
            //if speedyboi's path is blocked by a hurdle, perform a maneuver around the hurdle
            if (!speedyboi.frontIsClear()) {
                speedyboi.turnLeft();
                speedyboi.move();
                speedyboi.turnRight();
                speedyboi.move();
                speedyboi.turnRight();
                speedyboi.move();
                speedyboi.turnLeft();
            } else if (speedyboi.frontIsClear()) {
                speedyboi.move();
            }
        }
    }
}
