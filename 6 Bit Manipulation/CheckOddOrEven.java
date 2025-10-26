import java.util.*;

public class CheckOddOrEven {
    public static void checkIfOddOrEven(int binaryInput){
        int bitMask = 1;

        if((binaryInput & bitMask) == 0){
            System.out.printf("Binary number %d is Even.", binaryInput);
        } else {
            System.out.printf("Binary number %d is Odd.", binaryInput);
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        int input = sc.nextInt();

        checkIfOddOrEven(input);
    }
}
