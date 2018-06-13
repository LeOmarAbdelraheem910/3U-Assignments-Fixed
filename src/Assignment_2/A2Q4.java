/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author abdeo8431
 */
public class A2Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a city for King Java's castle to exist
        City fruitopia = new City();

        //create the walls for Java's Castle
        //create the walls for the northwest tower using a 1x1 space
        new Wall(fruitopia, 1, 1, Direction.NORTH);
        new Wall(fruitopia, 1, 1, Direction.SOUTH);
        new Wall(fruitopia, 1, 1, Direction.EAST);
        new Wall(fruitopia, 1, 1, Direction.WEST);
        //create the walls for the northeast tower using a 1x1 space
        new Wall(fruitopia, 1, 4, Direction.NORTH);
        new Wall(fruitopia, 1, 4, Direction.SOUTH);
        new Wall(fruitopia, 1, 4, Direction.EAST);
        new Wall(fruitopia, 1, 4, Direction.WEST);
        //create the walls for the southwest tower using a 1x1 space
        new Wall(fruitopia, 4, 1, Direction.NORTH);
        new Wall(fruitopia, 4, 1, Direction.SOUTH);
        new Wall(fruitopia, 4, 1, Direction.EAST);
        new Wall(fruitopia, 4, 1, Direction.WEST);
        //create the walls for the southeast tower using a 1x1 space
        new Wall(fruitopia, 4, 4, Direction.NORTH);
        new Wall(fruitopia, 4, 4, Direction.SOUTH);
        new Wall(fruitopia, 4, 4, Direction.EAST);
        new Wall(fruitopia, 4, 4, Direction.WEST);
        //create the walls for the courtyard using a 2x2 space in the space between the towers
        new Wall(fruitopia, 2, 2, Direction.NORTH);
        new Wall(fruitopia, 2, 2, Direction.WEST);
        new Wall(fruitopia, 2, 3, Direction.NORTH);
        new Wall(fruitopia, 2, 3, Direction.EAST);
        new Wall(fruitopia, 3, 2, Direction.SOUTH);
        new Wall(fruitopia, 3, 2, Direction.WEST);
        new Wall(fruitopia, 3, 3, Direction.SOUTH);
        new Wall(fruitopia, 3, 3, Direction.EAST);

        //create the castle guard named speedyboi
        RobotSE speedyboi = new RobotSE(fruitopia, 2, 0, Direction.NORTH);

        //set the colour of speedyboi to pink
        speedyboi.setColor(Color.pink);

        //set up a condition that while the front is clear, manuever around the castle in a loop
        while (speedyboi.frontIsClear()) {
            speedyboi.move(2);
            speedyboi.turnRight();
            speedyboi.move(2);
            speedyboi.turnRight();
            speedyboi.move();
            speedyboi.turnLeft();
            speedyboi.move();
            speedyboi.turnLeft();
            speedyboi.move();
            speedyboi.turnRight();
        }
    }
}
