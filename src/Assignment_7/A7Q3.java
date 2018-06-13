/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7;

import java.util.Scanner;

/**
 *
 * @author Omar
 */
public class A7Q3 {

    public static void factors(int number) {
        //Create an array to store an amount of numbers equal to the integer that the factors need to be determined for.
        int[] range = new int[number];

        for (int i = 0; i < range.length; i++) {
            range[i] = i + 1;
        }

        //Create a loop that will check for a remainder with all of the numbers between 1 and the integer when dividing from the integer.
        System.out.print("The factors of " + number + " are: ");
        for (int i = 0; i < range.length; i++) {
            //If there is no remainder, the divisor is a factor of the integer and will be outputed to the user.
            if ((number % range[i]) == 0) {
                System.out.print(range[i] + ", ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Greet the user and prompt them to enter in an integer to find the factors of.
        System.out.println("You're back again because you're too lazy to do math calculations. This time, you want to find the factors of a number, right?");
        System.out.print("Enter in the integer that you want to find the factor of here: ");
        int number = input.nextInt();
        System.out.println("");

        //Call upon the factors method to state the factors!
        factors(number);
    }

}
