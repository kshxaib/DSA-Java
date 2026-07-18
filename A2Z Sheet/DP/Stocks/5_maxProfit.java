import java.util.*;

class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 1, prices, dp);
    }

    private int solve(int index, int buy, int[] prices, int[][] dp) {
        if (index >= prices.length) return 0;

        if (dp[index][buy] != -1) return dp[index][buy];

        int profit;

        if (buy == 1) {
            int buyStock = -prices[index] + solve(index + 1, 0, prices, dp);
            int skip = solve(index + 1, 1, prices, dp);
            profit = Math.max(buyStock, skip);

        } else {
            int sellStock = prices[index] + solve(index + 2, 1, prices, dp);
            int skip = solve(index + 1, 0, prices, dp);
            profit = Math.max(sellStock, skip);
        }

        return dp[index][buy] = profit;
    }
}