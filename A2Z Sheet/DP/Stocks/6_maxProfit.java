import java.util.*;

class Solution1 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 1, prices, fee, dp);
    }

    private int solve(int index, int buy, int[] prices, int fee, int[][] dp) {
        if (index == prices.length) return 0;

        if (dp[index][buy] != -1) return dp[index][buy];

        int profit;

        if (buy == 1) {
            int buyStock = -prices[index] + solve(index + 1, 0, prices, fee, dp);
            int skip = solve(index + 1, 1, prices, fee, dp);
            profit = Math.max(buyStock, skip);

        } else {
            int sellStock = prices[index] - fee + solve(index + 1, 1, prices, fee, dp);
            int skip = solve(index + 1, 0, prices, fee, dp);
            profit = Math.max(sellStock, skip);
        }

        return dp[index][buy] = profit;
    }
}


class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            dp[index][1] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);

            dp[index][0] = Math.max(prices[index] - fee + dp[index + 1][1], dp[index + 1][0]);
        }

        return dp[0][1];
    }
}