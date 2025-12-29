import java.util.*;

public class Knapsack {
    public static int knapsack(int val[], int wt[], int i, int W) {
        if (W == 0 || i == 0) {
            return 0;
        }

        if (wt[i - 1] <= W) {
            int ans1 = val[i - 1] + knapsack(val, wt, i - 1, W - wt[i - 1]);
            int ans2 = knapsack(val, wt, i - 1, W);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, i - 1, W);
        }
    }

    // Memoization
    public static int ks(int val[], int wt[], int i, int W, int dp[][]) {
        if (W == 0 || i == 0) {
            return 0;
        }

        if (dp[i][W] != -1) {
            return dp[i][W];
        }

        if (wt[i - 1] <= W) {
            int ans1 = val[i - 1] + ks(val, wt, i - 1, W - wt[i - 1], dp);
            int ans2 = ks(val, wt, i - 1, W, dp);
            dp[i][W] = Math.max(ans1, ans2);
            return dp[i][W];
        } else {
            dp[i][W] = ks(val, wt, i - 1, W, dp);
            return dp[i][W];
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(knapsack(val, wt, val.length, W));

        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(ks(val, wt, val.length, W, dp));
    }
}

/* 
1) Recursive Knapsack:
Time Complexity : O(2^n)
Space Complexity : O(n) (recursion stack)
  
2) Memoization (Top-Down DP):
Time Complexity : O(n * W)
Space Complexity : O(n * W) for dp table + O(n) recursion stack
*/