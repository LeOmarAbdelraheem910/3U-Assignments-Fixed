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
public class A7Q7 {

    //Create a method that will be used to find the first digit of an integer entered by the user. Eventually this can be displayed to the user in the main method.
    public static int firstDigit(int num) {
        //When the integer entered on by the user is positive, divide by ten until it is between 0 and 10, but not including 10.

        for (int i = 0; i < num; i++) {
            if (num > 10 && !(num == 10)) {
                num = num / 10;
            } //When negative, divide by ten until it is between 0 and -10, but not including -10.
            else if (num < -10 && !(num == -10)) {
                num = num / 10;
            }
        }

        //Convert the divided integer from a decimal number to an int variable that is the first digit of integer entered.
        int initialDigit = (int) num;

        //If in some case, the value calculated is negative, make it into a positive value.
        if (initialDigit < 0) {
            initialDigit = initialDigit * -1;
        }
        return initialDigit;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Ask the user this time to enter in a digit in order to output the first digit of that integer.
        System.out.print("Now you want to find the first digit of any integer? Why didn't you tell me earlier?! Hurry up and enter the integer here! : ");
        int num = input.nextInt();

        //Finally, use the firstDigit method to return the first digit of the number and output that value to the user.
        int initialDigit = firstDigit(num);
        System.out.println("The first digit of the integer that you eneter is " + initialDigit + ".");
    }

}
