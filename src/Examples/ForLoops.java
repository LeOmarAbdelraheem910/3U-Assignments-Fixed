/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 *
 * @author abdeo8431
 */
public class ForLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a city
        City fruitopia = new City();

        //create a robot named speedyboi
        RobotSE speedyboi = new RobotSE(fruitopia, 1, 1, Direction.EAST);

        //counted while loop
        int numberOfMoves = 5;
        //if there are still moves to do 
        while (numberOfMoves > 0) {
            speedyboi.move();
            numberOfMoves = numberOfMoves - 1;
        }

        speedyboi.turnAround();

        //counting the other way 
        numberOfMoves = 0;
        while (numberOfMoves < 5) {
            speedyboi.move();
            numberOfMoves = numberOfMoves + 1;
        }

        speedyboi.turnAround();
        //use a for loop to move
        for (int count = 0; count < 5; count++) {
            speedyboi.move();
        }
        
        int x = 10;
        x = x + 5; //add 5
        x += 5; //add 5 shortcut
        
        x = x - 10; //subtract 10
        x -= 10; //subtract 10 shortcut
        
        x *= 2; //multiply by 2
        x = x * 2; //multiply by 2 shortcut
        
        x /= 4; //divide by 2
        x = x / 4; //divide by 2 shortcut
        
        //get the remainder of 5 divided by 2 (a modulus --> operation or modulo --> single value)
        int remainder = 5 % 2; // = 1
        int quotient = 5 /2; // = 2
        
        //compoud statements
        if(speedyboi.frontIsClear()){
            if(speedyboi.canPickThing()){
                speedyboi.move();
            }
        }
        //an and statement (both must be true to perform action
        if(speedyboi.frontIsClear() && speedyboi.canPickThing()){
            speedyboi.move();
            
        //or statement (only one needs to be true)
        if(speedyboi.frontIsClear() || speedyboi.canPickThing()){
            speedyboi.move();
        }
        }
    }
}
