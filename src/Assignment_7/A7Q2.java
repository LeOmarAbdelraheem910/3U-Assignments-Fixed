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
public class A7Q2 {

    public static void examGrade(int mark) {
        //Check the mark entered by the user. Depending the mark, the user will receive a grade accordingly.
        if (mark < 50) {
            System.out.println("Since your mark is " + mark + "%, your grade is an F... well done mate! *slow claping in the distance*");
        }
        if (50 <= mark && mark <= 59) {
            System.out.println("Since your mark is " + mark + "%, your grade is an D... you're getting there... just keep trying!");
        }
        if (60 <= mark && mark <= 69) {
            System.out.println("Since your mark is " + mark + "%, your grade is an C... it's an improvement upon something, just know you're within reach of the provincial standard!!!");
        }
        if (70 <= mark && mark <= 79) {
            System.out.println("Since your mark is " + mark + "%, your grade is an B... hey, you're at the provincial standard. Try going above and beyond to be the best of the best!");
        }
        if (mark >= 80) {
            System.out.println("Since your mark is " + mark + "%, your grade is an A... you shouldn't even be here you Einstein!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Ask the user to input their exam average into the program.
        System.out.println("Welcome to the program that will assign you a grade level, based on your average on an exam!");
        System.out.print("Enter in the average here: ");
        int studentMark = input.nextInt();
        System.out.println("");

        //Based on the user's input, determine their grade letter level.
        examGrade(studentMark);
    }

}
