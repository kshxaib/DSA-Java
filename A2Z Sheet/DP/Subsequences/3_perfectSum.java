import java.util.*;

class Solution1 {
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


class Solution2 {
    static final int MOD = 1000000007;

    public int perfectSum(int[] arr, int K) {
        int n = arr.length;

        int[][] dp = new int[n][K + 1];

        // Base case: one subset (empty set) makes sum 0
        dp[0][0] = 1;

        // If first element is <= K, mark dp[0][arr[0]] as 1
        if (arr[0] <= K) dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= K; target++) {
                // Exclude current element
                int notTake = dp[i - 1][target];

                // Include current element if possible
                int take = 0;
                if (arr[i] <= target){
                    take = dp[i - 1][target - arr[i]];
                }

                // Total ways
                dp[i][target] = notTake + take;
            }
        }

        return dp[n-1][K];
    }
}

