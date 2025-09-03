public class BinomialCoefficient {
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

    public static void main(String args[]){
        int nFact = FindFactorial(5);
        int rFact = FindFactorial(2);
        int n_rFact = FindFactorial(5-2);

        int result = nFact/(rFact * n_rFact);
        System.out.print("Binomial Coefficient: " + result);
    }
}
