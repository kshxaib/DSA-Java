import java.util.*;

class Solution1 {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
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
            take = val[index] + solve(index, capacity - wt[index], wt, val, dp);
        }

        return dp[index][capacity] = Math.max(take, notTake);
    }
}





class Solution2 {

    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {

        int[][] dp = new int[n][W + 1];

        // Base case
        for (int capacity = 0; capacity <= W; capacity++) {
            if (wt[0] <= capacity) {
                dp[0][capacity] = val[0];
            }
        }

        for (int i = 1; i < n; i++) {

            for (int capacity = 0; capacity <= W; capacity++) {

                int notTake = dp[i - 1][capacity];

                int take = 0;
                if (wt[i] <= capacity) {
                    take = val[i] + dp[i][capacity - wt[i]];
                }

                dp[i][capacity] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][W];
    }
}




class Solution3 {

    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {

        int[] prev = new int[W + 1];

        // Base case
        for (int capacity = 0; capacity <= W; capacity++) {
            prev[capacity] = (capacity / wt[0]) * val[0];
        }

        for (int i = 1; i < n; i++) {

            int[] curr = new int[W + 1];

            for (int capacity = 0; capacity <= W; capacity++) {

                int notTake = prev[capacity];

                int take = 0;
                if (wt[i] <= capacity) {
                    take = val[i] + curr[capacity - wt[i]];
                }

                curr[capacity] = Math.max(take, notTake);
            }

            prev = curr;
        }

        return prev[W];
    }
}