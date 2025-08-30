import java.util.*;

public class sumOfNatural {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int counter = 1;
        int sum = 0;

        while (counter <= n) {
            sum = sum + counter;
            counter++;
        }
        System.out.println("Sum: " + sum);
    }
}
