/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_6;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author abdeo8431
 */
public class A6Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Welcome the user to the program. 
        System.out.println("We meet again, Computer Science teacher. You are here to enter in class marks I see.");

        //Create an array to store the 10 student marks the user is ready to enter.
        int[] classMarks = new int[10];

        //Ask them to enter in the 10 student marks.
        System.out.println("Well, enter in the 10 student marks that you are eager to put into the system:");
        for (int i = 0; i < 10; i++) {
            classMarks[i] = input.nextInt();
        }
        System.out.println("");

        //What must be done now is to sort the student marks from least to greatest if not already done so.
        //First, run through every mark in the array, repeating 10 times to make sure the program checks every value.
        for (int i = 0; i < 10; i++) {
            //Now, search for and compare two integers that are beside one another; essentially the first two integers defined by x (the first integer out of the two) and y (the second integer).
            //This search and comparison will occur for the entire length of the array.
            for (int x = 0; x < 9; x++) {
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
        //Lastly, output the marks to user in order from least to greatest.
        System.out.println("Your student marks in order from least to greatest are as follows: " + Arrays.toString(classMarks) + ".");
    }
}
