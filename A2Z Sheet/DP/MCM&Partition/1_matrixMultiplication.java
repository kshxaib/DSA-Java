import java.util.*;

class Solution1 {
    public int matrixMultiplication(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];  // dp[i][j] = minimum cost to multiply matrices i...j

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(1, n - 1, nums, dp);   // solve for all matrices
    }

    private int solve(int i, int j, int[] nums, int[][] dp) {
        if (i == j) return 0;   // only one matrix left

        if (dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;

        // try every partition
        for (int k = i; k < j; k++) {

            int left = solve(i, k, nums, dp);   // cost of left part
            int right = solve(k + 1, j, nums, dp);  // cost of right part            
            int multiplyCost = nums[i - 1] * nums[k] * nums[j]; // cost of multiplying both parts
            int totalCost = left + right + multiplyCost;

            minCost = Math.min(minCost, totalCost); // keep minimum cost
        }

        return dp[i][j] = minCost;
    }
}

