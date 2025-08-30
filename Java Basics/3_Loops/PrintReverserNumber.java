import java.util.*;

public class PrintReverserNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        
        while (inputNumber > 0) {
            int lastDigit = inputNumber % 10;
            System.out.print(lastDigit);
            inputNumber = inputNumber / 10;
        }
    }   
}
