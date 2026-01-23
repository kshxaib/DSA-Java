public class LCS {

    /*
      Longest Common Substring (Tabulation / Bottom-Up DP)

      Meaning:
      - Find the length of the longest substring (continuous characters)
        that is common in both strings.

      Difference from LCS (subsequence):
      - Substring must be continuous
      - If mismatch happens, dp becomes 0

      dp[i][j] means:
      - length of longest common substring ending at:
        str1[i-1] and str2[j-1]
    */
    public static int lcs(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        // dp table: (n+1) x (m+1)
        int dp[][] = new int[n + 1][m + 1];

        // Stores final maximum substring length
        int subLg = 0;

        // Base case:
        // If one string is empty, longest common substring = 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        // Fill dp table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                // If characters match, extend previous substring length
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // Update maximum length found so far
                    subLg = Math.max(subLg, dp[i][j]);

                } else {
                    // If mismatch, substring must break
                    dp[i][j] = 0;
                }
            }
        }

        return subLg;
    }

    public static void main(String[] args) {

        String str1 = "ABCDE";
        String str2 = "ABGCE";

        System.out.println(lcs(str1, str2)); // Output: 2 "AB" 
    }
}

/*
Time Complexity:
- O(n * m)

Space Complexity:
- O(n * m)
*/
