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
        if (index == prices.length) return 0;

        if (dp[index][buy] != -1) return dp[index][buy];

        int profit;

        if (buy == 1) {
            int buyStock = -prices[index] + solve(index + 1, 0, prices, dp);
            int skip = solve(index + 1, 1, prices, dp);
            profit = Math.max(buyStock, skip);

        } else {
            int sellStock = prices[index] + solve(index + 1, 1, prices, dp);
            int skip = solve(index + 1, 0, prices, dp);
            profit = Math.max(sellStock, skip);
        }

        return dp[index][buy] = profit;
    }
}



class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {

                int profit;

                if (buy == 1) {
                    int buyStock = -prices[index] + dp[index + 1][0];
                    int skip = dp[index + 1][1];
                    profit = Math.max(buyStock, skip);

                } else {
                    int sellStock = prices[index] + dp[index + 1][1];
                    int skip = dp[index + 1][0];
                    profit = Math.max(sellStock, skip);
                }

                dp[index][buy] = profit;
            }
        }

        return dp[0][1];
    }
}


class Solution3 {
    public int maxProfit(int[] prices) {
        int[] ahead = new int[2];

        for (int index = prices.length - 1; index >= 0; index--) {
            int[] curr = new int[2];

            for (int buy = 0; buy <= 1; buy++) {

                int profit;

                if (buy == 1) {
                    int buyStock = -prices[index] + ahead[0];
                    int skip = ahead[1];
                    profit = Math.max(buyStock, skip);

                } else {
                    int sellStock = prices[index] + ahead[1];
                    int skip = ahead[0];
                    profit = Math.max(sellStock, skip);
                }

                curr[buy] = profit;
            }

            ahead = curr;
        }

        return ahead[1];
    }
}


class Solution4 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}