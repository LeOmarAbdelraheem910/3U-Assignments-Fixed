/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import java.awt.Color;

/**
 *
 * @author abdeo8431
 */
public class A2Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create a city for which the first question will be answered
        City fruitopia = new City();

        //create a row of ten things for the robot to pick up on it's course
        new Thing(fruitopia, 1, 2);
        new Thing(fruitopia, 1, 3);
        new Thing(fruitopia, 1, 4);
        new Thing(fruitopia, 1, 5);
        new Thing(fruitopia, 1, 6);
        new Thing(fruitopia, 1, 7);
        new Thing(fruitopia, 1, 8);
        new Thing(fruitopia, 1, 9);
        new Thing(fruitopia, 1, 10);
        new Thing(fruitopia, 1, 11);

        //create a robot named speedyboi at coordinates (1,1) facing east
        RobotSE speedyboi = new RobotSE(fruitopia, 1, 1, Direction.EAST);

        //set the colour of speedyboi to black
        speedyboi.setColor(Color.black);

        //cause speedyboi to move one space to the east
        speedyboi.move();

        //execute this loop while speedyboi is able to pick up a thing from the row
        while (speedyboi.canPickThing()) {
            if (speedyboi.countThingsInBackpack() <= 6) {
                speedyboi.pickThing();
            }
            //let speedyboi continue to move, so long as there are still things it can pick up
            speedyboi.move();
        }
    }
}
