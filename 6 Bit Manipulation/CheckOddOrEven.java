import java.util.*;

public class CheckOddOrEven {
    public static void checkIfOddOrEven(int binaryInput){
        int LSB = binaryInput % 10; // Get the last binary digit (LSB)

        // In binary:
        // Last bit 0 => Even
        // Last bit 1 => Odd
        if(LSB == 0){
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
