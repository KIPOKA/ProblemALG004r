/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problemalg004r;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author lkkatabe
 */
public class ProblemALG004r {

    /**
     * @param args the command line arguments
     */
    private static void displayOutputMagic(int [][] magicSquare){
          int size = magicSquare.length;
         String rowCount="";
         for (int[] magicSquare1 : magicSquare) {
             for (int j = 0; j < magicSquare1.length; j++) {
                 rowCount = rowCount + magicSquare1[j] + "\t";
             }
             rowCount = rowCount.concat("\n");
         }
         System.out.println("A solution to a " +size +"X" +size+" Magic Square is:");
         System.out.println(rowCount);
         System.out.println("The  sum of each row, cloumn and diagonal is:"+ size * (size * size +1)/ 2);
         
     }
     
     public static int [][] generateMagicSquare(int size){
         int [][] magicSquare= new int[size][size];
         
         
         int row = size /2;
         int column = size -1;
         
            for (int i = 1; i <= size *size;) {
                if (row ==-1 && column == size) {
                    column = size -2;
                    row =0;
                    
                }else {
                if (column ==size) {
                        column =0;
                    }
                if (row <0){
                        row = size -1;
                    }
                }
                if(magicSquare[row][column] !=0){
                    column -=2;
                    row++;
                }else{
                    magicSquare[row][column] = i++;
                    column++;
                    row--;
                }
             
         }
         return magicSquare;
     }
    
    public static void main(String[] args) {
        
     boolean isOddNumber;
     int size;
     int [][] magicSquare;
    
      Scanner sc = new Scanner(System.in);
      //Allow the user to reenter the size if is not an odd number
      do{
        System.out.print("Enter size: ");
        size = sc.nextInt();
            if (size%2>0) {
            isOddNumber= true;
            //invoke the method to generate the magic square and display it
            magicSquare =generateMagicSquare(size);
            // display the magic square
            displayOutputMagic(magicSquare);
            }else{
                //validate the condition and display an error message 
                System.out.println(size +" is not an odd number. Provide with an odd number");
                isOddNumber = false;
            }
      }while(!isOddNumber);
        
    }
    
}
