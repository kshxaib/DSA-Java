import java.util.*;

class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 1, 2, prices, dp);
    }

    private int solve(int index, int buy, int transactions, int[] prices, int[][][] dp) {
        if (index == prices.length || transactions == 0) return 0;

        if (dp[index][buy][transactions] != -1) return dp[index][buy][transactions];

        int profit;

        if (buy == 1) {
            int buyStock = -prices[index] + solve(index + 1, 0, transactions, prices, dp);
            int skip = solve(index + 1, 1, transactions, prices, dp);
            profit = Math.max(buyStock, skip);

        } else {
            int sellStock = prices[index] + solve(index + 1, 1, transactions - 1, prices, dp);
            int skip = solve(index + 1, 0, transactions, prices, dp);
            profit = Math.max(sellStock, skip);
        }

        return dp[index][buy][transactions] = profit;
    }
}

