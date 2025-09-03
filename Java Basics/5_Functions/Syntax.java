import java.util.*;

public class Syntax {
    public static void PrintName(){
        System.out.println("Khan Shoaib");
    }

    public static int CalculateSum(int a, int b){
        return a+b;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = CalculateSum(a,b);
        System.out.print(result);
    }
}