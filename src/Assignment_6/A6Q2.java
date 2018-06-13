/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_6;

import java.util.Scanner;

/**
 *
 * @author Omar
 */
public class A6Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Welcome the user to your new and improved height check program!
        System.out.println("Greetings young or old user! I'm sure you'd like to get started with your height checking business!");

        //Make the user enter in the amount of height readings and store the variables in an array
        System.out.print("How many people are you deciding to read in? : ");
        int numberOfPeople = input.nextInt();
        double[] collectedHeights = new double[numberOfPeople];

        //Now, the user will be asked to enter in the heights of every person in the reading.
        System.out.println("With that out of the way, enter in the heights of each person in centimetres. : ");
        for (int i = 0; i < collectedHeights.length; i++) {
            collectedHeights[i] = input.nextDouble();
        }

        //All of the heights of the people will be added together.
        double averageOfGroup = 0;
        for (int i = 0; i < collectedHeights.length; i++) {
            averageOfGroup = averageOfGroup + collectedHeights[i];
        }

        //Calculate the average height of the group.
        averageOfGroup *= 100;
        averageOfGroup = Math.round(averageOfGroup / collectedHeights.length);
        averageOfGroup /= 100;
        System.out.println("");
        System.out.println("The average height of the entire group is " + averageOfGroup + ".");
        System.out.println("");

        //After that, the program will sift through the array, checking if any of the heights entered are above the average height of the group.
        for (int check = 0; check < collectedHeights.length; check++) {
            if (collectedHeights[check] > averageOfGroup) {
                System.out.println("The person with a height of " + collectedHeights[check] + " cm is above average height! Wow you're tall!");
                System.out.println("");
            }
        }
    }
}
