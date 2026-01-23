public class RodCutting {

    /*
      Rod Cutting Problem (Tabulation / Bottom-Up DP)

      Meaning:
      - You have a rod of length = totRod
      - You can cut it into pieces of given lengths[]
      - Each piece of length has a given price[]
      - You can use a piece length multiple times (unlimited cuts)

      This is exactly like Unbounded Knapsack.

      dp[i][j] means:
      - maximum profit using first i lengths to make rod length j
    */
    public static int RC(int length[], int price[], int totRod) {

        int n = length.length;

        // dp table: (n+1) x (totRod+1)
        int dp[][] = new int[n + 1][totRod + 1];

        // Base case:
        // If rod length = 0, profit = 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        // Base case:
        // If no lengths available, profit = 0
        for (int j = 0; j < totRod + 1; j++) {
            dp[0][j] = 0;
        }

        // Fill dp table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totRod + 1; j++) {

                int prc = price[i - 1];   // current piece price
                int lg = length[i - 1];   // current piece length

                // If current piece can fit in rod length j
                if (lg <= j) {

                    /*
                      Two choices:

                      1) Include the current piece:
                         profit = price + dp[i][j - lg]
                         (stay in same row because piece can be reused)

                      2) Exclude the current piece:
                         profit = dp[i - 1][j]
                    */
                    dp[i][j] = Math.max(prc + dp[i][j - lg], dp[i - 1][j]);

                } else {
                    // If piece length is too large, cannot include it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer
        return dp[n][totRod];
    }

    public static void main(String[] args) {

        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[]  = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totalRod = 8;

        System.out.println(RC(length, price, totalRod)); // Output: 22
    }
}

/*
Time Complexity:
- O(n * totRod)

Space Complexity:
- O(n * totRod)
*/
