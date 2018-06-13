/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_6;

import java.util.Scanner;

/**
 *
 * @author abdeo8431
 */
public class A6Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hey there computer science teacher or potential student hacker, here is your Class Mark Averager (I get it, it's a lame name).");
        //Ask the user how many students are in their computer science class.
        System.out.print("How many students are in your very class room this semester??? : ");

        //Create a variable for future use (in order to create an array).
        int numberOfStudents = input.nextInt();

        //Store the number of student marks in the class using an array.
        int[] classMarks = new int[numberOfStudents];

        //Prompt the user to enter in all of the student marks.
        System.out.println("Now, enter in the marks of every student in order:");
        for (int individualStudentMark = 0; individualStudentMark < classMarks.length; individualStudentMark++) {
            classMarks[individualStudentMark] = input.nextInt();
        }
        //Once the user has entered every single student mark into the program, find the class average and state the class average to the nearest hundreth to the user.
        double classAverage = 0;
        for (int individualStudentMark = 0; individualStudentMark < classMarks.length; individualStudentMark++) {
            classAverage = classAverage + classMarks[individualStudentMark];
        }
        classAverage = classAverage * 100;
        classAverage = Math.round(classAverage / classMarks.length);
        classAverage = classAverage / 100;
        System.out.println("The class average for your computer science class is " + classAverage + "%.");

    }
}
