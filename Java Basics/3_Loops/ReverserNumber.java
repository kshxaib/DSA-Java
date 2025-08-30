import java.util.*;

public class ReverserNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        int reverseNumber = 0;
        
        while (inputNumber > 0) {
            int lastDigit = inputNumber % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            inputNumber = inputNumber / 10;
        }
        System.out.print("Reversed number: " + reverseNumber);
    }   
}
