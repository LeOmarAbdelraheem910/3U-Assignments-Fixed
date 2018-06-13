/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Scanner;

/**
 *
 * @author abdeo8431
 */
public class MethodsExample {

    // The HelloWorld method to say hello
    public static void helloWorld() {
        System.out.println("Hello world!");
    }

    public static void sayHello(String name) {
        System.out.println("Hello " + name + "!");    
    }
    
    //calculates the positive root of quadratic formula 
    public static double positiveQuadFormula(double a, double b, double c) {
        double[] roots = quadFormula(a,b,c);
        //send back the root
        return roots[0];
    }
    public static double[] quadFormula(double a, double b, double c) {
        //create the array to store both roots
        double[] roots = new double[2];
        //calculate the roots
        double discrim = b * b - 4 * a * c;
        roots[0] = (-b + Math.sqrt(discrim)) / (2*a);
        roots[1] = (-b - Math.sqrt(discrim)) / (2*a);
        //send back the root
        return roots;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //call thje helloWorld method
        helloWorld();

        System.out.println("What is your name?");
        String user = input.nextLine();
        sayHello(user);
        
        //calculate the +ve root of 3x^2 + 7x + 1.5
        double pRoot = positiveQuadFormula(1,-5,-50);
        System.out.println("The positive root is " + pRoot + ".");
        
        double[] roots = quadFormula(1,-5,-50);
        System.out.println("The roots are " + roots[0] + " and " + roots[1] + ".");
    }
}


