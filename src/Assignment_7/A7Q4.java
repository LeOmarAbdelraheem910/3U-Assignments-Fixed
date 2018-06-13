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
public class A7Q4 {

    public static double compoundInterest(double P, double r, double n) {
        //Calculate the final balance after compound interest.
        double B = P * (Math.pow((1 + r), n));
        System.out.printf("The value of your balance after compound interest is: %.2f. \n", B);
        return B;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Prompt the user to enter in their initial balance, the interest rate, and the number of years the interest will compound.
        System.out.println("Welcome to your compound interest calculator! Again, you're too lazy to do the math, so we'll do it for you.");
        System.out.print("Enter in the initial value of your balance: ");
        double principal = input.nextDouble();

        System.out.print("Enter in the interest rate on your balance: ");
        double interest = input.nextDouble();

        System.out.print("Enter in the number of compounding years your balance will be growing for: ");
        double years = input.nextDouble();
        System.out.println("");

        //Call upon the compoundInterest method to calculate and output the new balance to the user.
        double B = compoundInterest(principal, interest, years);
        System.out.printf("The value of your balance after compound interest is: %.2f. \n", B);
    }

}
