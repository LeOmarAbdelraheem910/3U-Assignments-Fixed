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
public class A7Q8 {

    //Create a method that checks to see if an integer entered has all odd digits or not.
    public static boolean allDigitsOdd(int num) {

        //This is the variable that will store whether an integer is odd or not, using true or false.
        boolean evenOrOdd = true;

        //Create a loop that will go through ever digit in the number by creating remainders through a division of 10.
        for (int i = 0; i < num; i++) {
            int remainder = num % 10;
            //If any remainder checked is even, mark the entire integer as false.
            if (remainder % 2 == 0) {
                evenOrOdd = false;
            } //If not, mark the remainder as odd and continue to the next digit.
            else if (!(remainder % 2 == 0)) {
                evenOrOdd = true;
                num = (num - remainder) / 10;
            }
        }
        return evenOrOdd;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Prompt the user to enter in a number, for the final time in this assignment! :)
        System.out.println("Okay, now you're telling me you're so lazy and unmotivated that you don't even want to try to differentiate between a digit being odd or even? Fine! I'll do it for you...");
        System.out.print("Enter in an integer you want me to check the digits of. And this is the last time I'll accept this! : ");
        int num = input.nextInt();

        //Call upon the allDigitsOdd method, defined by a boolean.
        boolean evenOrOdd = allDigitsOdd(num);
        //As long as all of the digits in the integer entered are odd, the user will be notified that all of the digits are odd.
        if (evenOrOdd == true) {
            System.out.println("Well, let me just say that every single digit in " + num + " is odd! You're welcome lazy butt.");
        } //If even one digit in the interger is evem , the user will be sad knowing the integer has an even digit in it.
        else if (evenOrOdd == false) {
            System.out.println("According to my calculations; one, some, or all of the digits in " + num + " are even. I'm surprised you needed me for that.");
        }
    }

}
