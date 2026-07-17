import java.util.*;

class Solution1 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, amount, coins, dp);
    }

    private int solve(int index, int target, int[] coins, int[][] dp) {
        if (index == 0) {
            if (target % coins[0] == 0) return 1;
            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = solve(index - 1, target, coins, dp);

        int take = 0;
        if (coins[index] <= target) {
            take = solve(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = take + notTake;
    }
}



class Solution2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // Base case
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0) dp[0][target] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = dp[i - 1][target];

                int take = 0;
                if (coins[i] <= target) {
                    take = dp[i][target - coins[i]];
                }

                dp[i][target] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }
}



class Solution3 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount + 1];

        // Base case
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0) prev[target] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];

            for (int target = 0; target <= amount; target++) {
                int notTake = prev[target];

                int take = 0;
                if (coins[i] <= target) {
                    take = curr[target - coins[i]];
                }

                curr[target] = take + notTake;
            }

            prev = curr;
        }

        return prev[amount];
    }
}