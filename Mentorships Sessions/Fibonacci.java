import java.util.*;

public class Fibonacci {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int firstTerm = 0;
        int secondTerm = 1;
        int thirdTerm = 0;

        for(int i=3; i<=n; i++){
            thirdTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = thirdTerm;
        }
        System.out.printf("%d th fibonacci term is %d: ", n, thirdTerm);
    }    
}
