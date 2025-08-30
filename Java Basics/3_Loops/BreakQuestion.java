import java.util.*;

public class BreakQuestion {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Enter number: ");
            int number = sc.nextInt();
            if(number % 10 == 0){
                break;
            }
            System.out.println("Entered number is: " + number);
        }
    }
}
