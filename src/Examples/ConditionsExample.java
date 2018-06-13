/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author abdeo8431
 */
public class ConditionsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create a city 
        City fruitopia = new City();

        //create a robot
        RobotSE speedyboi = new RobotSE(fruitopia, 2, 1, Direction.EAST);

        //create a wall in front 
        new Wall(fruitopia, 2, 5, Direction.EAST);


        //place a few things
        new Thing(fruitopia, 2, 2);
        new Thing(fruitopia, 2, 4);

        //move while the front is  clear
        while (speedyboi.frontIsClear()) {
            //if front is clear, do this
            speedyboi.move();

            //is there something to pick up?
            if (speedyboi.canPickThing()) {
                speedyboi.pickThing();
            }
        }
        //when front is not clear
        speedyboi.turnRight();

        if (speedyboi.countThingsInBackpack() == 1){
            speedyboi.move();
        }else if (speedyboi.countThingsInBackpack() == 2){
            speedyboi.move(2);
        }else{
            speedyboi.turnAround();
        }
    }
}
