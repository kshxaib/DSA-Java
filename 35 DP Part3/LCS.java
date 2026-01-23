public class LCS {

    /*
      LCS: Longest Common Subsequence (Recursive Approach)

      Meaning:
      - Find length of Longest Common Subsequence between two strings
      - Subsequence: characters must be in order, but not necessarily continuous

      lcs(str1, str2, n, m) means:
      - LCS length between:
        str1[0 ... n-1] and str2[0 ... m-1]
    */
    public static int lcs(String str1, String str2, int n, int m) {

        // Base case:
        // If any string becomes empty, no common subsequence possible
        if (n == 0 || m == 0) {
            return 0;
        }

        // If last characters match:
        // include this character and move both pointers back
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcs(str1, str2, n - 1, m - 1) + 1;
        }

        // If last characters do not match:
        // Try skipping one char from either string
        int ans1 = lcs(str1, str2, n - 1, m);
        int ans2 = lcs(str1, str2, n, m - 1);

        return Math.max(ans1, ans2);
    }

    /*
      LCS (Memoization / Top-Down DP)

      dp[n][m] stores:
      - LCS length between:
        str1[0 ... n-1] and str2[0 ... m-1]

      Benefit:
      - Avoids repeated recursive calls
      - Reduces exponential time to O(n*m)
    */
    public static int lcsM(String str1, String str2, int n, int m, int dp[][]) {

        // Base case
        if (n == 0 || m == 0) {
            return 0;
        }

        // If already solved, return stored value
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // If last characters match
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            dp[n][m] = lcsM(str1, str2, n - 1, m - 1, dp) + 1;
            return dp[n][m];
        }

        // If last characters do not match
        int ans1 = lcsM(str1, str2, n - 1, m, dp);
        int ans2 = lcsM(str1, str2, n, m - 1, dp);

        dp[n][m] = Math.max(ans1, ans2);
        return dp[n][m];
    }

    /*
      LCS (Tabulation / Bottom-Up DP)

      dp[i][j] means:
      - LCS length between:
        str1[0 ... i-1] and str2[0 ... j-1]

      Transition:
      1) If characters match:
         dp[i][j] = dp[i-1][j-1] + 1

      2) If characters do not match:
         dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    */
    public static int lcsT(String str1, String str2, int n, int m) {

        // dp table: (n+1) x (m+1)
        int dp[][] = new int[n + 1][m + 1];

        // Base case:
        // If one string length = 0, LCS = 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        // Fill dp table row-wise
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                // If current characters match
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    // If not match: take best result by skipping one character
                    int ans1 = dp[i - 1][j]; // skip from str1
                    int ans2 = dp[i][j - 1]; // skip from str2
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        // Final answer
        return dp[n][m];
    }

    public static void main(String[] args) {

        String str1 = "abcdge";
        String str2 = "abedg";

        int n = str1.length();
        int m = str2.length();

        // Recursive answer
        System.out.println(lcs(str1, str2, n, m));

        // Memoization dp table
        int dp[][] = new int[n + 1][m + 1];

        // Initialize dp with -1 for memoization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }

        // Memoization answer
        System.out.println(lcsM(str1, str2, n, m, dp));

        // Tabulation answer
        System.out.println(lcsT(str1, str2, n, m));
    }
}

/*
1) Recursive LCS:
Time Complexity: O(2^(n+m)) (exponential)
Space Complexity: O(n + m) (recursion stack)

2) Memoization LCS (Top-Down DP):
Time Complexity: O(n * m)
Space Complexity: O(n * m) + O(n + m) recursion stack

3) Tabulation LCS (Bottom-Up DP):
Time Complexity: O(n * m)
Space Complexity: O(n * m)
*/
