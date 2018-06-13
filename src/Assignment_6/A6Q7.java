/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_6;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Omar
 */
public class A6Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Greet the user and prompt them to enter in a number n to create a range between 2 and n. 
        System.out.println("Let's say you're lazy and don't want to determine all of the prime numbers between 2 and a certain number by yourself. Mental math is a challenge for you... \nWell look no further because here is a program that can do all of that math for you!");
        System.out.print("Enter in a number n to limit your range: ");
        int n = input.nextInt();

        //Create a boolean array that contains all the numbers between 0 and n
        boolean[] range = new boolean[n + 1];

        //Make the program assume that all of the numbers in the range are prime
        for (int i = 0; i < range.length; i++) {
            range[i] = true;
        }

        //Check through every number in the range,
        for (int p = 2; p <= n; p++) {
            //if any of the numbers are unmarked, they are prime or p,
            if (range[p] == true) {
                //and find every multiple of the p starting from two times p to the integer n; adding the p to itself until it reaches n. Mark every multiple of the prime (these are the composite numbers).
                for (int i = p * 2; i <= n; i += p) {
                    range[i] = false;
                }
            }
        }

        //Present and print all of the unmarked or prime numbers between 2 and n to the user!
        System.out.print("All of the prime numbers between and including 2 and " + n + " are: ");
        for (int i = 2; i <= n; i++) {
            if (range[i] == true) {
                System.out.print(i + ", ");
            }
        }
    }
}
