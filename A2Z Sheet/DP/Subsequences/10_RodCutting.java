import java.util.*;

class Solution1 {
    public int RodCutting(int[] price, int n) {
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, n, price, dp);
    }

    private int solve(int index, int length, int[] price, int[][] dp) {
        if (index == 0) {
            return length * price[0];
        }

        if (dp[index][length] != -1) return dp[index][length];

        int notTake = solve(index - 1, length, price, dp);

        int take = 0;
        int rodLength = index + 1;

        if (rodLength <= length) {
            take = price[index] + solve(index, length - rodLength, price, dp);
        }

        return dp[index][length] = Math.max(take, notTake);
    }
}