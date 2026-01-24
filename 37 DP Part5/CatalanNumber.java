import java.util.Arrays;

public class CatalanNumber {

    /*
      Catalan Number (Recursive + Memoization)

      Catalan numbers are used in problems like:
      - Count of unique BSTs with n nodes
      - Valid parentheses combinations
      - Mountain ranges
      - Triangulation of polygon

      Formula:
      C0 = 1
      C1 = 1

      Cn = Σ (Ci * C(n-i-1))
           for i = 0 to n-1

      Meaning:
      - i elements go to LEFT part
      - (n-i-1) elements go to RIGHT part
      - total ways for that split = leftWays * rightWays
      - sum all splits to get final answer
    */

    /*
      Catalan Number (Recursive)

      CN(n) means:
      - number of ways/structures possible for size n

      Recursive idea:
      - Try all partitions (i) for left side
      - Multiply left and right results
      - Add them to form CN(n)
    */
    public static int CN(int n) {

        // Base case:
        // CN(0) = 1, CN(1) = 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Store result for CN(n)
        int ans = 0;

        // Try all possible splits
        for (int i = 0; i < n; i++) {

            // Left part = CN(i)
            // Right part = CN(n-i-1)
            ans += CN(i) * CN(n - i - 1);
        }

        return ans;
    }

    /*
      Catalan Number (Memoization / Top-Down DP)

      dp[n] stores:
      - Catalan number CN(n)

      Benefit:
      - Avoids recalculating same values again and again
      - Reduces exponential recursion to O(n^2)
    */
    public static int CNM(int n, int dp[]) {

        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // If already computed, return stored answer
        if (dp[n] != -1) {
            return dp[n];
        }

        // Compute CN(n)
        int ans = 0;

        // Same recurrence, but using dp[] to store results
        for (int i = 0; i < n; i++) {
            ans += CNM(i, dp) * CNM(n - i - 1, dp);
        }

        // Store result in dp[n] and return
        return dp[n] = ans;
    }

    public static void main(String[] args) {
        int n = 4;

        // Recursive answer
        System.out.println(CN(n));

        // dp array for memoization
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        // Memoization answer
        System.out.println(CNM(n, dp));
    }
}

/*
1) Recursive Catalan:
Time Complexity:
- Exponential (very slow)
  because it recomputes the same subproblems many times

Space Complexity:
- O(n)
  due to recursion stack depth

2) Memoization Catalan (Top-Down DP):
Time Complexity:
- O(n^2)
  because for each CN(k), we loop i=0 to k-1 only once

Space Complexity:
- O(n) for dp array
- O(n) recursion stack
Total: O(n)
*/
