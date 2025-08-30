import java.util.*;

public class ContinueQuestion {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Enter number: ");
            int number = sc.nextInt();
            if(number % 10 == 0){
                continue;
            }
            System.out.println("Entered number is: " + number);
        }
    }
}