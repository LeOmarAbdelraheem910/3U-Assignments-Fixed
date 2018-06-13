/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author Omar
 */
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create a city!
        City fruitopia = new City();

        //allow for a Thing counter to be shown
        fruitopia.showThingCounts(true);

        //create the pile of ten things where a robot, speedyboi, will be created
        new Thing(fruitopia, 0, 0);
        new Thing(fruitopia, 0, 0);
        new Thing(fruitopia, 0, 0);
        new Thing(fruitopia, 0, 0);
        new Thing(fruitopia, 0, 0);
        new Thing(fruitopia, 0, 0);
        new Thing(fruitopia, 0, 0);
        new Thing(fruitopia, 0, 0);
        new Thing(fruitopia, 0, 0);
        new Thing(fruitopia, 0, 0);

        //create the robot, speedyboi, on the pile of ten things
        RobotSE speedyboi = new RobotSE(fruitopia, 0, 0, Direction.EAST);

        int movingThingsOver = 10;
        //move the pile of ten Things, one Thing at a time, over to the next intersection 
        while (movingThingsOver > 0) {
            speedyboi.pickThing();
            speedyboi.move();
            speedyboi.turnAround();
            speedyboi.putThing();
            speedyboi.move();
            speedyboi.turnAround();
            movingThingsOver = movingThingsOver - 1;
        }
        //reposition back overtop of the pile of things
        speedyboi.move();
    }
}
