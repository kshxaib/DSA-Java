import java.util.*;

public class IncomeTax {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int income = sc.nextInt();

        if(income < 500000){
            System.out.printf("No taxes: %d", income);
        } else if (income > 500000 && income < 1000000){
            float totalAmt = income + (0.20f * income);
             System.out.printf("Amount after 20%% taxes: %.2f\n", totalAmt);
        } else {
            float totalAmt = income + (0.30f * income);
            System.out.printf("Amount after 30%% taxes: %.2f\n", totalAmt);
        }
    }    
}
