// Writeaprogramthatreadsasetof integers,and then prints the sum of the
//  even and odd integers.

import java.util.*;

public class Question2 {
    public static void main(String args[]){
        int exitNumber = 00;
        int inputNumber = 1;
        int evenSum = 0;
        int oddSum = 0;
        Scanner sc = new Scanner(System.in);

        while (inputNumber != exitNumber) {
            System.out.print("Enter number (enter 00 for exit): ");
            inputNumber = sc.nextInt();

            if(inputNumber % 2 == 0){
                evenSum = evenSum + inputNumber;
            } else {
                oddSum = oddSum + inputNumber;
            }
        }
        System.out.println("Addition even and odd numbers are: " + evenSum + " and " + oddSum);
    }
}