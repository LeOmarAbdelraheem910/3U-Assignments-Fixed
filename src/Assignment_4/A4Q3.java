/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_4;

import java.util.Scanner;

/**
 *
 * @author Omar
 */
public class A4Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter in four numbers
        System.out.println("Hey you! I command you to enter in 4 numbers on 4 seperate lines, one after the other:");
        double firstNumber = input.nextDouble();
        double secondNumber = input.nextDouble();
        double thirdNumber = input.nextDouble();
        double fourthNumber = input.nextDouble();
        //Display the numbers in a neat, spaced out format
        System.out.println("Now that you've entered the numbers,\nI present to you your numbers: " + firstNumber + ", " + secondNumber + ", " + thirdNumber + ", and " + fourthNumber);

    }
}
