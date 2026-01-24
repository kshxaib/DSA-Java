public class MountainRanges {

    /*
      Mountain Ranges Problem (Catalan Number)

      Meaning:
      - Count number of valid mountain ranges using n pairs
        (like n upstrokes and n downstrokes)

      Condition:
      - At any point, downstrokes should never be more than upstrokes
        (same as valid parentheses condition)

      This follows Catalan numbers:
      dp[i] = number of valid mountain ranges for i pairs

      Recurrence:
      dp[i] = Σ (dp[j] * dp[i-j-1])
             for j = 0 to i-1
    */
    public static int MR(int n) {

        // dp[i] stores number of valid mountain ranges using i pairs
        int dp[] = new int[n + 1];

        // Base cases:
        // 0 pairs -> 1 way (empty)
        // 1 pair  -> 1 way
        dp[0] = 1;
        dp[1] = 1;

        // Build dp from 2 to n
        for (int i = 2; i < n + 1; i++) {

            // Try all partitions
            for (int j = 0; j < i; j++) {

                // "inside" mountain ranges count
                int inside = dp[j];

                // "outside" mountain ranges count
                int outside = dp[i - j - 1];

                // Total ways for this partition = inside * outside
                dp[i] += inside * outside;
            }
        }

        // Final answer
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;

        // For n = 4, answer = 14
        System.out.println(MR(n));
    }
}

/*
Time Complexity:
- O(n^2)
  because for each i we loop j from 0 to i-1

Space Complexity:
- O(n)
  dp array of size (n+1)
*/
