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
public class A7Q1 {

    public static double areaCircle(double r) {
        //Calculate the area of a circle.
        double answer = r * r * Math.PI;
        return answer;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Greet the user and tell them to enter in the radius of the circle.
        System.out.println("Hey there you lazy guy or gal, here's a neat little program to do your math homework for the area of a cicle!");
        System.out.print("Enter in the radius of circle you want to calculate the area of: ");
        double radius = input.nextDouble();

        //Call upon the method areaCircle to calculate the area of the cicle and output it to the user.
        double answer = areaCircle(radius);
        System.out.printf("The area of the circle you want to calculate is: %.2f units^2. \n", answer);
    }

}
