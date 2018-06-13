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
public class InputOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //pringt a line of text
        System.out.println("Hello World");
        System.out.println("Another line!");
        System.out.println(""); //print a blank line
        //printing on the same line
        System.out.print("The cake ");
        System.out.println("is a lie!");
        
        //printing special characters
        //(escape characters)
        //quotation marks \"
        System.out.println("\"I'm inside quotation marks! Please help me\"");
        
        //slash \\ --> to the right
        System.out.println("A slash \\");
        // a tab \t
        System.out.println("pop\tpizza\tfries");
        //space --> \s
        // a new line \n
        System.out.println("One line\nSecond line");
        
        //make an integer storing 10
        int number = 10;
        System.out.println(number);
        System.out.println("number = " + number);
        System.out.println("number = " + number + ". YAY!");
        
        //blanklines to separate
        System.out.println("");
        System.out.println("");
        
        //use a Scanner tp read info
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter your name!!!!!!!!!");
        //Make a String to store a name
        String name = input.nextLine();
        
        //say hello
        System.out.println("Hello " + name);
        
        //ask what year they were born
        System.out.println("What year where you born?");
        
        int birthYear = input.nextInt(); 
        int age = 2018 - birthYear;
        //your an idiot loop...
        while(age < 0){
            System.out.println("Try again...");
            birthYear = input.nextInt();
            age = 2018 - birthYear;
        }
        System.out.println("You are " + age + " years old!");
        
        if(age < 0){
            System.out.println("I don't think so...");
        }else if(age > 30){
            System.out.println("You are old!");
        }
        
    }
}
