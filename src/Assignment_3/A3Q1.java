/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author abdeo8431
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a city
        City fruitopia = new City();

        //create a 2x2 space of walls]
        new Wall(fruitopia, 1, 1, Direction.NORTH);
        new Wall(fruitopia, 1, 2, Direction.NORTH);
        new Wall(fruitopia, 1, 2, Direction.EAST);
        new Wall(fruitopia, 2, 2, Direction.EAST);
        new Wall(fruitopia, 2, 2, Direction.SOUTH);
        new Wall(fruitopia, 2, 1, Direction.SOUTH);
        new Wall(fruitopia, 2, 1, Direction.WEST);
        new Wall(fruitopia, 1, 1, Direction.WEST);

        //create a robot named speedyboi
        RobotSE speedyboi = new RobotSE(fruitopia, 0, 2, Direction.WEST);

        //make speedyboi round the 2x2 square twice, returning to the starting position after the completeion of the second lap
        int completeALap = 8;
        while (completeALap > 0) {
            speedyboi.move(2);
            speedyboi.turnLeft();
            speedyboi.move();
            completeALap = completeALap - 1;
        }
    }
}
