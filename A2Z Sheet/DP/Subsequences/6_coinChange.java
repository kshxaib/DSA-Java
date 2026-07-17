import java.util.*;

class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(n - 1, amount, coins, dp);

        return ans >= (int)1e9 ? -1 : ans;
    }

    private int solve(int index, int target, int[] coins, int[][] dp) {
        if (index == 0) {
            if (target % coins[0] == 0) return target / coins[0];
            return (int)1e9;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = solve(index - 1, target, coins, dp);

        int take = (int)1e9;
        if (coins[index] <= target) {
            take = 1 + solve(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = Math.min(take, notTake);
    }
}



class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // Base case
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0)
                dp[0][target] = target / coins[0];
            else
                dp[0][target] = (int)1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= amount; target++) {

                int notTake = dp[i - 1][target];

                int take = (int)1e9;
                if (coins[i] <= target) {
                    take = 1 + dp[i][target - coins[i]];
                }

                dp[i][target] = Math.min(take, notTake);
            }
        }

        int ans = dp[n - 1][amount];
        return ans >= (int)1e9 ? -1 : ans;
    }
}



class Solution3 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] prev = new int[amount + 1];

        // Base case
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0)
                prev[target] = target / coins[0];
            else
                prev[target] = (int)1e9;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];

            for (int target = 0; target <= amount; target++) {

                int notTake = prev[target];

                int take = (int)1e9;
                if (coins[i] <= target) {
                    take = 1 + curr[target - coins[i]];
                }

                curr[target] = Math.min(take, notTake);
            }

            prev = curr;
        }

        int ans = prev[amount];
        return ans >= (int)1e9 ? -1 : ans;
    }
}