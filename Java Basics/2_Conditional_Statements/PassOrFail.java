import java.util.*;

public class PassOrFail {
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        int marks = sc.nextInt();

        String result = (marks >= 33)? "PASS" : "FAIL";
        System.out.print(result);
    }    
}
