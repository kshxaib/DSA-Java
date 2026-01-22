public class Unbound {

    /*
      Unbounded Knapsack (Tabulation / Bottom-Up DP)

      Meaning:
      - We can take each item unlimited times (unbounded)
      - Goal: maximize total value without exceeding capacity W

      dp[i][j] means:
      - maximum value using first i items with capacity j
    */
    public static int UKS(int val[], int wt[], int W) {

        int n = val.length;

        // dp table size: (n+1) x (W+1)
        int dp[][] = new int[n + 1][W + 1];

        // Base case:
        // If capacity = 0, profit = 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        // Base case:
        // If items = 0, profit = 0 for any capacity
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        // Fill dp table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                // Current item value and weight (because val/wt are 0-indexed)
                int v = val[i - 1];
                int w = wt[i - 1];

                // If current item weight fits in current capacity
                if (w <= j) {

                    /*
                      Unbounded include case:
                      - If we include the item, we stay in same row (i)
                        because we can take this item again

                      include = v + dp[i][j - w]
                      exclude = dp[i - 1][j]
                    */
                    dp[i][j] = Math.max(v + dp[i][j - w], dp[i - 1][j]);

                } else {
                    // If item doesn't fit, we cannot include it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer
        return dp[n][W];
    }

    public static void main(String[] args) {

        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(UKS(val, wt, W));
    }
}

/*
Time Complexity:
- O(n * W)
  because we fill a table of size (n+1) x (W+1)

Space Complexity:
- O(n * W)
  due to dp table storage
*/
