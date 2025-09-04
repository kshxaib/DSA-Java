// Enter cost of 3 items from the user (using float data type)- a pencil, a pen and
//  an eraser. You have to output the total cost of the items back to the user as their bill.

import java.util.*;

public class Question3 {
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();

        float total = pencil + pen + eraser;
        float withGST = total + (0.18f * total); 
        System.out.println("Bill with 18% get: " + withGST);
    } 
}
