public class Factorial {
    public static int FindFactorial(int n){
        int factorial = 1;

        if (n <= 0){
            return factorial;
        }

        for(int i=1; i<=n; i++){
            factorial = factorial * i;
        }
        return factorial;
    }

    public static void main (String args[]){
        int result = FindFactorial(7);
        System.out.print(result);
    }
}
