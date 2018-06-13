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
public class A6Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Force the user to enter in two integers... literally any integers. Store the integers in an array.
        System.out.println("HEY YOU! You'd better enter in two integers right now! Any integers; let's go mister/miss:");

        int[] A = new int[2];

        int firstInt = A[0] = input.nextInt();
        int secondInt = A[1] = input.nextInt();

        //Create a sorting system for the numbers. The numbers will be ordered from least to greatest, meaning if the first integer is larger than the second, their positions will be swapped.
        for (int check = 0; check < 1; check++) {
            if (A[0] > A[1]) {
                A[0] = secondInt;
                A[1] = firstInt;
            }
            System.out.println("The two integers listed from least to greatest are: " + Arrays.toString(A) + ".");
        }
    }
}
