public class CoinChange {

    /*
      Coin Change (Number of Ways) - Unbounded
      Meaning:
      - We have infinite supply of each coin
      - Count total number of ways to make "sum"
      - Order does NOT matter (combinations)

      dp[i][j] means:
      - number of ways to make sum j using first i coins
    */
    public static int CC(int coins[], int sum) {
        int n = coins.length;

        // dp table: (n+1) x (sum+1)
        int dp[][] = new int[n + 1][sum + 1];

        // Base case:
        // If sum = 0, there is exactly 1 way (choose nothing)
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        // Base case:
        // If we have 0 coins, we cannot form any positive sum
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }

        // Fill dp table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                int coin = coins[i - 1];

                // If coin can be used (coin <= current sum j)
                if (coin <= j) {

                    /*
                      Two choices:

                      1) Include coin:
                         stay in same row (i) because coin can be reused
                         dp[i][j - coin]

                      2) Exclude coin:
                         move to previous row (i-1)
                         dp[i - 1][j]
                    */
                    dp[i][j] = dp[i][j - coin] + dp[i - 1][j];

                } else {
                    // Coin too large, cannot include it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 3 };
        int sum = 4;

        System.out.println(CC(coins, sum)); // Output: 4
    }
}

/*
Time Complexity:
- O(n * sum)
  because we fill a dp table of size (n+1) x (sum+1)

Space Complexity:
- O(n * sum)
  due to dp table storage
*/
