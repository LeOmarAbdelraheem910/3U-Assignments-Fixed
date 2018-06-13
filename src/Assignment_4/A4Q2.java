/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_4;

import java.util.Scanner;

/**
 *
 * @author abdeo8431
 */
public class A4Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter in a measurement in inches to convert
        System.out.println("Are you too lazy to do the math? Do you not want to memorize conversions?");
        System.out.println("Well, enter in a measurement in inches and we'll convert to centimetres: ");

        //Let the user enter a measurement in inches
        double measurementInInches = input.nextDouble();
        System.out.println("");
        //Convert between inches and centrimetre
        double measurementInCentimetres = measurementInInches * 2.54;

        //State the conversion to the user and leave a nice comment for them :)
        System.out.println("Hey! Here's your conversion to centimetres! Enjoy cheating your way through life! ");
        System.out.printf("%.2f inches is equivalent to %.2f cm!\n", measurementInInches, measurementInCentimetres);

    }
}
