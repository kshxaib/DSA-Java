// Write a program to print the multiplication table of a number N, entered by the  user.

import java.util.*;

public class Question4 {
    public static void main(String args[]){
        int inputNumber = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to print table: ");
        inputNumber = sc.nextInt();

        for(int i=1; i<=10; i++){
            System.out.println(inputNumber + " x " + i + " = " + inputNumber*i);
        }
    }
}
