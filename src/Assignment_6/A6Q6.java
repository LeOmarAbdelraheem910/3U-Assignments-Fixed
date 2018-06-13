/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_6;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Omar
 */
public class A6Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Welcome the user to the program. 
        System.out.println("We meet again, Computer Science teacher. You are here to enter in class marks I see.");

        //Ask the user how many student marks they want to enter into the system.
        System.out.print("How many students are in your class? : ");
        int numberOfMarks = input.nextInt();

        //Create an array to store the student marks the user is ready to enter.
        int[] classMarks = new int[numberOfMarks];

        //Ask them to enter in the student marks.
        System.out.println("Well, enter in the marks that you are eager to put into the system for each student in your class:");
        for (int i = 0; i < classMarks.length; i++) {
            classMarks[i] = input.nextInt();
        }
        System.out.println("");

        //What must be done first is to sort the student marks from least to greatest if not already done so.
        //Run through every mark in the array, repeating 10 times to make sure the program checks every value.
        for (int i = 0; i < classMarks.length; i++) {
            //Now, search for and compare two integers that are beside one another; essentially the first two integers defined by x (the first integer out of the two) and y (the second integer).
            //This search and comparison will occur for the entire length of the array.
            for (int x = 0; x < classMarks.length - 1; x++) {
                int firstInt = classMarks[x];
                int y = x + 1;
                int secondInt = classMarks[y];
                //If for any reason integer x is larger than y, swap their positions.
                if (classMarks[x] > classMarks[y]) {
                    classMarks[y] = firstInt;
                    classMarks[x] = secondInt;
                }
            }
        }
        //Next, output the marks to user in order from least to greatest.
        System.out.println("Your student marks in order from least to greatest are as follows: " + Arrays.toString(classMarks) + ".");
        System.out.println("");

        //Now, determine the lowest mark in the class,
        System.out.println("The lowest mark in the class is: " + classMarks[0] + ".");
        System.out.println("");

        //the highest mark in the class,
        System.out.println("The highest mark in the class is: " + classMarks[classMarks.length - 1] + ".");
        System.out.println("");

        //and the class average and output all three to the user in a neat and presentable form.
        double classAverage = 0;
        for (int i = 0; i < classMarks.length; i++) {
            classAverage = classAverage + classMarks[i];
        }
        classAverage *= 100;
        classAverage = Math.round(classAverage / classMarks.length);
        classAverage /= 100;
        System.out.println("The average of the entire group is " + classAverage + ".");
    }

}
