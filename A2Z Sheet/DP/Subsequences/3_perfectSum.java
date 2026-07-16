import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    public int perfectSum(int[] arr, int K) {
        int n = arr.length;

        int[][] dp = new int[n][K + 1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, K, arr, dp);
    }

    private int solve(int index, int target, int[] arr, int[][] dp) {

        if(target == 0) return 1;     // target achieved
        if(index == 0) { // only one element left
            if(arr[0] == target) return 1;
            else return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = solve(index - 1, target, arr, dp);

        int take = 0;
        if (arr[index] <= target){
            take = solve(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = (take + notTake) % MOD;
    }
}


