/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiscellaneousProjects;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Omar
 */
public class A6Q7Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        
        int[] range = new int[size];
        
        for (int i = 0; i < range.length; i++) {
            range[i] = 2 + i;
        }
        //System.out.println(Arrays.toString(range));
        System.out.println("");
        
        for (int p = 2; p <= range.length; p++) {
            for (int i = p; i <= range.length; i += p) {
                if (2 / 2 == 1 
                        || (2 + 1) / 3 == 1 
                        || (2 + 3) / 5 == 1 
                        || (2 + 5) / 7 == 1){
                    if(p == 2 || p == 3 || p == 5 || p == 7){
                    System.out.print(p + ", ");
                    break;
                }
                if (!((p % 2) == 0) && 
                        !((p % 3) == 0) && 
                        !((p % 5) == 0) && 
                        !((p % 7) == 0)  
                        ) {
                    System.out.print(p + ", ");
                    break;
                } //THIS CODE IS TOO DIFFICULT AND LONG TO CREATE
            }
        }
    }
    
    }
}
