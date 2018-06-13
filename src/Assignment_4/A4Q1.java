/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_4;

import java.util.Scanner;

/**
 *
 * @author abdeo8431
 */
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //Describe a warrior, lost in time and prompt the user to enter their name
        System.out.println("In our dark times in history, our saviour, a legendary warrior, thwarted our enemies and solved our problems.");
        System.out.print("This warrior was named (enter your name here): ");

        //Allow the user to enter their name
        String name = input.nextLine();

        //Greet the user as if they are this legend
        System.out.println("Greetings " + name + ", the mighty leader of the Jorvic Clan!");
    }
}
