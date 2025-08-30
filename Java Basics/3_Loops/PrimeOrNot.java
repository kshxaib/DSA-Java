import java.util.*;

public class PrimeOrNot {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to check prime or not: ");
        int number = sc.nextInt();
        boolean isPrime = true;

        for(int i=2; i<=number-1; i++){
            if(number % i == 0){
                isPrime = false;
                break;
            }
        }

        if(isPrime){
            System.out.println("The number is prime.");
        } else {
            System.out.println("The number is not prime.");
        }
    }
}
