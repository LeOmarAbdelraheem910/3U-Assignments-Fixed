/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 *
 * @author Omar
 */
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create a city for the hundredth time in order for the field to exist
        City fruitopia = new City();

        //create a farmer named speedyboi, to do the job of planting the seeds.
        RobotSE speedyboi = new RobotSE(fruitopia, 1, 1, Direction.EAST, 20);

        //Repeat the seed planting process for each of the four rows
        for (int plantTheRows = 0; plantTheRows < 4; plantTheRows++) {
            //it will plant the seeds in a row
            for (int plantSeeds = 5; plantSeeds > 0; plantSeeds--) {
                speedyboi.putThing();
                speedyboi.move();
            }

            speedyboi.turnAround();
            //move back to the beginning of the row
            for (int plantSeeds = 0; plantSeeds < 5; plantSeeds++) {
                speedyboi.move();
            }
            //and move down to the next row to plant seeds again
            speedyboi.turnLeft();
            speedyboi.move();
            speedyboi.turnLeft();
        }
    }
}
