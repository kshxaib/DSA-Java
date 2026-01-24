public class MinimumPartitioning {

    /*
      Minimum Partitioning / Minimum Subset Sum Difference

      Meaning:
      - Divide array into 2 subsets S1 and S2
      - Minimize |sum(S1) - sum(S2)|

      Idea:
      - Total sum = sum
      - If we find one subset sum1 close to sum/2
      - Then other subset sum2 = sum - sum1
      - Difference = |sum1 - sum2|

      So we use 0/1 Knapsack:
      - Find maximum sum <= sum/2
    */
    public static int MP(int arr[]) {

        int n = arr.length;

        // Step 1: Find total sum of array
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Step 2: Knapsack capacity = sum/2
        int W = sum / 2;

        /*
          dp[i][j] means:
          - maximum subset sum possible using first i elements
            with capacity j
        */
        int dp[][] = new int[n + 1][W + 1];

        // Base case:
        // dp[i][0] = 0 (capacity 0 => sum 0)
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        // Base case:
        // dp[0][j] = 0 (0 elements => sum 0)
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        // Step 3: Fill dp table (0/1 Knapsack)
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                int v = arr[i - 1]; // current element value

                // If current element can fit
                if (v <= j) {

                    // Include or exclude
                    dp[i][j] = Math.max(v + dp[i - 1][j - v], dp[i - 1][j]);

                } else {
                    // If element doesn't fit, exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Step 4: Best subset sum close to sum/2
        int sum1 = dp[n][W];

        // Step 5: Other subset sum
        int sum2 = sum - sum1;

        // Minimum difference
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 11, 5 };

        // Output: 1
        System.out.println(MP(arr));
    }
}

/*
Time Complexity:
- O(n * W)
  where W = sum/2

Space Complexity:
- O(n * W)
  dp table storage
*/
