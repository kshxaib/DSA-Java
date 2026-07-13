import java.util.*;

class Solution {
    public int climbStairsM(int n) {  
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n <= 2) return n;

        if (dp[n] != -1) return dp[n];

        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }

    public int climbStairsT(int n){
        int dp[] = new int[n +1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int climbStairs(int n){
        if (n <= 2) return n;

        int prev = 2;
        int prev2 = 1;

        for(int i=3; i<=n; i++){
            int curr = prev + prev2;
            prev2 = prev; 
            prev = curr;
        }

        return prev;
    }
}