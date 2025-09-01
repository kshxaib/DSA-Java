import java.util.*;

public class Question3 {
    public static void main(String args[]){
        int inputNumber = 0;
        int fact = 1;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number to find factorial: ");
        inputNumber = sc.nextInt();

        for(int i=1; i<=inputNumber; i++){
            fact = fact * i;
        }
        System.out.printf("Factorial of %d is %d", inputNumber, fact);
    }
}
