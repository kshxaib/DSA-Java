import java.util.*;

public class Knapsack {

    /*
      0/1 Knapsack (Recursive Approach)
      Meaning:
      - Each item can be taken only once (0/1 times)
      - Goal: maximize total value without exceeding capacity W

      Recursive Idea:
      - For each item, we have 2 options:
        1) Include it (if it fits)
        2) Exclude it
      - Take maximum value from both choices
    */
    public static int knapsack(int val[], int wt[], int i, int W) {

        // Base case:
        // If no items left OR capacity becomes 0, profit = 0
        if (W == 0 || i == 0) {
            return 0;
        }

        // If current item weight <= remaining capacity
        if (wt[i - 1] <= W) {

            // Include current item:
            // add its value and reduce remaining capacity
            int ans1 = val[i - 1] + knapsack(val, wt, i - 1, W - wt[i - 1]);

            // Exclude current item:
            // skip it and move to remaining items
            int ans2 = knapsack(val, wt, i - 1, W);

            // Return best option
            return Math.max(ans1, ans2);

        } else {
            // If item doesn't fit, only exclude it
            return knapsack(val, wt, i - 1, W);
        }
    }

    /*
      0/1 Knapsack (Memoization / Top-Down DP)

      dp[i][W] stores:
      - maximum value using first i items with capacity W

      Why use dp?
      - recursion repeats the same subproblems many times
      - dp stores the computed answer and reuses it
    */
    public static int ksM(int val[], int wt[], int i, int W, int dp[][]) {

        // Base case:
        // If no items OR capacity is 0, answer = 0
        if (W == 0 || i == 0) {
            return 0;
        }

        // If already computed, return stored answer
        if (dp[i][W] != -1) {
            return dp[i][W];
        }

        // If current item fits
        if (wt[i - 1] <= W) {

            // Option 1: Include current item
            int ans1 = val[i - 1] + ksM(val, wt, i - 1, W - wt[i - 1], dp);

            // Option 2: Exclude current item
            int ans2 = ksM(val, wt, i - 1, W, dp);

            // Store max result in dp table
            dp[i][W] = Math.max(ans1, ans2);
            return dp[i][W];

        } else {
            // If item doesn't fit, exclude it
            dp[i][W] = ksM(val, wt, i - 1, W, dp);
            return dp[i][W];
        }
    }

    /*
      0/1 Knapsack (Tabulation / Bottom-Up DP)

      dp[i][j] means:
      - maximum value using first i items with capacity j

      Table building:
      - Start from smaller subproblems (small i, small j)
      - Build answers step by step until dp[n][W]
    */
    public static int ksT(int val[], int wt[], int W) {
        int n = val.length;
        // dp array with (n+1) rows and (W+1) columns
        int dp[][] = new int[n + 1][W + 1];

        // Initialize base cases:
        // If capacity = 0, profit = 0 for all items
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // If items = 0, profit = 0 for all capacities
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        // Fill dp table row-wise
        // i = number of items considered
        // j = current capacity
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                // Current item value and weight (because arrays are 0-based)
                int v = val[i - 1];
                int w = wt[i - 1];

                // If item can fit into current capacity
                if (w <= j) {

                    // Include item:
                    // value + best profit from remaining capacity (j - w) using previous items
                    int ans1 = v + dp[i - 1][j - w];

                    // Exclude item:
                    // take profit from previous items with same capacity
                    int ans2 = dp[i - 1][j];

                    // Store maximum of both choices
                    dp[i][j] = Math.max(ans1, ans2);

                } else {
                    // If item weight > capacity, exclude it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer will be in dp[n][W]
        return dp[n][W];
    }

    public static void main(String[] args) {

        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        // Recursive answer
        System.out.println(knapsack(val, wt, val.length, W));

        int dp[][] = new int[val.length + 1][W + 1];
        // Initialize dp with -1 (means not computed yet)
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        // Memoization answer
        System.out.println(ksM(val, wt, val.length, W, dp));

        // Tabulation answer
        System.out.println(ksT(val, wt, W));
    }
}

/*
1) Recursive Knapsack:
Time Complexity : O(2^n)
Space Complexity : O(n)  (recursion stack)

2) Memoization (Top-Down DP):
Time Complexity : O(n * W)
Space Complexity : O(n * W) dp + O(n) recursion stack

3) Tabulation (Bottom-Up DP):
Time Complexity : O(n * W)
Space Complexity : O(n * W)
*/
