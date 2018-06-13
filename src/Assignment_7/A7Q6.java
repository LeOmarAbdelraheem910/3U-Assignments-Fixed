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
public class A7Q6 {

    //A method is created to find the lastDigit of any number entered
    public static int lastDigit(int num) {
        //Determine the remainder of the integer entered, and have that returned to the user for an output in the main method. 
        int finalDigit = num % 10;
        //If the remainder is negative, make it a positive value before returning it.
        if (finalDigit < 0) {
            finalDigit = finalDigit * -1;
        }
        return finalDigit;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Greet the user as usual and prompt them to enter any integer value they wish:
        System.out.print("Hey there! You look like you could use some help with numbers. What you say? You want to know what the last digit of that there number is? \nWell, how about you enter it right here and I'll tell you what it is : ");
        int num = input.nextInt();

        //Call upon the finalDigit method to return the final digit of the entered integer and display it to the user.
        int finalDigit = lastDigit(num);
        System.out.println("The final digit of the integer you entered is " + finalDigit + ".");
    }

}
