/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author Omar
 */
public class A3Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create a city
        City fruitopia = new City();

        //create the set of four squares
        //create the first sqaure in the top left
        new Wall(fruitopia, 1, 1, Direction.NORTH);
        new Wall(fruitopia, 1, 1, Direction.WEST);
        new Wall(fruitopia, 1, 2, Direction.NORTH);
        new Wall(fruitopia, 1, 2, Direction.EAST);
        new Wall(fruitopia, 2, 1, Direction.SOUTH);
        new Wall(fruitopia, 2, 1, Direction.WEST);
        new Wall(fruitopia, 2, 2, Direction.SOUTH);
        new Wall(fruitopia, 2, 2, Direction.EAST);

        //create the second square in the top right
        new Wall(fruitopia, 4, 1, Direction.NORTH);
        new Wall(fruitopia, 4, 1, Direction.WEST);
        new Wall(fruitopia, 4, 2, Direction.NORTH);
        new Wall(fruitopia, 4, 2, Direction.EAST);
        new Wall(fruitopia, 5, 1, Direction.SOUTH);
        new Wall(fruitopia, 5, 1, Direction.WEST);
        new Wall(fruitopia, 5, 2, Direction.SOUTH);
        new Wall(fruitopia, 5, 2, Direction.EAST);

        //create the thrid square in the bottom left
        new Wall(fruitopia, 1, 4, Direction.NORTH);
        new Wall(fruitopia, 1, 4, Direction.WEST);
        new Wall(fruitopia, 1, 5, Direction.NORTH);
        new Wall(fruitopia, 1, 5, Direction.EAST);
        new Wall(fruitopia, 2, 4, Direction.SOUTH);
        new Wall(fruitopia, 2, 4, Direction.WEST);
        new Wall(fruitopia, 2, 5, Direction.SOUTH);
        new Wall(fruitopia, 2, 5, Direction.EAST);

        //create the last square in the bottom right
        new Wall(fruitopia, 4, 4, Direction.NORTH);
        new Wall(fruitopia, 4, 4, Direction.WEST);
        new Wall(fruitopia, 4, 5, Direction.NORTH);
        new Wall(fruitopia, 4, 5, Direction.EAST);
        new Wall(fruitopia, 5, 4, Direction.SOUTH);
        new Wall(fruitopia, 5, 4, Direction.WEST);
        new Wall(fruitopia, 5, 5, Direction.SOUTH);
        new Wall(fruitopia, 5, 5, Direction.EAST);

        //create a robot named speedyboi, in the centre of the set of squares
        RobotSE speedyboi = new RobotSE(fruitopia, 3, 3, Direction.SOUTH);

        //complete a counterclockwise movement 4 times in order to go around each block until the starting position is reached
        //the code is set up in such a way that speedyboi will be able to cross over to the next block flawlessly
        //first segement of the movement
        for (int counterclockwiseMovement = 4; counterclockwiseMovement > 0; counterclockwiseMovement--) {
            speedyboi.move(3);
            //second segment of the movement
            for (int circleTheBlocks = 3; circleTheBlocks > 0; circleTheBlocks--) {
                speedyboi.turnLeft();
                speedyboi.move(3);
            }
        }
    }
}
