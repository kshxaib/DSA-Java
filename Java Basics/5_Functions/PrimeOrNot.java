public class PrimeOrNot {
    public static boolean isPrime(int n){
        boolean isPrime = true;

        if(n==2){
            return isPrime;
        }

        for(int i=2; i<=n-1; i++){
            if(n % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static boolean isPrimeOptimized(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        System.out.print(isPrimeOptimized(4));
    }
}
