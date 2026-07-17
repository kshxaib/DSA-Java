import java.util.*;

class Solution1 {
    public int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;

        int[][] dp = new int[n][W + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, W, wt, val, dp);
    }

    private int solve(int index, int capacity, int[] wt, int[] val, int[][] dp) {
        if (index == 0) {
            if (wt[0] <= capacity) return val[0];
            return 0;
        }

        if (dp[index][capacity] != -1) return dp[index][capacity];

        int notTake = solve(index - 1, capacity, wt, val, dp);

        int take = 0;
        if (wt[index] <= capacity) {
            take = val[index] + solve(index - 1, capacity - wt[index], wt, val, dp);
        }

        return dp[index][capacity] = Math.max(take, notTake);
    }
}