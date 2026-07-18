import java.util.*;

class Solution1 {
    public int matrixMultiplication(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(1, n - 1, nums, dp);
    }

    private int solve(int i, int j, int[] nums, int[][] dp) {
        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = solve(i, k, nums, dp) + solve(k + 1, j, nums, dp) + nums[i - 1] * nums[k] * nums[j];
            minCost = Math.min(minCost, cost);
        }

        return dp[i][j] = minCost;
    }
}

