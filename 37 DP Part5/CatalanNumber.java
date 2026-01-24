import java.util.Arrays;

public class CatalanNumber {

    /*
      Catalan Number

      Catalan numbers are used in many DP problems like:
      - Number of unique BSTs with n nodes
      - Number of valid parentheses combinations
      - Mountain ranges
      - Polygon triangulation

      Formula:
      C0 = 1
      C1 = 1

      Cn = Σ (Ci * C(n-i-1))   for i = 0 to n-1

      Meaning:
      - i elements go to LEFT part  -> Ci ways
      - (n-i-1) elements go to RIGHT part -> C(n-i-1) ways
      - Multiply leftWays * rightWays for each split
      - Add all splits to get Cn
    */

    // 1) Recursive Catalan
    public static int CN(int n) {

        // Base case:
        // C0 = 1, C1 = 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Stores result for Catalan(n)
        int ans = 0;

        // Try all possible splits: left=i, right=(n-i-1)
        for (int i = 0; i < n; i++) {
            ans += CN(i) * CN(n - i - 1);
        }

        return ans;
    }

    // 2) Memoization Catalan (Top-Down DP)
    public static int CNM(int n, int dp[]) {

        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // If already computed, return stored value
        if (dp[n] != -1) {
            return dp[n];
        }

        // Compute Catalan(n) only once
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += CNM(i, dp) * CNM(n - i - 1, dp);
        }

        // Store answer in dp[n]
        dp[n] = ans;

        return dp[n];
    }

    // 3) Tabulation Catalan (Bottom-Up DP)
    public static int CNT(int n) {

        /*
          dp[i] means:
          - Catalan number Ci

          We compute dp[0] to dp[n] iteratively
        */
        int dp[] = new int[n + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Build dp values from 2 to n
        for (int i = 2; i < n + 1; i++) {

            // Apply recurrence:
            // dp[i] = Σ (dp[j] * dp[i-j-1])
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
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

        // Tabulation answer
        System.out.println(CNT(n));
    }
}

/*
Complexities:

1) Recursive CN(n):
Time Complexity:
- Exponential (very slow)
  due to repeated subproblem calls

Space Complexity:
- O(n)
  recursion stack depth

2) Memoization CNM(n):
Time Complexity:
- O(n^2)
  because each dp[k] is computed once
  and requires looping from 0 to k-1

Space Complexity:
- O(n) dp array
- O(n) recursion stack
Total: O(n)

3) Tabulation CNT(n):
Time Complexity:
- O(n^2)
  nested loops: i from 2..n, j from 0..i-1

Space Complexity:
- O(n)
  dp array only
*/
