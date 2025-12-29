public class ClimbingStairs {
    public static int countWays(int n){  //Time: O(2^n)
        if(n == 0) return 1;
        if(n < 0) return 0;

        return countWays(n-1) + countWays(n-2);
    }

    // Memoization
    public static int cW2(int n, int dp[]){ //Time: O(n)
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(dp[n] != 0){
            return dp[n];
        }

        dp[n] = cW2(n-1, dp) + cW2(n-2, dp);
        return dp[n];
    }

    //Tabulation
    public static int cW3(int n){   //Time: O(n)
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        System.out.println(cW3(n));
    }
}